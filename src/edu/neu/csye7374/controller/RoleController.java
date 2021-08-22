package edu.neu.csye7374.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.neu.csye7374.driver.Person;
import edu.neu.csye7374.roles.Admin;

@Controller
public class RoleController {
	
	public static Person person;
	
	@RequestMapping("/admin")
	public ModelAndView adminHome() {
 
		person = Person.getInstance();
        Admin admin = new Admin(12, "Carlos", "Sainz");
        person.setRole(admin);
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin");
        mv.addObject("admin",admin);
        return mv;
        
	}

}
