package com.vkoul.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vkoul.model.User;
import com.vkoul.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal,Model model) {
		List<User> user=null;
		if(principal!=null){
			user= userService.getAllUsers();
			model.addAttribute("user",user);
			return "homeSignedIn";
		}
		return "signin";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(Principal principal,Model model) {
		
		return "signin";
	}
	
	
}
