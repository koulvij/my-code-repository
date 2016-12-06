package com.vkoul.controller;

import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vkoul.model.User;
import com.vkoul.service.MasterDataService;
import com.vkoul.service.UserService;
import com.vkoul.support.web.MessageHelper;

@Controller
public class SignupController {

	private static final String SIGNUP_VIEW_NAME = "signup";
	final static Logger logger = LoggerFactory.getLogger(SignupController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private MasterDataService dataService;

	@RequestMapping(value = "createUser")
	public String signup(Model model) {
		SignupForm signupForm = new SignupForm();
		Set<String> rolesSet = dataService.getRoleMasterData();
		Set<String> workspace = dataService.getWorkspaceMasterData();
		signupForm.setWorkspace(workspace);
		signupForm.setRoleSet(rolesSet);
		model.addAttribute(signupForm);
		return SIGNUP_VIEW_NAME;
	}

	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return SIGNUP_VIEW_NAME;
		}
		User account = userService.save(signupForm.createAccount());;
		userService.signin(account);
		// see /WEB-INF/i18n/messages.properties and
		// /WEB-INF/views/homeSignedIn.html
		MessageHelper.addSuccessAttribute(ra, "signup.success");
		return "redirect:/";
	}
}
