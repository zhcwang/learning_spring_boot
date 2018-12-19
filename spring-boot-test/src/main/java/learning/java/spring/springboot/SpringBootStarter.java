package learning.java.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication
/*@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan*/
/*public class SpringBootStarter {
	
	  public static void main(String[] args) {
	        SpringApplication.run(SpringBootStarter.class, args);
	  }
	  
}*/
//WAR包的启动方式 extends SpringBootServletInitializer
@ServletComponentScan //自定义Filter,servlet
public class SpringBootStarter extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootStarter.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootStarter.class, args);
    }

}
