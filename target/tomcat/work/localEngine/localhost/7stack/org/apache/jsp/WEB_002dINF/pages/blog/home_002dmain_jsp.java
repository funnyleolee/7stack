package org.apache.jsp.WEB_002dINF.pages.blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_002dmain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvalue;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fescape_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvalue = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fescape_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvalue.release();
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fescape_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<div class=\"container-fluid stack-content\">\n");
      out.write("  <div class=\"row-fluid\">\n");
      out.write("    <!-- right -->\n");
      out.write("    <div class=\"span9\">\n");
      out.write("      ");
      if (_jspx_meth_s_005fiterator_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("      \n");
      out.write("      <!--div class=\"doc\">\n");
      out.write("        <h4>学习使用cucumber</h4>\n");
      out.write("        <div>Kuler是一款倍受专业网页设计人员喜爱的工具，它在配色方案中增加了社会化媒体和网络因素，设计人员使用Adobe注册账号登陆后可以创建调色板并且互相分享，也可以根据自己的需求修改别人的调色板。颜色显示格式包括RGB，CMYK，LAB和HSV。 <div><img src=\"");
      if (_jspx_meth_s_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" class=\"img-polaroid\"></div>创作灵感有时候来的很突然，也许偶然在网上看到的一张图片就会是你产生一个完美的配色方案。这个工具支持上传JPG和PNG格式的图片，并且会对图片色彩显示做详细分解。 \n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"doc\">\n");
      out.write("        <h4>学习使用cucumber</h4>\n");
      out.write("        <div>Kuler是一款倍受专业网页设计人员喜爱的工具，它在配色方案中增加了社会化媒体和网络因素，设计人员使用Adobe注册账号登陆后可以创建调色板并且互相分享，也可以根据自己的需求修改别人的调色板。颜色显示格式包括RGB，CMYK，LAB和HSV。 <div><img src=\"tmp/example.png\" class=\"img-polaroid\"></div>创作灵感有时候来的很突然，也许偶然在网上看到的一张图片就会是你产生一个完美的配色方案。这个工具支持上传JPG和PNG格式的图片，并且会对图片色彩显示做详细分解。 \n");
      out.write("        </div>\n");
      out.write("      </div-->\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("    <!-- right end -->\n");
      out.write("    <!-- left -->\n");
      out.write("    <div class=\"span3\">\n");
      out.write("      <!-- search -->\n");
      out.write("      <div class=\"search-box\">\n");
      out.write("        <form class=\"form-search\">\n");
      out.write("          <div class=\"input-append\" width=\"100%\">\n");
      out.write("            <input type=\"text\"  placeholder=\"请输入关键字\">\n");
      out.write("            <a class=\"btn\" href=\"#\">\n");
      out.write("              <li class=\"icon-search\"></li>\n");
      out.write("            </a>\n");
      out.write("          </div>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("      <!-- search end -->\n");
      out.write("      <!-- test -->\n");
      out.write("      <div class=\"side\">\n");
      out.write("        <div class=\"side-title\" >推荐文章</div>\n");
      out.write("        <div class=\"site-body\">\n");
      out.write("          <ul class=\"unstyled\">\n");
      out.write("            <li><a href=\"#\"><span class=\"icon-file\"></span>12年的水果饼干</a></li>\n");
      out.write("            <li><a href=\"#\"><span class=\"icon-file\"></span>12年的水果饼干</a></li>\n");
      out.write("            <li><a href=\"#\"><span class=\"icon-file\"></span>12年的水果饼干</a></li>\n");
      out.write("            <li><a href=\"#\"><span class=\"icon-file\"></span>12年的水果饼干</a></li>\n");
      out.write("            <li><a href=\"#\"><span class=\"icon-file\"></span>12年的水果饼干</a></li>\n");
      out.write("          </ul>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"side-end\">\n");
      out.write("          <a href=\"#\" class=\"btn btn-link black-color\">更多...</a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"side\">\n");
      out.write("        <div class=\"side-title\" >常用标签</div>\n");
      out.write("        <div class=\"site-body\">\n");
      out.write("          <span class=\"label\">javascript</span>\n");
      out.write("          <span class=\"label label-info\">海边的卡夫卡</span>\n");
      out.write("          <span class=\"label label-important\">三条腿的驴</span>\n");
      out.write("          <span class=\"label label-warning\"><a href=\"#\">Golang</a></span>\n");
      out.write("          <span class=\"label label-warning\"><a href=\"#\">Golang</a></span>\n");
      out.write("          <span class=\"label label-warning\"><a href=\"#\">Golang</a></span>\n");
      out.write("          <span class=\"label label-warning\"><a href=\"#\">Golang</a></span>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"side\">\n");
      out.write("        <div class=\"side-title\" >热搜关键词</div>\n");
      out.write("        <div class=\"site-body\">\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <!-- test end -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- left end -->\n");
      out.write("  </div>\n");
      out.write("</div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_005fiterator_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:iterator
    org.apache.struts2.views.jsp.IteratorTag _jspx_th_s_005fiterator_005f0 = (org.apache.struts2.views.jsp.IteratorTag) _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvalue.get(org.apache.struts2.views.jsp.IteratorTag.class);
    _jspx_th_s_005fiterator_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fiterator_005f0.setParent(null);
    // /WEB-INF/pages/blog/home-main.jsp(8,6) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setValue("postList");
    int _jspx_eval_s_005fiterator_005f0 = _jspx_th_s_005fiterator_005f0.doStartTag();
    if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fiterator_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fiterator_005f0.doInitBody();
      }
      do {
        out.write("\n");
        out.write("        <div class=\"doc\">\n");
        out.write("          <h4>");
        if (_jspx_meth_s_005fproperty_005f0(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
          return true;
        out.write("</h4>\n");
        out.write("          <div>\n");
        out.write("            ");
        if (_jspx_meth_s_005fproperty_005f1(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("          </div>\n");
        out.write("        </div>\n");
        out.write("      ");
        int evalDoAfterBody = _jspx_th_s_005fiterator_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fiterator_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvalue.reuse(_jspx_th_s_005fiterator_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvalue.reuse(_jspx_th_s_005fiterator_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f0 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /WEB-INF/pages/blog/home-main.jsp(10,14) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f0.setValue("name");
    int _jspx_eval_s_005fproperty_005f0 = _jspx_th_s_005fproperty_005f0.doStartTag();
    if (_jspx_th_s_005fproperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f1 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fescape_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /WEB-INF/pages/blog/home-main.jsp(12,12) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f1.setValue("content");
    // /WEB-INF/pages/blog/home-main.jsp(12,12) name = escape type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f1.setEscape(false);
    int _jspx_eval_s_005fproperty_005f1 = _jspx_th_s_005fproperty_005f1.doStartTag();
    if (_jspx_th_s_005fproperty_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fescape_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fescape_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f0 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f0.setParent(null);
    // /WEB-INF/pages/blog/home-main.jsp(19,150) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f0.setValue("/tmp/example.png");
    int _jspx_eval_s_005furl_005f0 = _jspx_th_s_005furl_005f0.doStartTag();
    if (_jspx_th_s_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f0);
    return false;
  }
}
