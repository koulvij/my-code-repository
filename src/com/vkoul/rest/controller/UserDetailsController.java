package com.vkoul.rest.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vkoul.controller.SignupForm;
import com.vkoul.model.User;
import com.vkoul.service.UserService;

@RestController
@Secured("ROLE_USER")
class UserDetailsController {
	@Autowired
    private UserService userService;

    @Autowired
    public UserDetailsController(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping(value = "currentUser", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public User accounts(Principal principal) {
        Assert.notNull(principal);
        return userService.findByUser(principal.getName());
    }
    
    
	@RequestMapping(value ="authenticate",method =RequestMethod.PATCH)
	@ResponseBody
	public void authenticate(@Valid @ModelAttribute SignupForm signupForm)
	{
		UserDetails userDetails = this.userService.loadUserByUsername(signupForm.getEmail());
		//User account = userService.save(signupForm.createAccount());
		userService.signin(signupForm.createAccount());
	
	}
    
    
}
