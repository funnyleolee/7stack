<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/pages/include/home-resource.jsp" %>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/jquery.scrollUp.tab.css'/>">
<script type="text/javascript" src="<s:url value='/resources/js/jquery.scrollUp.min.js'/>"></script>
<script type="text/javascript">
$(function(){
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
		// 分页靠右
	   $(".pagination").addClass("pagination-right");
});
function toPage(pageNo){
	location = "<s:url value='/'/>?page="+pageNo;
}
</script>
<style type="text/css">
.title-link {
	color: #2a2e35;
	text-decoration: none;
	font-size: 1.3em;
	font-weight: normal;
	font-family: 'Text Me One', '微软雅黑', '宋体', sans-serif;
}

.author {
	margin: 10px 0 15px;
}

.author .components-ul {
	display: inline-block;
	text-align: center;
	list-style: none;
}

.doc-bottom {
	padding-top: 10px;
}

.tag-bar .tag-ul {
	list-style: none;
	margin-left: 0;
}

.tag-bar .tag-ul li {
	padding-left: 5px;
	float: left;
}

.tag-bar .tag-ul li .btn-link {
	text-decoration: underline;
}
</style>
</head>
<body>
    <jsp:include page="/WEB-INF/pages/include/home-head.jsp" />
    <div class="container-fluid stack-content">
      <div class="row-fluid">
        <!-- right -->
        <div class="span9 rht">
          <s:iterator value="postList">
            <div class="doc">
              <span class="title">
                  <a class="title-link" href="<s:url value='post/%{postId}'/>">
                      <s:property value="title"/>
                  </a>
              </span>
              <div class="author cfix">
                <div class="pull-left">
                    <a href="javascript:;">
                        <img src='<s:url value="/resources/img/user.png"/>'>
                    </a>
                    <s:property value="author.userName"/> | <s:property value="enCreateDate"/>
                </div>
                <div class="pull-right">
                  <ul class="components-ul">
                    <li>
                        <button style="border: none;width: 16px;height:16px; background: url('<s:url value="/resources/img/comments.png"/>');margin-bottom:-5px;"></button>
                    </li>
                    <li>
                        <a class="btn-link" href="javascript:;">10</a>
                    </li>
                  </ul>
                  <ul class="components-ul">
                    <li>
                        <button style="border: none;width: 16px;height:16px; background: url('<s:url value="/resources/img/star_outline.png"/>');"></button>
                    </li>
                    <li>
                        <a class="btn-link" href="javascript:;">0</a>
                    </li>
                  </ul>
                </div>
                
              </div>
              <div class="summary">
                <s:property value="summary" escape="false"/>
              </div>
              <div class="doc-bottom">
                  <div class="tag-bar cfix">
                       <ul class="tag-ul">
                           <li>
                               <span class="icon-tags"></span>
                           </li>
                           <li><a href="#" class="btn-link">design</a></li>
                           <li><a href="#" class="btn-link">Go!</a></li>
                           <li><a href="#" class="btn-link">tumblr</a></li>
                           <li><a href="#" class="btn-link">bad piggies</a></li>
                           <li><a href="#" class="btn-link">EA</a></li>
                       </ul>
                  </div>
                  <div style="text-align: right;"><a href="<s:url value='post/%{postId}'/>" class="btn btn-link">Read More...</a></div>
              </div>
            </div>
          </s:iterator>
          <s:if test="pagination.pageContent != ''">
	    	  <div>
	    	  	<s:property value="pagination.pageContent" escape="false"/>
	    	  </div>
          </s:if>
        </div>
        <!-- right end -->
        <!-- left -->
        <div class="span3 lft">
          <!-- search -->
          <div class="search-box">
            <form class="form-search">
              <div class="input-append">
                <input type="text"  placeholder="请输入关键字">
                <a class="btn" href="#">
                  <span class="icon-search"></span>
                </a>
              </div>
            </form>
          </div>
          <!-- search end -->
          <!-- test -->
          <div class="side">
            <div class="side-title" >推荐文章</div>
            <div class="site-body">
              <ul class="unstyled">
                <li><a href="#"><span class="icon-file"></span>12年的水果饼干</a></li>
                <li><a href="#"><span class="icon-file"></span>12年的水果饼干</a></li>
                <li><a href="#"><span class="icon-file"></span>12年的水果饼干</a></li>
                <li><a href="#"><span class="icon-file"></span>12年的水果饼干</a></li>
                <li><a href="#"><span class="icon-file"></span>12年的水果饼干</a></li>
              </ul>
            </div>
            <div class="side-end">
              <a href="#" class="btn btn-link black-color">更多...</a>
            </div>
          </div>
          <div class="side">
            <div class="side-title" >常用标签</div>
            <div class="site-body">
              <span class="label">万恶的资本主意</span>
              <span class="label label-info">海边的卡夫卡</span>
              <span class="label label-important">三条腿的驴</span>
              <span class="label label-warning"><a href="#">白雪公主</a></span>
              <span class="label label-warning"><a href="#">落日黄昏</a></span>
              <span class="label label-warning"><a href="#">放牛班的春天</a></span>
            </div>
          </div>
          <div class="side">
            <div class="side-title" >热搜关键词</div>
            <div class="site-body">
            </div>
          </div>
          <!-- test end -->
        </div>
        <!-- left end -->
      </div>
    </div>
    <script type="text/javascript">
   /*  $(".doc .summary").each(function(){
        // 显示一张图片
        var first = $(this).find("img:first");
        var imgParent = $(this).find("img").parents();
        $(this).find("img").remove();
        imgParent.each(function(){
            if($.trim($(this).html()) == ""){
                $(this).remove();
            }
        }); */
        //删除空标记
        //$("div,span,p,li,ul").is(":empty").remove();
        //$(this).prepend($("<div>").css({"text-align":"center",margin:"12px 0"}).append(first.css({"max-width":"none",width:"100%"})));
    //});
    </script>
    <jsp:include page="/WEB-INF/pages/include/home-foot.jsp" />
</body>
</html>
