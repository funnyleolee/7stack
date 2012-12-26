package me.streetyle.st;

import com.google.inject.ImplementedBy;

@ImplementedBy(SimpleHelloGuiceImpl.class)
public interface SimpleHelloGuice {
	public void sayHello();
	public void setMsg(String msg);
}