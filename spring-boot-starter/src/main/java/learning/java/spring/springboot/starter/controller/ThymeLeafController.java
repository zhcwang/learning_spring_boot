package learning.java.spring.springboot.starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import learning.java.spring.springboot.starter.settings.ServerSettings;

@Controller
public class ThymeLeafController {
	
	@Autowired
	private ServerSettings setting;
	
    @GetMapping("/tl/hello")
    public String hello(ModelMap modelMap) {
        return "index";
    }
    
    @GetMapping("/tl/info")
    public String info(ModelMap modelMap) {
    	modelMap.addAttribute("setting", setting);
        return "admin/info";
    }
    
   
}