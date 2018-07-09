package com.charles.sandbox.persist.dataobject.part;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "INTERIOR_PART")
public class InteriorPart extends Part {
	
	@Column
	private Long seatCount;

	public Long getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Long seatCount) {
		this.seatCount = seatCount;
	}
}
