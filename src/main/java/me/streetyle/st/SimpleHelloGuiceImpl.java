package me.streetyle.st;

import com.google.inject.Singleton;

@Singleton
public class SimpleHelloGuiceImpl implements SimpleHelloGuice{
	private String msg = "";

	public void sayHello() {
		System.out.println("Hello "+msg);
	}
	public void setMsg(String msg){
		this.msg = msg;
	}
	
}
