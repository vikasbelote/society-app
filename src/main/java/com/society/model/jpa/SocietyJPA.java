package com.society.model.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sa_society")
public class SocietyJPA {
	
	@Id
	@GeneratedValue
	@Column(name = "society_id")
	private Integer societyId;
	
	@Column(name = "society_name")
	private String societyName;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private AddressJPA addressId;
	
	@OneToMany(mappedBy = "society", fetch = FetchType.LAZY)
	private List<SocietyMemberJPA> memberList;

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

	public AddressJPA getAddressId() {
		return addressId;
	}

	public void setAddressId(AddressJPA addressId) {
		this.addressId = addressId;
	}
}
