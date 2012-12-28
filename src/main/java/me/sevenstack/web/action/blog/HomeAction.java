package me.sevenstack.web.action.blog;

import java.util.ArrayList;
import java.util.List;

import me.sevenstack.web.model.User;
import me.sevenstack.web.service.UserService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/home")
@Results({
	@Result(name="home",location="/WEB-INF/pages/blog/home.jsp")
})
public class HomeAction extends ActionSupport{
	@Inject
	private UserService userService;
	private List<User> userList = new ArrayList<User>();
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	@Action("/home")
	public String index()throws Exception{
		userList = userService.findUserList(new User());
		return "home";
	}
}
