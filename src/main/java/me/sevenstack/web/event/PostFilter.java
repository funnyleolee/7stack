package me.sevenstack.web.event;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Servlet Filter implementation class PostFilter
 */
public class PostFilter implements Filter {


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
	    String path = request.getServletPath();
	    //path.matches("^/.+/post/\\d+/*$")
	    if(path.matches("^/post/\\d+/*$")){//查看博客
	        String[] ps = path.split("/post/");
	        String postId = StringUtils.trim(ps[ps.length-1].split("/")[0]);
	        if(NumberUtils.isNumber(postId)){
	            RequestDispatcher foward = request.getRequestDispatcher("/post?pid="+postId);
	            foward.forward(request, response);
	            return;
	        }
	    }
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}
	public static void main(String[] args) {
       // System.out.println("/sdfsdfs/post/232/".split("/post/\\d+/*$")[1]);
    }
}
