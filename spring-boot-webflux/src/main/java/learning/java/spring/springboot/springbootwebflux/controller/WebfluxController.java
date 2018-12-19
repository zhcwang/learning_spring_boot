package learning.java.spring.springboot.springbootwebflux.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.java.spring.springboot.springbootwebflux.pojo.User;
import learning.java.spring.springboot.springbootwebflux.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class WebfluxController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{user}")
	public Mono<User> getUser(@PathVariable String user) {
		return userService.getById(user);
	}
	
	@GetMapping(value="/list", produces=MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<User> getUsers() {
		return userService.list().delayElements(Duration.ofSeconds(1));
	}

	@DeleteMapping("/{user}")
	public Mono<User> deleteUser(@PathVariable String user) {
		// ...
		return null;
	}
	
}
