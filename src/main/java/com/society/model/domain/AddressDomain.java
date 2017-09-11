package com.society.model.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AddressDomain {
	
	private Integer addressId;
	
	private String addressText;
	
	private String areaName;
	
	private Integer plotNo;

	private Integer sectorNo;

	private String city;
	
	private Integer pinCode;

	private String state;
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getPlotNo() {
		return plotNo;
	}
	public void setPlotNo(Integer plotNo) {
		this.plotNo = plotNo;
	}
	public Integer getSectorNo() {
		return sectorNo;
	}
	public void setSectorNo(Integer sectorNo) {
		this.sectorNo = sectorNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPinCode() {
		return pinCode;
	}
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddressText() {
		return addressText;
	}
	public void setAddressText(String addressText) {
		this.addressText = addressText;
	}
}
