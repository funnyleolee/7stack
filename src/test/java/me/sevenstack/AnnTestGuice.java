package me.sevenstack;
import me.streetyle.st.HelloGuice;
import me.streetyle.st.HelloGuiceModule;
import junit.framework.TestCase; 

import com.google.inject.Guice; 
import com.google.inject.Injector; 

public class AnnTestGuice extends TestCase { 
public void testHelloGuice() { 
Injector injector = Guice.createInjector(new HelloGuiceModule()); 

HelloGuice helloGuice = injector.getInstance(HelloGuice.class); 
helloGuice.sayHello(); 
} 
} 