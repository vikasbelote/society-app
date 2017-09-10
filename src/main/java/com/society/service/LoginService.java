package com.society.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.society.model.domain.LoginDomain;
import com.society.model.jpa.UserJPA;
import com.society.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private Mapper mapper;
	
	@Autowired
	private LoginRepository loginRepository;
	
	public boolean validateLogin(LoginDomain loginDomain) {
		
		UserJPA userJPA = mapper.map(loginDomain, UserJPA.class);
		UserJPA  userJPADB = loginRepository.validateLogin(userJPA);
		if(userJPADB != null)
			return true;
		else
			return false;
	}

}
