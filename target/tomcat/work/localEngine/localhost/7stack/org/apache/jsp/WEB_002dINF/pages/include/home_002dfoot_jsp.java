package org.apache.jsp.WEB_002dINF.pages.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_002dfoot_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      out.write("<div class=\"line\"></div>\n");
      out.write("<div class=\"container-fluid stack-footer\">\n");
      out.write("  <div class=\"row-fluid\">\n");
      out.write("    <div class=\"span3\">\n");
      out.write("      <span class=\"help-inline\">\n");
      out.write("        ©2013 7STACK Workstation<a href=\"mailto:nideyee@163.com\" class=\"btn btn-link\" tile=\"Contact us\">\n");
      out.write("        <li class=\"icon-envelope\"></li></a>\n");
      out.write("      </span>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"span9 footer-right\">\n");
      out.write("      <span class=\"help-inline browser-support text-small\">\n");
      out.write("        support by\n");
      out.write("        <a href=\"#\" class=\"btn btn-link\">\n");
      out.write("          <img src=\"");
      if (_jspx_meth_s_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" title=\"谷歌浏览器\">\n");
      out.write("        </a>\n");
      out.write("        <a href=\"#\" class=\"btn btn-link\">\n");
      out.write("          <img src=\"");
      if (_jspx_meth_s_005furl_005f1(_jspx_page_context))
        return;
      out.write("\"  title=\"火狐浏览器\">\n");
      out.write("        </a>\n");
      out.write("        <a href=\"#\" class=\"btn btn-link\">\n");
      out.write("          <img src=\"");
      if (_jspx_meth_s_005furl_005f2(_jspx_page_context))
        return;
      out.write("\" title=\"IE9或IE10\">\n");
      out.write("        </a>\n");
      out.write("        <a href=\"#\" class=\"btn btn-link\">\n");
      out.write("          <img src=\"");
      if (_jspx_meth_s_005furl_005f3(_jspx_page_context))
        return;
      out.write("\" title=\"苹果浏览器\">\n");
      out.write("        </a>\n");
      out.write("      </span>\n");
      out.write("    </div>\n");
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

  private boolean _jspx_meth_s_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f0 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f0.setParent(null);
    // /WEB-INF/pages/include/home-foot.jsp(17,20) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f0.setValue("/resources/img/chrome.png");
    int _jspx_eval_s_005furl_005f0 = _jspx_th_s_005furl_005f0.doStartTag();
    if (_jspx_th_s_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f1 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f1.setParent(null);
    // /WEB-INF/pages/include/home-foot.jsp(20,20) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f1.setValue("/resources/img/firefox.png");
    int _jspx_eval_s_005furl_005f1 = _jspx_th_s_005furl_005f1.doStartTag();
    if (_jspx_th_s_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f2 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f2.setParent(null);
    // /WEB-INF/pages/include/home-foot.jsp(23,20) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f2.setValue("/resources/img/ie9.png");
    int _jspx_eval_s_005furl_005f2 = _jspx_th_s_005furl_005f2.doStartTag();
    if (_jspx_th_s_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f3 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f3.setParent(null);
    // /WEB-INF/pages/include/home-foot.jsp(26,20) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f3.setValue("/resources/img/safari.png");
    int _jspx_eval_s_005furl_005f3 = _jspx_th_s_005furl_005f3.doStartTag();
    if (_jspx_th_s_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005furl_005f3);
    return false;
  }
}
