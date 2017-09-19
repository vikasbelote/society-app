package com.society.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.society.helper.BreadCrumbHelper;
import com.society.helper.model.BreadCrumb;
import com.society.model.domain.SocietyUserDomain;

@Controller
public class SocietyUserController {
	
	@Autowired
	private BreadCrumbHelper breadCrumbHelper;
	
	@RequestMapping(value = "createUser", method = RequestMethod.GET)
	public ModelAndView getUser() {
		
		String[] breadCrumbs = {"Society", "Create User"};
		List<BreadCrumb> breadCrumbList = breadCrumbHelper.getBreadCrumbList(breadCrumbs);
		
		ModelAndView modelAndView = new ModelAndView("createUser");
		modelAndView.addObject(breadCrumbList);
		return modelAndView;
	}
	
	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	public ModelAndView postUser(@ModelAttribute SocietyUserDomain societyUserDomain) {
		
		ModelAndView modelAndView = new ModelAndView("createUser");
		return modelAndView;
	}
}
