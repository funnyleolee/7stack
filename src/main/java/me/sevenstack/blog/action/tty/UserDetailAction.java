package me.sevenstack.blog.action.tty;

import me.sevenstack.blog.model.User;
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
	private User user;

	public void setQ(String q) {
		this.q = q;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Action("/test/say-hello")
	public String hello() throws Exception {
		// guiceOkey = simpleService.okey();
		System.out.println(simpleService.getUserById(Integer.valueOf(q)));
		return "hello";
	}

	public String add() throws Exception {
		int i = simpleService.saveUser(user);
		System.out.println(i);
		return "hello";
	}

}
