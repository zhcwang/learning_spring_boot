package learning.java.spring.springboot.springbootmq.jsm;

import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {
	
	@JmsListener(destination = Topic.TOPIC_NAME, containerFactory="jmsListenerContainerTopic")
	public void receiveTopic1(String message) {
		System.out.println(Topic.TOPIC_NAME + "1接收到消息：" + message);
	}
	
	@JmsListener(destination = Topic.TOPIC_NAME, containerFactory="jmsListenerContainerTopic")
	public void receiveTopic2(String message) {
		System.out.println(Topic.TOPIC_NAME + "2接收到消息：" + message);
	}
	/**
	 * 如果不系统已经定义了containerFactory="jmsListenerContainerTopic" ,但是listener中没有注册该工厂则该监听失效
	 * 不会使用默认的工厂
	 * @param message
	 */
	@JmsListener(destination = Topic.TOPIC_NAME)
	public void receiveTopic3(String message) {
		System.out.println(Topic.TOPIC_NAME + "3接收到消息：" + message);
	}
	
	//需要给topic定义独立的JmsListenerContainer,如果志使用注解spring.jms.pub-sub-domain=true，则topic会影响其它一对一消息的发送
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
}
