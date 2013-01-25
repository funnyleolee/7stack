package me.sevenstack.web.action.account;

import java.util.HashMap;
import java.util.Map;

import me.sevenstack.util.Utils;
import me.sevenstack.web.model.User;
import me.sevenstack.web.service.UserService;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;

@Results({
    @Result(name = "blog-list", location = "/blog/list", type = "redirect"),
    @Result(name = "home", location = "/", type = "redirect"),
    @Result(name = "redirect-signIn", location = "signIn",type="redirectAction")
})
public class SignAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;

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

    public String in() throws Exception {
        if(user == null){
            return "signIn";
        }
        User paramUser = new User();
        paramUser.setUserName(user.getUserName());
        paramUser.setPassword(Utils.sha(user.getPassword()));
        User loginUser = userService.findUser(user);
        if (loginUser == null) {
            message.put("msg", "用户名或者密码不正确");
            return "signIn";
        }
        return "home";
    }

    public String up() {
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
}
