package me.sevenstack.web.event;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.mybatis.guice.XMLMyBatisModule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.struts2.Struts2GuicePluginModule;

public class TheGuiceServletContextListener extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new Struts2GuicePluginModule(), new XMLMyBatisModule() {
			
			@Override
			protected void initialize() {
				
				try {
					String vcap = System.getenv("VCAP_SERVICES");
					String evnId = "dev";
					Properties p = new Properties();
					p.load(new FileInputStream(this.getClass().getResource("/").getPath()+"mysql.properties"));
					if(vcap != null){
						evnId = "prd";
						JSONObject db = JSON.parseObject(vcap).getJSONArray("mysql-5.1").getJSONObject(0).getJSONObject("credentials");
						p.setProperty("db.url", "jdbc:mysql://"+db.getString("host")+":"+db.getString("port")+"/"+db.getString("name"));
						p.setProperty("db.username", db.getString("username"));
						p.setProperty("db.password", db.getString("password"));
					}
					addProperties(p);
					setEnvironmentId(evnId);
					
				} catch (IOException e) {
					System.out.println("初始化失败");
					e.printStackTrace();
				}
				
				//addProperties(properties)
				//SqlSessionFactoryProvider
				//System.out.println(TheGuiceServletContextListener.class.getResource("") .getResource("/").getPath()+"mybatis-config.xml");
				
				setClassPathResource("mybatis-config.xml");
			}
		});
	}
}
