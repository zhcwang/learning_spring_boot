package learning.java.spring.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.java.spring.springboot.exception.MyException;

@RestController
public class ExceptionController {

    @RequestMapping("/exception")
    public String getException() {
        return Integer.toString(1/0);
    }
    

    @RequestMapping("/myexception")
    public String getMyException() throws Exception{
        throw new MyException("500", "手动异常");
    }
    
}