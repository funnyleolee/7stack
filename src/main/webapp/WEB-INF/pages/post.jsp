<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/pages/include/home-resource.jsp" %>
<script type="text/javascript">
$(function(){
	var hv = window.screen.availHeight-$("body").children(":first").height()-$("body").children(":last").height()-44;
	$(".stack-content").css({"min-height":hv});
});

</script>
<title><s:property value="post.title" /></title>
</head>
<body>
    <jsp:include page="/WEB-INF/pages/include/home-head.jsp" />
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
                    <hr style="margin:0 0 7px;clear:both;"/>
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
                        
                        
                        
                    </div>
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