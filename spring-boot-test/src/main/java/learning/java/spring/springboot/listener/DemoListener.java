package learning.java.spring.springboot.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
// 常用的监听器 ServletContextListener、HttpSessionListener、ServletRequestListener
public class DemoListener implements ServletRequestListener{

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("请求监听:" + ((HttpServletRequest)sre.getServletRequest()).getPathInfo());
		
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("结束请求监听。");
		
	}



}
