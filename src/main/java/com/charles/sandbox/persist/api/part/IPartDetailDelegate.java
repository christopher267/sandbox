package com.charles.sandbox.persist.api.part;

import com.charles.sandbox.business.dataobject.part.PartDetailDTO;
import com.charles.sandbox.persist.exception.PersistException;

public interface IPartDetailDelegate<T extends PartDetailDTO> {
	
	public T createPart(T partDetailDTO) throws PersistException;
	
	public T updatePart(T partDetailDTO) throws PersistException;
	
	public void deletePart(Long id) throws PersistException;
	
	public T readPart(Long id) throws PersistException;

}
