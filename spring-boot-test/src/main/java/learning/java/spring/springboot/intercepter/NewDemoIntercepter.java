package learning.java.spring.springboot.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 必须定义@Configuration
public class NewDemoIntercepter implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/intercepter1");
		WebMvcConfigurer.super.addInterceptors(registry);
	}


}
