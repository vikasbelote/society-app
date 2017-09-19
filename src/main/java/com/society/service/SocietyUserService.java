package com.society.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.society.repository.SocietyUserRepository;

@Service
public class SocietyUserService {
	
	@Autowired
	private SocietyUserRepository societyUserRepository;
	
	public void insertSocietyUserDetails() {
		
	}
	
}
