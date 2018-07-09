package com.charles.sandbox.persist.api.part;

import java.util.List;

import com.charles.sandbox.business.dataobject.part.PartDTO;

public interface IPartDelegate<T extends PartDTO> {
	
	public T createPart(T partDTO);
	
	public T updatePart(T partDTO);
	
	public void deletePart(Long id);
	
	public List<T> readParts(Long automobileId);
	
	public T readPart(Long id);
	
	public List<T> readParts(String name);

}
