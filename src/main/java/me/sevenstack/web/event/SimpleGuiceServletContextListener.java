package me.sevenstack.web.event;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.struts2.Struts2GuicePluginModule;

/**
 * 注入器加载
 * @author lijinlong
 *
 */
public class SimpleGuiceServletContextListener extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new Struts2GuicePluginModule(),new SimpleXMLMyBatisModule());
	}
}
