package com.charles.sandbox.persist.dataobject.part;

import javax.persistence.Column;
import javax.persistence.Id;

public abstract class Part {

	@Id
	private Long id;
	
	@Column
	private Long automobileId;
	
	@Column
	private Boolean orderable;
	
	@Column
	private String partName;

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
}
