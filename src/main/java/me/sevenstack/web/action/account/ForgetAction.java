package me.sevenstack.web.action.account;

import me.sevenstack.util.Utils;
import me.sevenstack.web.action.BaseAction;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
    @Result(name = "forget-send", location = "/WEB-INF/pages/account/forget-send.jsp") 
    })
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
    public String forget() {
        email = StringUtils.trim(email);
        if (Utils.isEmail(email)) {
            sendMail();
            return "forget-send";
        }
        return SUCCESS;
    }

    private boolean sendMail() {
        // TODO 邮件处理
        return false;
    }
}
