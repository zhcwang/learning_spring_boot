package learning.java.spring.springboot.springbootscheduler.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author DY
 *
 */
@Component
public class SchedulerTask {
	// fixedRate 和  fixedDelay 前者是固定时间执行，后者是上一次执行完毕后定时执行
	//@Scheduled(fixedRate=4000)
	//@Scheduled(fixedDelay=4000)
	// linux cron 表达式 https://tool.lu/crontab/
	@Scheduled(cron="*/1 * * * * *")
	public void execute() {
		System.out.println("定时任务");
	}
	
	
}
