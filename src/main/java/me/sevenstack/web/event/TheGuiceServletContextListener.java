package me.sevenstack.web.event;

import org.mybatis.guice.XMLMyBatisModule;

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
				setEnvironmentId("test");
				//SqlSessionFactoryProvider
				//System.out.println(TheGuiceServletContextListener.class.getResource("") .getResource("/").getPath()+"mybatis-config.xml");
				
				setClassPathResource("mybatis-config.xml");
			}
		});
	}
}
