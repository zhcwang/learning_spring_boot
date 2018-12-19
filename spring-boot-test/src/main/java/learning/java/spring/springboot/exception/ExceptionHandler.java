package learning.java.spring.springboot.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理类
 * @author DY
 *
 */
@ControllerAdvice
public class ExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	/**
	 * 返回一个标准json
	 * @param e
	 * @param request
	 * @return
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(value=Exception.class)
	@ResponseBody
	Object handleException(Exception e, HttpServletRequest request){
		Map<String, Object> errorMessages = new HashMap<>();
		errorMessages.put("code", 400);
		errorMessages.put("msg", e.getMessage());
		errorMessages.put("url", request.getRequestURL().toString());
		logger.error(e.getMessage());
		return errorMessages;
	}
	
	/**
	 * 返回一个页面
	 * @param e
	 * @return
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(value=MyException.class)
	@ResponseBody
	Object toExceptionPage(Exception e){
		ModelAndView view = new ModelAndView();
		view.setViewName("error.html");
		view.addObject(e);
		return view;
	}
	
	
}
