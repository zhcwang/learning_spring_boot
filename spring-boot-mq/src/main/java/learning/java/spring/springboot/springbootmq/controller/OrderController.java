package learning.java.spring.springboot.springbootmq.controller;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.java.spring.springboot.springbootmq.jsm.Producer;
import learning.java.spring.springboot.springbootmq.jsm.Queue;

@RestController
@RequestMapping("/mq")
public class OrderController {
	@Autowired
	private Producer producer;
	/**
	 * 向COMMON消息队列中发送请求
	 * @param message
	 * @return
	 */
	@GetMapping("sendMessageToCommon")
	public String sendMessageToCommon(String message){
		Destination destination = new ActiveMQQueue(Queue.COMMON_QUEUE_NAME);
		producer.sendMessage(destination, message);
		return "已经成功发送消息到COMMON：" + message;
	} 
	
	/**
	 * 向默认消息队列中发送请求
	 * @param message
	 * @return
	 */
	@GetMapping("sendMessageToDefault")
	public String sendMessageToDefault(String message){
		producer.sendMessage(message);
		return "已经成功发送消息到DEFAULT：" + message;
	} 
	
	/**
	 * 发布消息
	 * @param message
	 * @return
	 */
	@GetMapping("publishMessage")
	public String publishMessage(String message){
		producer.publish(message);
		return "已经成功发布消息：" + message;
	} 
	
	
}
