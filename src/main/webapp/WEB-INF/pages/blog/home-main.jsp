<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="container-fluid stack-content">
  <div class="row-fluid">
    <!-- right -->
    <div class="span9 rht">
      <s:iterator value="postList">
        <div class="doc">
          <h4><s:property value="title"/></h4>
          <div>
            <s:property value="summary" escape="false"/>
          </div>
        </div>
      </s:iterator>
      
      <!--div class="doc">
        <h4>学习使用cucumber</h4>
        <div>Kuler是一款倍受专业网页设计人员喜爱的工具，它在配色方案中增加了社会化媒体和网络因素，设计人员使用Adobe注册账号登陆后可以创建调色板并且互相分享，也可以根据自己的需求修改别人的调色板。颜色显示格式包括RGB，CMYK，LAB和HSV。 <div><img src="<s:url value='/tmp/example.png'/>" class="img-polaroid"></div>创作灵感有时候来的很突然，也许偶然在网上看到的一张图片就会是你产生一个完美的配色方案。这个工具支持上传JPG和PNG格式的图片，并且会对图片色彩显示做详细分解。 
        </div>
      </div>
      <div class="doc">
        <h4>学习使用cucumber</h4>
        <div>Kuler是一款倍受专业网页设计人员喜爱的工具，它在配色方案中增加了社会化媒体和网络因素，设计人员使用Adobe注册账号登陆后可以创建调色板并且互相分享，也可以根据自己的需求修改别人的调色板。颜色显示格式包括RGB，CMYK，LAB和HSV。 <div><img src="tmp/example.png" class="img-polaroid"></div>创作灵感有时候来的很突然，也许偶然在网上看到的一张图片就会是你产生一个完美的配色方案。这个工具支持上传JPG和PNG格式的图片，并且会对图片色彩显示做详细分解。 
        </div>
      </div-->
      
    </div>
    <!-- right end -->
    <!-- left -->
    <div class="span3 lft">
      <!-- search -->
      <div class="search-box">
        <form class="form-search">
          <div class="input-append" width="100%">
            <input type="text"  placeholder="请输入关键字">
            <a class="btn" href="#">
              <li class="icon-search"></li>
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