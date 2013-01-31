package me.sevenstack.web.action.account;

import static me.sevenstack.util.Constant.USER_SESSION;

import java.util.HashMap;
import java.util.Map;

import me.sevenstack.util.Utils;
import me.sevenstack.web.action.BaseAction;
import me.sevenstack.web.model.User;
import me.sevenstack.web.service.UserService;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;

import com.google.inject.Inject;


public class SignAction extends BaseAction{
    @Inject
    private UserService userService;
    private User user;
    private Map<String, String> message = new HashMap<String, String>();
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
    
	@Action("sign-in")
    public String signIn() throws Exception {
        if(user == null){
            return "sign-in";
        }
        User paramUser = new User();
        paramUser.setUserName(user.getUserName());
        paramUser.setPassword(Utils.sha(user.getPassword()));
        User loginUser = userService.findUser(paramUser);
        if (loginUser == null) {
            message.put("msg", "用户名或者密码不正确");
            return "sign-in";
        }
        session.put(USER_SESSION, loginUser);
        log.debug("=======================================================>>>");
        return "index";
    }
    @Action("sign-up")
    public String signUp() {
    	if(user == null){
    		return "sign-up";
    	}
        try{
            user.setPassword(Utils.sha(user.getPassword()));
            userService.saveUser(user);
        }catch (Exception e) {
            message.put("msg", "系统维护中暂停注册");
            log.error("注册异常",e);
            return "sign-up";
        }
        return "index";
    }
    @Action("logout")
    public String logout() throws Exception {
    	session.remove(USER_SESSION);
    	if(StringUtils.isNotBlank(param.get("url"))){
    		response.sendRedirect(param.get("url"));
    		return NONE;
    	}else{
    	    return "index";
    	}
	}
	

	
}
