package com.charles.sandbox.persist.part;

import java.util.List;

import org.springframework.stereotype.Component;

import com.charles.sandbox.business.dataobject.part.EnginePartDTO;
import com.charles.sandbox.persist.api.part.IPartDelegate;

@Component(value="enginePartDelegate")
public class EnginePartDelegate implements IPartDelegate<EnginePartDTO> {
	
	//TODO: Add engine part DAO
	
	@Override
	public EnginePartDTO create(EnginePartDTO partDTO) {
		return partDTO;
	}

	@Override
	public EnginePartDTO update(EnginePartDTO partDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnginePartDTO get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EnginePartDTO> get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnginePartDTO> getByAutomobileId(Long automobileId) {
		// TODO Auto-generated method stub
		return null;
	}
}
