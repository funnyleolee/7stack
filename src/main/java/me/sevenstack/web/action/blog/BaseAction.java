package me.sevenstack.web.action.blog;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("7stack-default")
@Results({
    @Result(name = "index", location = "/", type = "redirect") 
})
public class BaseAction extends ActionSupport implements SessionAware, ServletResponseAware, ApplicationAware {
    private static final long serialVersionUID = 1L;

    protected Logger log = Logger.getLogger(this.getClass());

    protected Map<String, Object> application;
    protected Map<String, Object> session;
    protected HttpServletResponse response;
    
    protected Map<String, String> param = new HashMap<String, String>();

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }
    
    
}
