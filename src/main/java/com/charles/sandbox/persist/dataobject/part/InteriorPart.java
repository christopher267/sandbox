package com.charles.sandbox.persist.dataobject.part;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INTERIOR_PART")
public class InteriorPart {
	
	@Id
	private Long id;
	
	@Column
	private Long automobileId;
	
	@Column
	private Boolean orderable;
	
	@Column
	private String partName;
	
	@Column
	private Long seatCount;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAutomobileId() {
		return automobileId;
	}

	public void setAutomobileId(Long automobileId) {
		this.automobileId = automobileId;
	}

	public Boolean getOrderable() {
		return orderable;
	}

	public void setOrderable(Boolean orderable) {
		this.orderable = orderable;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public Long getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Long seatCount) {
		this.seatCount = seatCount;
	}
}
