package me.sevenstack.task;

import java.util.HashMap;
import java.util.Map;

public abstract class Task implements Runnable {
	protected Map<String, Object> params = new HashMap<String, Object>();
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	@Override
	public void run(){
		try {
			execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public abstract void execute() throws Exception;
}
