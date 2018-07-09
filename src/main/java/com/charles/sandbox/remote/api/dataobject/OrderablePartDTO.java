package com.charles.sandbox.remote.api.dataobject;

import java.io.Serializable;

public class OrderablePartDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String status;
	private String name;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
