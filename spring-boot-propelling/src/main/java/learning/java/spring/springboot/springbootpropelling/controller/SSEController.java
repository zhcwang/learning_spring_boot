package learning.java.spring.springboot.springbootpropelling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sse")
public class SSEController {
	@GetMapping(value="/getProcess", produces = "text/event-stream;charset=UTF-8")
	public String getProcess() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Math.random() + "";
	}
}
