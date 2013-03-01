package me.sevenstack.web.event;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.Properties;
import java.lang.reflect.Field;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import me.sevenstack.util.Constants;

public class WebContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getResourceAsStream("/platform.properties"));
            System.out.println(properties.getProperty("img_server_path"));
            Field[] f= Constants.class.getDeclaredFields();
            for(Field ff : f){
                //ff.set
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        
    }
}
