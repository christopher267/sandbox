package com.charles.sandbox.persist.dataobject.part;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ENGINE_PART")
public class EnginePart extends Part {

	@Column
	private Long pistonCount;

	public Long getPistonCount() {
		return pistonCount;
	}

	public void setPistonCount(Long pistonCount) {
		this.pistonCount = pistonCount;
	}
}
