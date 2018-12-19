package learning.java.spring.springboot.springbootmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringBootMqApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMqApplication.class, args);
	}
}
