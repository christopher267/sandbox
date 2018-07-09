package com.charles.sandbox.persist.part;

import java.util.List;

import org.springframework.stereotype.Component;

import com.charles.sandbox.business.dataobject.part.EnginePartDTO;
import com.charles.sandbox.persist.api.part.IPartDelegate;

@Component
public class EnginePartDelegate implements IPartDelegate<EnginePartDTO> {

	@Override
	public EnginePartDTO createPart(EnginePartDTO partDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnginePartDTO updatePart(EnginePartDTO partDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnginePartDTO readPart(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePart(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EnginePartDTO> readParts(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnginePartDTO> readParts(Long automobileId) {
		// TODO Auto-generated method stub
		return null;
	}
}
