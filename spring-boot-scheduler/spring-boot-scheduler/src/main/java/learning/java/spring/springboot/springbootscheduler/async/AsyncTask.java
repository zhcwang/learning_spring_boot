package learning.java.spring.springboot.springbootscheduler.async;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
// 类里面的方法都是异步的
@Async
public class AsyncTask {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void task1() throws InterruptedException {
		logger.info("test logger");
		long start = System.currentTimeMillis();
		Thread.sleep(1000L);
		long end = System.currentTimeMillis();
		System.out.println("任务1耗时：" + (end-start));
	}
	
	public void task2() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(2000L);
		long end = System.currentTimeMillis();
		System.out.println("任务2耗时：" + (end-start));
	}
	
	public void task3() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(3000L);
		long end = System.currentTimeMillis();
		System.out.println("任务3耗时：" + (end-start));
	}
	
	public Future<String> task4() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(4000L);
		long end = System.currentTimeMillis();
		System.out.println("任务4耗时：" + (end-start));
		return new AsyncResult<String>("任务4耗时：" + (end-start));
	}
	
	public Future<String> task5() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(5000L);
		long end = System.currentTimeMillis();
		System.out.println("任务5耗时：" + (end-start));
		return new AsyncResult<String>("任务5耗时：" + (end-start));
	}
	
	public Future<String> task6() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(6000L);
		long end = System.currentTimeMillis();
		System.out.println("任务6耗时：" + (end-start));
		return new AsyncResult<String>("任务6耗时：" + (end-start));
	}
	
}
