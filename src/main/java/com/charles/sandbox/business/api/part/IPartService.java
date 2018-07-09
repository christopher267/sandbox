package com.charles.sandbox.business.api.part;

import java.util.List;

import com.charles.sandbox.business.dataobject.part.PartDTO;
import com.charles.sandbox.business.exception.ServiceException;

public interface IPartService<T extends PartDTO> {
	
	/**
	 * Creates a Part
	 * 
	 * @param part
	 * @return
	 * @throws ServiceException
	 */
	public T create(T part) throws ServiceException;
	
	/**
	 * Creates a List of Parts
	 * 
	 * @param parts
	 * @return
	 * @throws ServiceException
	 */
	public List<T> create(List<T> parts) throws ServiceException;
	
	/**
	 * Updates a Part
	 * 
	 * @param part
	 * @return
	 * @throws ServiceException
	 */
	public T update(T part) throws ServiceException;
	
	/**
	 * Deletes Part by it's unique ID
	 * 
	 * @param id
	 * @throws ServiceException
	 */
	public void delete(Long id) throws ServiceException;
	
	/**
	 * Returns a part by it's ID
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public T get(Long id) throws ServiceException;
	
	/**
	 * Returns a list of parts associated to an automobile ID. 
	 * 
	 * @param orderable will determine if parts are filtered by whether they are currently orderable.
	 * @return
	 * @throws ServiceException
	 */
	public List<T> get(Long automobileId, Boolean orderable) throws ServiceException;
	
	/**
	 * Returns a List of Parts based on part name.
	 * 
	 * @param name
	 * @return
	 * @throws ServiceException
	 */
	public List<T> get(String name) throws ServiceException;

}
