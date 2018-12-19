package learning.java.spring.springboot.springbootscheduler.controller;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.java.spring.springboot.springbootscheduler.async.AsyncTask;

@RestController
public class RequestConroller {
	@Autowired 
	AsyncTask task;
	/**
	 * 任务直接执行，不需要返回结果，前台不用等待后台
	 * @return
	 * @throws InterruptedException
	 */
	@GetMapping("test")
	public String test() throws InterruptedException {
		long start = System.currentTimeMillis();
		task.task1();
		task.task2();
		task.task3();
		long end = System.currentTimeMillis();
		System.out.println("执行时间：" + (end - start));
		return "执行时间：" + (end - start);
	}
	
	/**
	 * 后台并发执行，前台等待最长时间
	 * @return
	 * @throws InterruptedException
	 */
	@GetMapping("testGetAsync")
	public String testAsync() throws InterruptedException {
		long start = System.currentTimeMillis();
		Future<String> task4 = task.task4();
		Future<String> task5 = task.task5();
		Future<String> task6 = task.task6();
		for(;;) {
			if (task4.isDone() && task5.isDone() && task6.isDone()) {
				break;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("执行时间：" + (end - start));
		return "执行时间：" + (end - start);
	}
	
}
