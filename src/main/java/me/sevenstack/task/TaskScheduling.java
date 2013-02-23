package me.sevenstack.task;

public class TaskScheduling {
	public static void scheduling(Class<? extends Task> taskClass)throws Exception{
		new Thread(taskClass.newInstance()).start();
	}
	public static void main(String[] args)throws Exception {
		System.out.println("------");
		scheduling(ImageReplaceTask.class);
		System.out.println("------");
		System.out.println("------");
		System.out.println("------");
	}
}
