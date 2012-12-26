package me.sevenstack;

import junit.framework.TestCase;
import me.streetyle.st.HelloGuice;
import me.streetyle.st.SimpleHelloGuice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestGuice extends TestCase {
	public void testHelloGuice() {
		// Injector injector = Guice.createInjector(new HelloGuiceModule());

		Injector injector = Guice.createInjector();
		SimpleHelloGuice g1 = injector.getInstance(SimpleHelloGuice.class);
		g1.setMsg("Simple Guice");
		g1.sayHello();
		SimpleHelloGuice g2 = injector.getInstance(SimpleHelloGuice.class);
		g2.sayHello();
		System.out.println(g1 == g2);
	}
}