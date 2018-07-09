package com.charles.sandbox.business.api.automobile;

import java.util.List;

import com.charles.sandbox.business.exception.ServiceException;
import com.charles.sandbox.web.dataobject.v1.AutomobileDTO;

public interface IAutomobileService {
	
	/**
	 * Creates a new instance of an Automobile.
	 * 
	 * @param automobileDTO
	 * @return
	 * @throws ServiceException
	 */
	public AutomobileDTO createAutomobile(AutomobileDTO automobileDTO) throws ServiceException;
	
	/**
	 * Persists an Automobile as passed in.
	 * 
	 * @param automobileDTO
	 * @return
	 * @throws ServiceException
	 */
	public AutomobileDTO updateAutomobile(AutomobileDTO automobileDTO) throws ServiceException;
	
	/**
	 * Deletes an Automobile based on it's unique ID.
	 * 
	 * @param id
	 * @throws ServiceException
	 */
	public void deleteAutomobile(Long id) throws ServiceException;
	
	/**
	 * Returns a specific Automobile based on it's unique identifiers.
	 * 
	 * @param manufacturer
	 * @param model
	 * @param year
	 * @param orderableParts will determine if parts are filtered by whether they are currently orderable.
	 * @return
	 * @throws ServiceException
	 */
	public AutomobileDTO getAutomobile(String manufacturer, String model, Long year, Boolean orderableParts) throws ServiceException;
	
	/**
	 * Returns a list of Automobiles that are associated to a Part by PartName
	 * 
	 * @param partName
	 * @return
	 * @throws ServiceException
	 */
	public List<AutomobileDTO> findByPart(String partName) throws ServiceException;
	
}
