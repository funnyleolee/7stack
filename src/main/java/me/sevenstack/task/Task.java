package me.sevenstack.task;

public abstract class Task implements Runnable {
	
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
