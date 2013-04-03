<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/pages/include/home-resource.jsp" %>
<link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/markdown.css'/>" />
<link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/jquery.scrollUp.tab.css'/>">
<script type="text/javascript" src="<s:url value='/resources/js/Markdown.Converter.js'/>"></script>
<script type="text/javascript" src="<s:url value='/resources/js/Markdown.Sanitizer.js'/>"></script>
<script type="text/javascript" src="<s:url value='/resources/js/Markdown.Editor.js'/>"></script>
<!--script type="text/javascript" src='<s:url value='/resources/js/date.js'/>'></script-->
<script type="text/javascript" src="<s:url value='/resources/js/jquery.scrollUp.min.js'/>"></script>
<script type="text/javascript">
$(function(){
    // 待验证
    $(window).resize(function(){
        fit();
    });
    fit();
    function fit(){
        var top = $(".footer").offset().top;
        var t2 = document.body.scrollTop | document.documentElement.scrollTop;
        $(".debug").html(document.body.scrollHeight>document.body.clientHeight);
        if(document.body.scrollHeight>document.body.offsetHeight){
            $(".footer").css({position:"fixed",bottom:0,width:"100%"});
        }else{
            $(".footer").css({position:"static",bottom:"auto",width:"100%"});
        }
    }
    // markdown 编辑器
    var converter = Markdown.getSanitizingConverter();
    converter.hooks.chain("preBlockGamut", function (text, rbg) {
        return text.replace(/^ {0,3}""" *\n((?:.*?\n)+?) {0,3}""" *$/gm, function (whole, inner) {
            return "<blockquote>" + rbg(inner) + "</blockquote>\n";
        });
    });
    var editor = new Markdown.Editor(converter);
    editor.run();
    
   //发布评论
   $("#comment-from").submit(function(){
	   if($.trim($(".comment-content").val())){
		   return false;
	   }
	   return true;
   });
   $(".comment-link").click(function(){
	   $("#wmd-input").focus();
	   return true;
   });
   $(".comment-time").each(function(){
	   if($.trim(this.value) && ! isNaN(this.value)){
		   //var time = moment(parseInt(this.value));
		   //alert(time.format("YYYY-MM-DD HH:mm"));
		   //$(this).after(time.format("YYYY-MM-DD HH:mm"));
	   }
   });
   //回顶部
   $.scrollUp({
       scrollName: 'scrollUp', // Element ID
       topDistance: '300', // Distance from top before showing element (px)
       topSpeed: 300, // Speed back to top (ms)
       animation: 'fade', // Fade, slide, none
       animationInSpeed: 200, // Animation in speed (ms)
       animationOutSpeed: 200, // Animation out speed (ms)
       scrollText: '回顶部', // Text for element
       activeOverlay: false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
   });
});
function toPage(pageNo){
	
}
</script>
<style type="text/css">
.pagination{
    margin: 0;
}
</style>
<title><s:property value="post.title" /></title>
</head>
<body>
    <jsp:include page="/WEB-INF/pages/include/home-head.jsp" />
    <div class="debug"></div>
    <div class="container-fluid stack-content">
        <div class="row-fluid">
            <!-- right -->
            <div class="span9 rht">
                <div class="doc c-fix">
                    <h4>
                        <span class="title"><s:property value="post.title" /></span>
                    </h4>
                    <div class="author">
                        <strong><s:property value="post.author.userName"/></strong>
                    </div>
                    <div class="content">
                        <s:property value="post.content" escape="false" />
                    </div>
                    <div class="doc-foot">
                    <s:if test="#loginUser != null && #loginUser.id == post.authorId">
                            <div class="pull-right">
                                <a class="btn btn-link" href="<s:url action='post-del'><s:param name='pid' value='post.postId'/> </s:url>">
                                    <span class="icon-trash"></span>删除
                                </a>
                                <a class="btn btn-link" href="<s:url action='post-edit'><s:param name='pid' value='post.postId'/> </s:url>">
                                    <span class="icon-pencil"></span>编辑
                                </a>
                            </div>
                        </s:if>
                        <!-- AddThis Button BEGIN -->
						<div class="addthis_toolbox addthis_default_style help-block">
						<a class="addthis_button_preferred_1"></a>
						<a class="addthis_button_preferred_2"></a>
						<a class="addthis_button_preferred_3"></a>
						<a class="addthis_button_preferred_4"></a>
						<a class="addthis_button_compact"></a>
						<a class="addthis_counter addthis_bubble_style"></a>
						</div>
						<script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=xa-5139586d601bf950"></script>
						<!-- AddThis Button END -->
                        <hr style="margin:0 0 7px;clear:both;"/>
                    </div>
                    
                    <!-- start -->
                    <div class="comments ">
                        <div class="hd">
                            <div class="cfix">
                                <span class="help-inline"><s:property value="post.commentList.size()"/>条评论</span>
								<s:if test="#session['session-me.sevenstack.web.model.user'] eq null">
								<span class="help-inline pull-right">
									<a class="btn-link" href="<s:url namespace='/account' action='sign-in'/>">登录</a> 后发表评论，还没有帐号？现在 
									<a class="btn-link" href="<s:url namespace='/account' action='sign-up'/>">注册</a>
									</span>
								</s:if>
								<s:else>
								    <span class="help-inline"><a href="#comment" class="btn-link comment-link">发表评论</a></span>
								</s:else>
                            </div>
                        </div>
                        
                        <div class="bd">
                               <ul>
                                   <s:iterator value="post.commentList">
                                       <li>
                                           <div class="pull-left" style="width:5%;">
                                               <img src="<s:url value='/resources/img/u-mini.png'/>">
                                           </div>
                                           <div class="pull-left" style="width:95%">
                                               <div class="row-title">
                                                   <a href="#" class="btn-link"><s:property value="user.userName"/> </a>@ 
                                                   <s:property value="createDate"/>
                                                   <input type="hidden" value="<s:property value='createTime'/>" class="comment-time">
                                                   <a href="#" class="btn-link pull-right">回复</a>
                                               </div>
                                               <div class="row-content"><s:property value="htmlContent" escape="false"/></div>
                                           </div>
                                       </li>
                                   </s:iterator>
                                   <s:if test="pagination.pageContent != ''">
	                                   <li>
	                                       
	                                       <form action="<s:url value='post/%{postId}'/>" id="comment-page-form">
	                                           <s:property value="pagination.pageContent" escape="false"/>
	                                       </form>
	                                   </li>
                                   </s:if>
                                   
                                   <li>
                                   <div class="pagination pagination-small pagination-right">
		                                <ul>
		                                    <li class="disabled">
		                                        <span>Prev</span>
		                                    </li>
		                                    <li class="active"><span>1</span></li>
		                                    <li><a href="#">2</a></li>
		                                </ul>
		                            </div>
                                   </li>
                                   <s:if test="#session['session-me.sevenstack.web.model.user'] != null">
                                   <li>
                                       <s:form action="save-comment" namespace="/post" id="comment-from" theme="simple">
                                           <a href="#comment" name="comment"></a>
                                           <input type="hidden" name="comment.postId" value="<s:property value='post.postId'/>">
	                                       <div class="control-group">
		                                        <div class="controls">
		                                            <!--textarea rows="5" style="width:95%;"></textarea-->
		                                            <!-- markdown editor -->
		                                            <div class="wmd-panel">
		                                                <div id="wmd-button-bar"></div>
		                                                <textarea class="wmd-input" id="wmd-input" name="comment.content" class="comment-content"></textarea>
		                                            </div>
		                                            <div id="wmd-preview" class="wmd-panel wmd-preview"></div>
		                                            <!-- editor end -->
		                                        </div>
		                                    </div>
		                                    <div class="control-group">
		                                        <div class="controls">
		                                            <s:submit value="发表评论" cssClass="btn"/>
		                                        </div>
		                                    </div>
	                                    </s:form>
                                   </li>
                                   </s:if>
                               </ul>
                            
                            
                            <!--a href="#" class="btn-link">1</a>
                            <a href="#" class="btn-link">2</a>
                            <a href="#" class="btn-link">3</a>
                            ...
                            <a href="#" class="btn-link">365</a>
                            <a href="#" class="btn-link">next</a-->
                        </div>
                    </div>
                    <!-- end -->
                </div>
                
            </div>
            <!-- right end -->
            <!-- left -->
            <div class="span3 lft"></div>
        </div>
    </div>
    <!--a id="scrollUp" title="回顶部">回顶部</a-->
    <jsp:include page="/WEB-INF/pages/include/home-foot.jsp" />
</body>
</html>