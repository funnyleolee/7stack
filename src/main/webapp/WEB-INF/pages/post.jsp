<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/pages/include/home-resource.jsp" %>
<script type="text/javascript">
$(function(){
	$(window).resize(function(){
		fit();
	});
	fit();
	function fit(){
		var top = $(".footer").offset().top;
		var t2 = document.body.scrollTop | document.documentElement.scrollTop;
		$(".debug").html(document.body.scrollHeight>document.body.clientHeight);
		if(document.body.scrollHeight>document.body.offsetHeight){
			$(".footer").css({position:"fixed",bottom:0});
		}else{
			$(".footer").css({position:"static",bottom:"auto"});
		}
	}
	
});

</script>
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
                                <a class="btn btn-link" href="<s:url action='post-del'><s:param name='pid' value='post.id'/> </s:url>">
                                    <span class="icon-trash"></span>删除
                                </a>
                                <a class="btn btn-link" href="<s:url action='post-edit'><s:param name='pid' value='post.id'/> </s:url>">
                                    <span class="icon-pencil"></span>编辑
                                </a>
                            </div>
                        </s:if>
                    
                        <!-- JiaThis Button BEGIN -->
<div class="jiathis_style pull-right">
    <a class="jiathis_button_qzone"></a>
    <a class="jiathis_button_tsina"></a>
    <a class="jiathis_button_tqq"></a>
    <a class="jiathis_button_renren"></a>
    <a class="jiathis_button_kaixin001"></a>
    <a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
    <a class="jiathis_counter_style"></a>
</div>
<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js?uid=1346987081125257" charset="utf-8"></script>
<!-- JiaThis Button END -->
                        
                        
                        <hr style="margin:0 0 7px;clear:both;"/>
                    </div>
                    
	                <!-- start -->
	                <div class="comments ">
	                    <div class="hd">
	                        <div class="cfix">
	                            <span class="help-inline">3条评论</span> 
	                            <span class="help-inline"><a href="#" class="btn-link">发表评论</a></span>
	                        </div>
	                    </div>
	                    <div class="bd"></div>
	                    <div class="ft">
	                       <
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
    
    <jsp:include page="/WEB-INF/pages/include/home-foot.jsp" />
</body>
</html>