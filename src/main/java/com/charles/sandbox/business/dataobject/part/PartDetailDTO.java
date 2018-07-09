package com.charles.sandbox.business.dataobject.part;

import java.util.Date;

public class PartDetailDTO {
	
	private String weight;
	private Date manufactureDate;
	private Long cost;
	
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Date getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public Long getCost() {
		return cost;
	}
	public void setCost(Long cost) {
		this.cost = cost;
	}
}
