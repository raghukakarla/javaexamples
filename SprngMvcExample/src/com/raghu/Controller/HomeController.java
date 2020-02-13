package com.raghu.Controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.raghu.Model.User;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("home constructor------------------");
		// TODO Auto-generated constructor stub
	}
    
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("serverTime", "Hello Spring MVC Framework!");

		return "home";
     }
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(User user,Model model)
    {
    	System.out.println("User Page Requested");
    	model.addAttribute("userName", user.getUserName());
    	return "user";
    }
    
    @RequestMapping(value = "/user1", method = RequestMethod.POST)
    public ModelAndView user1(@RequestParam Map<String, String> mapName)
    {
    	System.out.println("User Page Requested");
    	ModelAndView model = new ModelAndView("user");
    	model.addObject("userName", mapName);
    	return model;
    }
    @RequestMapping(value = "/user2", method = RequestMethod.POST)
    public ModelAndView user2(@ModelAttribute User user)
    {
    	System.out.println("User Page Requested");
    	ModelAndView model = new ModelAndView("user");
    	model.addObject("userName", user);
    	return model;
    }
    
    @ModelAttribute
    public Model user3(Model model)
    {
    	model.addAttribute("headerMsg", "This is a Header");
    	return model;
    }
}
