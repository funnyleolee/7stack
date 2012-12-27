package me.streetyle.st;

public class HelloGuiceImpl<T> implements HelloGuice {
	private T t;
	
	public HelloGuiceImpl(T t){
		this.t = t;
	}

	public void sayHello() {
		System.out.println("Hello Guice!");
	}
}