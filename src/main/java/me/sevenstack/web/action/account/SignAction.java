package me.sevenstack.web.action.account;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;

import me.sevenstack.web.model.User;


public class SignAction extends ActionSupport{
	private User user;
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public String signIn(){
		return "signIn";
	}
	
	public String signUp(){
		
		return "/blog/home";
	}
}
