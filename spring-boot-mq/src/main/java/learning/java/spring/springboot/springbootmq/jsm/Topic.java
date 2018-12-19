package learning.java.spring.springboot.springbootmq.jsm;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Topic {
	
	public static final String TOPIC_NAME = "common.topic";
	/**
	 * 主题对象交给spring管理
	 * @return
	 */
	@Bean
	public javax.jms.Topic getTopic() {
		return new ActiveMQTopic(TOPIC_NAME);
	}
}
