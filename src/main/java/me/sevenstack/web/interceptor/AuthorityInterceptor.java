package me.sevenstack.web.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.sevenstack.util.Constant;
import me.sevenstack.web.annotation.LoginRequired;
import me.sevenstack.web.model.User;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor  {
    private static final long serialVersionUID = 1L;

    private static Logger log = Logger.getLogger(AuthorityInterceptor.class);

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String methodName = actionInvocation.getProxy().getMethod();
        Method currentMethod = actionInvocation.getAction().getClass().getMethod(methodName, null);

        if (currentMethod.isAnnotationPresent(LoginRequired.class)) {
            LoginRequired lr = currentMethod.getAnnotation(LoginRequired.class);
            //System.out.println(lr.value());
            
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();
            User user = (User)request.getSession().getAttribute(Constant.USER_SESSION);
            if(user == null){
                response.sendRedirect("/"+request.getContextPath());
                return Action.NONE;
            }
        }
        return actionInvocation.invoke();
    }

}
