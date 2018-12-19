package learning.java.spring.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @RequestMapping("/")
    public String home() {
        return "Hello World!" + "1";
    }
    
    @RequestMapping("/devtool")
    public String refresh() {
        return "Hello World热部署!";
    }
    
    @RequestMapping("/info")
    public Map<String, String> testGetMap(){
    	Map<String, String> map = new HashMap<>();
    	map.put("name", "zcwang");
    	map.put("age", "27");
    	return map;
    }
    
    
   
}