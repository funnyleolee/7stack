package me.sevenstack.blog.action.tty;

import me.sevenstack.blog.service.SimpleService;

import org.apache.struts2.convention.annotation.Action;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private SimpleService simpleService;
	
	private String guiceOkey;
	public String getGuiceOkey() {
		return guiceOkey;
	}

	public void setGuiceOkey(String guiceOkey) {
		this.guiceOkey = guiceOkey;
	}
	
	private String q;
	public void setQ(String q) {
		this.q = q;
	}
	@Action("/test/say-hello")
	public String hello() throws Exception{
		guiceOkey = simpleService.okey();
		System.out.println(simpleService.get);
		return "hello";
	}

}
