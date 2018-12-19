package learning.java.spring.springboot.springbootmq.jsm;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {
	
	@JmsListener(destination = Queue.COMMON_QUEUE_NAME)
	public void receiveMessage(String message) {
		System.out.println("COMMON QUEUE接收到消息：" + message);
	}
	
	@JmsListener(destination = Queue.DEFAULT_QUEUE_NAME)
	public void receiveMessage1(String message) {
		System.out.println("DEFAULE QUEUE接收到消息：" + message);
	}
	
}
