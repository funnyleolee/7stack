package me.sevenstack.web.action.account;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.Email;
import org.apache.struts2.convention.annotation.Action;

import me.sevenstack.web.action.BaseAction;

public class ForgetAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Action("forget")
    public String forget(){
        return "forget";
    }
    
    @Action("forget-send")
    public String forgetSend(){
        email = StringUtils.trim(email);
        if(StringUtils.isBlank(email)){
            return "forget";
        }
        //TODO  邮件处理
        return "forget-send";
    }

}
