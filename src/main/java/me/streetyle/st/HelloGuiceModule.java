package me.streetyle.st;

import com.google.inject.Binder;
import com.google.inject.Module;

public class HelloGuiceModule implements Module {

	public void configure(Binder binder) {
		binder.bind(HelloGuice.class).to(HelloGuiceImpl.class);
	}

}