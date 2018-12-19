package learning.java.spring.springboot.starter.settings;

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
@ConfigurationProperties(prefix="server")
public class ServerSettings {
		// 名称
		private String name;
		// 访问域名
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
