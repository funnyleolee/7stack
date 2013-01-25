package me.sevenstack.web.action.account;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;

import me.sevenstack.web.model.User;


public class SignAction extends ActionSupport{
	@Inject
	private User user;
	
	public String signIn(){
		return "signIn";
	}
	
	public String signUp(){
		System.out.println(user.getUserName());
		return "signIn";
	}
}
