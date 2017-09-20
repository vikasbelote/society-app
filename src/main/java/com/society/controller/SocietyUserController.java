package com.society.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.society.helper.BreadCrumbHelper;
import com.society.helper.model.BreadCrumb;
import com.society.model.domain.SocietyUserDomain;
import com.society.service.SocietyUserService;

@Controller
public class SocietyUserController {
	
	@Autowired
	private BreadCrumbHelper breadCrumbHelper;
	
	@Autowired
	private SocietyUserService societyUserService;
	
	@RequestMapping(value = "createUser", method = RequestMethod.GET)
	public ModelAndView getUser() {
		
		String[] breadCrumbs = {"Society", "Create User"};
		List<BreadCrumb> breadCrumbList = breadCrumbHelper.getBreadCrumbList(breadCrumbs);
		
		ModelAndView modelAndView = new ModelAndView("createUser");
		modelAndView.addObject(breadCrumbList);
		return modelAndView;
	}
	
	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	public String postUser(@ModelAttribute SocietyUserDomain societyUserDomain, RedirectAttributes redirectAttributes, HttpSession session) {
		
		if(societyUserService.insertSocietyUserDetails(societyUserDomain))
			redirectAttributes.addFlashAttribute("successMsg", "Congrats!!! Your society new user account created successfully.");
		else
			redirectAttributes.addFlashAttribute("successMsg", "There is problem with creating new society user account.");
		
		return "redirect:/createUserStatus";
	}
	
	@RequestMapping(value = "createUserStatus", method = RequestMethod.GET)
	public ModelAndView getUserStatus() {
		return new ModelAndView("createUserStatus");
	}
}
