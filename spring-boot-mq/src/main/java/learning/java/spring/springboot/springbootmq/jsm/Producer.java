package learning.java.spring.springboot.springbootmq.jsm;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
@Component
public class Producer{

	@Autowired
	private JmsMessagingTemplate jmsTemplate;
	/**
	 * 点对点，一对一的发送消息
	 */
	@Autowired
	private Queue mq;
	
	public void sendMessage(Destination destination, String message) {
		jmsTemplate.convertAndSend(destination, message);
	}

	public void sendMessage(String message) {
		jmsTemplate.convertAndSend(this.mq, message);
	}
	/**
	 * 主题，一堆多的发送消息
	 */
	@Autowired
	private Topic topic;
	
	public void publish(String message) {
		jmsTemplate.convertAndSend(topic, message);
	}
	
	

}
