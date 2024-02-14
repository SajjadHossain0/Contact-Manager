package com.contact.manager.controller;

import com.contact.manager.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("title","Home - Contact Manager");
		
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		
		model.addAttribute("title","About - Contact Manager");
		
		return "about";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("title","Login - Contact Manager");
		
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		
		model.addAttribute("title","Signup - Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") User user){
		// if all feild are !blank and agrement are checked then signup else again fill the form

		System.out.println(user);
		return  "signup";
	}



}
