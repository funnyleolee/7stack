package me.sevenstack.web.event;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.logging.LogFactory;

public class WebContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LogFactory.useLog4JLogging();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        
    }
}
