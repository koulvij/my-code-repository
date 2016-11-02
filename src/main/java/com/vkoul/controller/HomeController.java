package com.vkoul.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vkoul.model.User;
import com.vkoul.service.UserService;

@RestController
public class HomeController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public User index(Principal principal) {
		User user=null;
		if(principal!=null){
			user= userService.findByUser(principal.getName());
		}
		return user;
	}
}
