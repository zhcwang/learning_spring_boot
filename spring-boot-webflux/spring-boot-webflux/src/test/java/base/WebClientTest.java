package base;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class WebClientTest {
	@Test
	public void testBase(){
		Mono<String> bodyMono = WebClient.
				create().
				get().
				uri("http://localhost:8080/user/1")
				.accept(MediaType.APPLICATION_JSON).
				retrieve().
				bodyToMono(String.class);
		System.out.println(bodyMono.block());
	}
	

	@Test
	public void testBase2(){
		Mono<String> bodyMono = WebClient.create().get()
		.uri("http://localhost:8080/user/{id}",2)
		.accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.bodyToMono(String.class);
		System.out.println(bodyMono.block());
	}
	
}
