package me.sevenstack.web.action.blog;

import java.util.Map;

import me.sevenstack.web.model.User;
import me.sevenstack.web.service.UserService;
import me.sevenstack.web.util.Constant;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.google.inject.Inject;

@Results({
	@Result(name="home",location ="/home",type="redirect"),
	@Result(name="login",location="blog/login.jsp"),
	@Result(name="register",location="blog/register.jsp"),
	@Result(name="register-redirect",location="blog/register-redirect.jsp"),
})
public class LoginAction implements SessionAware {
	@Inject
	private UserService userService;
	
	private User user;
	private Map<String, Object> session;
	private String msg;
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	 
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Action("/login")
	public String login() throws Exception {
		String result = "home";
		User loginUser = (User) session.get(Constant.USER_SESSION_KEY);
		if (loginUser == null) {
			if (user == null) {
				result = "login";
			} else {
				User queryUser = new User();
				//ueryUser.setName(StringUtils.trim(user.getName()));
				queryUser.setPassword(user.getPassword());
				loginUser = userService.findUser(queryUser);
				if (loginUser == null) {
					msg = "用户名或者密码错误";
					result = "login";
				} else {
					session.put(Constant.USER_SESSION_KEY, loginUser);
				}
			}
		}
		return result;
	}
	@Action("/register")
	public String register() throws Exception {
		String result = "register";
		if(user != null){
			//valid?
			userService.saveUser(user);
			result = "register-redirect";
		}
		return result;
	}
	@Action("/logout")
	public String logout() throws Exception {
		return "login";
	}

	

}
