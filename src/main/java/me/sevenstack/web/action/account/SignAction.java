package me.sevenstack.web.action.account;

import static me.sevenstack.web.util.Constant.USER_SESSION;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import me.sevenstack.util.Utils;
import me.sevenstack.web.model.User;
import me.sevenstack.web.service.UserService;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.StringUtil;

@Results({
    @Result(name = "blog-list", location = "/blog/list", type = "redirect"),
    @Result(name = "home", location = "/", type = "redirect")
})
public class SignAction extends ActionSupport implements SessionAware,ServletResponseAware{
    
    private static final long serialVersionUID = 1L;

    @Inject
    private UserService userService;
    
    private Map<String, Object> session;
    private HttpServletResponse response;
    
    private User user;
    private Map<String, String> message = new HashMap<String, String>();
    private Map<String, String> param = new HashMap<String, String>();

    public void setSession(Map<String, Object> session) {
		this.session = session;
	}
    public void setServletResponse(HttpServletResponse response) {
    	this.response = response;
	}
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, String> getMessage() {
        return message;
    }

    public void setMessage(Map<String, String> message) {
        this.message = message;
    }
	
	public Map<String, String> getParam() {
		return param;
	}
	public void setParam(Map<String, String> param) {
		this.param = param;
	}
	@Action("signIn")
    public String signIn() throws Exception {
        if(user == null){
            return "signIn";
        }
        User paramUser = new User();
        paramUser.setUserName(user.getUserName());
        paramUser.setPassword(Utils.sha(user.getPassword()));
        User loginUser = userService.findUser(paramUser);
        if (loginUser == null) {
            message.put("msg", "用户名或者密码不正确");
            return "signIn";
        }
        session.put(USER_SESSION, loginUser);
        return "home";
    }
    @Action("signUp")
    public String signUp() {
    	if(user == null){
    		return "signUp";
    	}
        try{
            user.setPassword(Utils.sha(user.getPassword()));
            userService.saveUser(user);
        }catch (Exception e) {
            message.put("msg", "系统维护中暂停注册");
            LOG.error("注册异常",e);
            return "signUp";
        }
        return "home";
    }
    @Action("logout")
    public String logout() throws Exception {
    	session.remove(USER_SESSION);
    	if(StringUtils.isNotBlank(param.get("url"))){
    		response.sendRedirect(param.get("url"));
    	}
    	return NONE;
	}
	

	
}
