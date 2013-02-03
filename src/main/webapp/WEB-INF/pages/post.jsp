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
<title>Home</title>
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
                        <hr/>
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