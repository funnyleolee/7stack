package me.sevenstack.web.action.account;

import org.apache.struts2.convention.annotation.Action;

import me.sevenstack.web.action.BaseAction;

public class ForgetAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    
    @Action("forget")
    public String forget(){
        return "forget";
    }

}
