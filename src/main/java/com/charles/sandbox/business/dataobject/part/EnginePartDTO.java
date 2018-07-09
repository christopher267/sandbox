package com.charles.sandbox.business.dataobject.part;

public class EnginePartDTO extends PartDTO {
	
	private static final long serialVersionUID = 1L;
	
	private Long pistonCount;

	public Long getPistonCount() {
		return pistonCount;
	}

	public void setPistonCount(Long pistonCount) {
		this.pistonCount = pistonCount;
	}
}
