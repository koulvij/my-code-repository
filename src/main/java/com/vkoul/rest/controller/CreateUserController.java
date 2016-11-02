package com.vkoul.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vkoul.controller.SignupForm;
import com.vkoul.service.UserService;

@RestController
@RequestMapping(value="/user")
public class CreateUserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/newUser", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String createUser(@ModelAttribute SignupForm signupForm) {
		try {
			userService.save(signupForm.createAccount());
			new String("User Create" + signupForm.getEmail());
		} catch (Exception e) {
		}
		return new String("User Not Created!....");
	}

}
