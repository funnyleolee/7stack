package me.sevenstack.task;

import java.util.Map;

public class TaskScheduling {
	public static void scheduling(Class<? extends Task> taskClass)throws Exception{
		scheduling(taskClass,null);
	}
	public static void scheduling(Class<? extends Task> taskClass,Map<String, Object> params)throws Exception{
		Task task = taskClass.newInstance();
		task.setParams(params);
		new Thread(task).start();
	}
	public static void main(String[] args)throws Exception {
		System.out.println("------");
		scheduling(ImageReplaceTask.class);
		System.out.println("------");
		System.out.println("------");
		System.out.println("------");
	}
}
