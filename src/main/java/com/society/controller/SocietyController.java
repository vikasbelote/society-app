package com.society.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.society.model.domain.PersonDomain;
import com.society.model.domain.SocietyForm;

@Controller
public class SocietyController {
	
	@RequestMapping(value = "societyRegistration", method = RequestMethod.GET)
	public ModelAndView getSociety() {
		return new ModelAndView("societyRegistration");
	}
	
	@RequestMapping(value = "getMemberRow", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ModelAndView getMemberRow(@RequestBody PersonDomain personDomain) {
		return new ModelAndView("memberRow", "personDomain", personDomain);
	}
	
	@RequestMapping(value = "societyRegistration", method = RequestMethod.POST)
	public ModelAndView postSociety(@RequestBody SocietyForm societyForm) {
		
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
	
}
