package com.charles.sandbox.web.dataobject.v1;

import java.io.Serializable;
import java.util.List;

import com.charles.sandbox.business.dataobject.part.EnginePartDTO;
import com.charles.sandbox.business.dataobject.part.InteriorPartDTO;

public class AutomobileDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private List<EnginePartDTO> engineParts;
	private List<InteriorPartDTO> interiorParts;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<EnginePartDTO> getEngineParts() {
		return engineParts;
	}
	public void setEngineParts(List<EnginePartDTO> engineParts) {
		this.engineParts = engineParts;
	}
	public List<InteriorPartDTO> getInteriorParts() {
		return interiorParts;
	}
	public void setInteriorParts(List<InteriorPartDTO> interiorParts) {
		this.interiorParts = interiorParts;
	}
}
