package com.society.model.domain;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.society.model.jpa.AddressJPA;
import com.society.model.jpa.SocietyMemberJPA;

@Component
@Scope("prototype")
public class SocietyDomain {
	
	private Integer societyId;
	
	private String societyName;
	
	private AddressDomain address;
	
	private List<SocietyMemberDomain> memberList;

	public Integer getSocietyId() {
		return societyId;
	}

	public void setSocietyId(Integer societyId) {
		this.societyId = societyId;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public AddressDomain getAddress() {
		return address;
	}

	public void setAddress(AddressDomain address) {
		this.address = address;
	}

	public List<SocietyMemberDomain> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<SocietyMemberDomain> memberList) {
		this.memberList = memberList;
	}

}
