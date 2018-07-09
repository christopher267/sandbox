package com.charles.sandbox.api.part;

import java.util.List;

import com.charles.sandbox.business.dataobject.part.PartDTO;
import com.charles.sandbox.business.exception.ServiceException;

public interface IPartSerice<T extends PartDTO> {
	
	public T createPart(T part) throws ServiceException;
	
	public List<T> createParts(List<T> parts) throws ServiceException;
	
	public T updatePart(T part) throws ServiceException;
	
	public void deletePart(Long id) throws ServiceException;
	
	public T getPart(Long id) throws ServiceException;
	
	public List<T> getParts(Long automobileId, Boolean orderable) throws ServiceException;
	
	public List<T> getParts(String name) throws ServiceException;

}
