package com.society.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.society.model.domain.LoginDomain;
import com.society.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDomain loginDomain;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getLogin() {
		return new ModelAndView("login", "loginDomain", loginDomain);
	}
	
	@RequestMapping(value = "validateLogin", method = RequestMethod.POST)
	public String postLogin(@ModelAttribute("loginDomain") LoginDomain loginDomain) {
		
		if(loginService.validateLogin(loginDomain))
			return "redirect:/home";
		else
			return "redirect:/";
	}
}