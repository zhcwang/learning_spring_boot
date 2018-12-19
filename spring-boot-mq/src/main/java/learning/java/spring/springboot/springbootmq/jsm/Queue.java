package learning.java.spring.springboot.springbootmq.jsm;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Queue {
	public static final String COMMON_QUEUE_NAME = "common.queue";
	
	public static final String DEFAULT_QUEUE_NAME = "default.queue";
	/**
	 * 默认队列
	 * @return
	 */
	@Bean
	public javax.jms.Queue dafaultQueue() {
		return new ActiveMQQueue(DEFAULT_QUEUE_NAME);
	}
}
