package com.charles.sandbox.web.dataobject.health;

import java.io.Serializable;

public class HealthVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
