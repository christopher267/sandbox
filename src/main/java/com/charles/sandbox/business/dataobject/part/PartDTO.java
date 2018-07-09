package com.charles.sandbox.business.dataobject.part;

import java.io.Serializable;

public abstract class PartDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long automobileId;
	private Boolean orderable;
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
