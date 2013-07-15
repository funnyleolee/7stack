<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String contextPath = request.getContextPath();
request.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/post.base.css'/>">
<link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/bootstrap-wysihtml5.css'/>">

<%@include file="/WEB-INF/pages/include/home-resource.jsp" %>
<script type="text/javascript" src="<s:url value='/resources/js/wysihtml5-0.3.0.min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/resources/js/bootstrap-wysihtml5-0.0.2.min.js'/>"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/ckeditor/4.0.1/ckeditor.js"></script>
<script type="text/javascript">
$(function(){
	//$('#context').wysihtml5({"color": true,"html": true});
	// tag
	$("#tag-input").focus(function(){
		genTagCtx($(this));
	}).keydown(function(){
		genTagCtx($(this));
	}).blur(function(){
		$(this).siblings(".tag-menu").remove();
	});
	
});
function genTagCtx(obj){
	obj.siblings(".tag-menu").remove();
	obj.val($.trim(obj.val()));
    var tagMenu = $("<div>").addClass("tag-menu");
    var tagMenuUl = $("<ul>");
    tagMenu.html(tagMenuUl);
    if(obj.val() != ""){
    	var owerLi = $("<li>").html(obj.val());
        owerLi.append($("<button>").addClass("btn btn-mini btn-primary pull-right").html("添加"));
        tagMenuUl.append(owerLi);
        $.getJSON("<s:url value='access/tag_list'/>",{tagName:obj.val()},function(data){
        	if(data){
        		$.each(data,function(i,obj){
        			owerLi.before($("<li>").html(obj.tagName));
                });
        	}
        });
    }else{
        tagMenuUl.html("<li>").css({"background": "#e0e0e0"}).html("请输入标签名称");
    }
    
    obj.after(tagMenu);
}
</script>
<title>编辑博客</title>
<style type="text/css">
hr {
	margin: 2px 0 10px;
}
.tag-box{
    position: relative;
}
.tag-menu{
    border: 1px solid #ccc;
    width:300px;
    position: absolute;
    top: 29px;
    z-index: 999;
}
.tag-menu>ul{
    list-style: none;
    margin:0;
    padding: 0;
}
.tag-menu>ul>li{
    padding: 4px 6px;
    background: #fff;
    height: 20px;
    line-height: 20px;
}

.tag-menu>ul>li:HOVER{
    background: #dfeaf4;
    cursor: pointer;
}
</style>
</head>
<body>
	<div class="main-container">
	    <jsp:include page="/WEB-INF/pages/include/home-head.jsp" />
	    <div class="container stack-content">
	        <div class="doc span8">
	            <s:form action="post-edit" method="post">
	                <input type="hidden" name="post.postId" value="<s:property value='post.postId'/>">
	                <legend>写博客</legend>
	                <div class="control-group">
	                    <label class="control-label" id="title">标题</label>
	                    <div class="controls">
	                        <input type="text" class="input-xxlarge" id="title" name="post.title" value="<s:property value='post.title'/>">
	                    </div>
	                </div>
	                <div class="control-group">
	                    <label class="control-label" for="content">正文
	                    </label>
	                    <hr/>
	                    <div class="controls">
	                        <textarea id="context" name="post.content"><s:property value="post.content"/></textarea>
	                        <script type="text/javascript">//<![CDATA[
	                            CKEDITOR.replace('context');
	                        //]]>
	                        </script>
	                    </div>
	                </div>
	                <div class="control-group">
	                   <div class="controls">
	                       <span class="icon-tags"></span><span class="help-inline">标签</span>
	                       <div style="clear: both;"></div>
	                       <hr class="c-fix">
	                       <div class="tag-box">
	                           <input type="text" value="" class="simple-box" id="tag-input" placeholder="添加标签" style="border-radius: 0px;float: none;">
                               <!--div class="tag-menu">
                                  <ul>
                                      <li style="background: #e0e0e0;">请输入标签名称</li>
                                      <li>sdfsdfsdf</li>
                                      <li>sdfsdfsdf</li>
                                      <li>sdfsdfsdf</li>
                                      <li>sdfsdfsdf</li>
                                      <li>
                                        sfsfsdf <button class="btn btn-mini btn-primary pull-right">添加</button>
                                      </li>
                                  </ul>
                               </div-->
	                       </div>
	                   </div>
	                </div>
	                <div class="control-group">
	                    <div class="controls">
	                        <input type="submit" class="btn btn-primary pull-right" value="发表">
	                    </div>
	                </div>
	            </s:form>
	        </div>
	    </div>
	    <jsp:include page="/WEB-INF/pages/include/home-foot.jsp" />
    </div>
</body>
</html>