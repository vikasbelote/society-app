package com.society.model.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.society.model.jpa.PersonJPA;
import com.society.model.jpa.SocietyJPA;

@Component
@Scope("prototype")
public class SocietyMemberDomain {

	private Integer memberId;
	
	private SocietyDomain society;
	
	private PersonDomain person;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public SocietyDomain getSociety() {
		return society;
	}

	public void setSociety(SocietyDomain society) {
		this.society = society;
	}

	public PersonDomain getPerson() {
		return person;
	}

	public void setPerson(PersonDomain person) {
		this.person = person;
	}
}
