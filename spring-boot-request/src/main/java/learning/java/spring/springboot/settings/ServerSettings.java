package learning.java.spring.springboot.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 服务器配置
 * @author DY
 *
 */
@Component
@PropertySource({"classpath:resource.properties"})
//@ConfigurationProperties
@ConfigurationProperties(prefix="web.test")
public class ServerSettings {
		//如果使用前缀的话，@ConfigurationProperties(prefix="web.test") 则不用谢value了，自动注入
	
		// 名称
		//@Value("${web.test.name}")
		private String name;
		// 访问域名
		//@Value("${web.test.domin}")
		private String domin;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDomin() {
			return domin;
		}
		public void setDomin(String domin) {
			this.domin = domin;
		}
		
		
}
