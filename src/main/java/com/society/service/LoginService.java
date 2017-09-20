package com.society.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.society.model.domain.LoginDomain;
import com.society.model.jpa.RoleJPA;
import com.society.model.jpa.SocietyJPA;
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
		UserJPA userJPADB = loginRepository.validateLogin(userJPA);
		
		if(userJPADB != null){
			RoleJPA role = userJPADB.getRole();
			loginDomain.setRoleName(role.getRoleName());
			if(role != null && role.getRoleName().equals("Owner")) 
				loginDomain.setDisplayName("Application " + role.getRoleName());
			else if(role != null && (role.getRoleName().equals("Admin") || role.getRoleName().equals("User"))) {
				SocietyJPA society = userJPADB.getSociety();
				if(society != null){
					loginDomain.setSocietyId(society.getSocietyId());
					loginDomain.setDisplayName(society.getSocietyName());
				}	
			}
			return true;
		}
		else
			return false;
	}

}
