package com.charles.sandbox.business.dataobject.part;

public class InteriorPartDTO extends PartDTO {
	
	private static final long serialVersionUID = 1L;
	
	private Long seatCount;

	public Long getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Long seatCount) {
		this.seatCount = seatCount;
	}
}
