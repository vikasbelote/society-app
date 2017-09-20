package com.society.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.society.model.domain.SocietyUserDomain;
import com.society.model.jpa.AccessRightsId;
import com.society.model.jpa.PersonJPA;
import com.society.model.jpa.SocietyJPA;
import com.society.model.jpa.SocietyUserAccessRightsJPA;
import com.society.model.jpa.UserJPA;
import com.society.repository.SocietyUserRepository;

@Service
public class SocietyUserService {
	
	@Autowired
	private SocietyUserRepository societyUserRepository;
	
	public boolean insertSocietyUserDetails(SocietyUserDomain societyUserDomain) {
		
		PersonJPA person = new PersonJPA();
		person.setFirstName(societyUserDomain.getFirstName());
		person.setMiddleName(societyUserDomain.getMiddleName());
		person.setLastName(societyUserDomain.getLastName());
		person.setContactNumber(societyUserDomain.getContactNumber());
		person.setEmailId(societyUserDomain.getEmailId());
		
		SocietyJPA societyJPA = new SocietyJPA();
		societyJPA.setSocietyId(societyUserDomain.getSocietyId());
		
		UserJPA user = new UserJPA();
		user.setUserName(societyUserDomain.getUserName());
		user.setUserPassword(societyUserDomain.getUserPassword());
		user.setPerson(person);
		user.setSociety(societyJPA);
		
		List<SocietyUserAccessRightsJPA> rightList = new ArrayList<SocietyUserAccessRightsJPA>();
		String[] rights = societyUserDomain.getRights();
		if(rights != null) {
			for(String str : societyUserDomain.getRights()) {
				
				Integer menuId = Integer.valueOf(str);
				
				AccessRightsId accessRightsId = new AccessRightsId();
				accessRightsId.setMenuId(menuId);
				accessRightsId.setUserId(user.getUserId());
				
				SocietyUserAccessRightsJPA societyUserAccessRights = new SocietyUserAccessRightsJPA();
				societyUserAccessRights.setAccessRightsId(accessRightsId);
				
				rightList.add(societyUserAccessRights);
			}	
		}
		
		return societyUserRepository.insertSocietyUserDeatils(user, rightList);
	}
}
