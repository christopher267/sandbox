package com.charles.sandbox.business.api.automobile;

import java.util.List;

import com.charles.sandbox.business.exception.ServiceException;
import com.charles.sandbox.web.dataobject.v1.AutomobileDTO;

public interface IAutomobileService {
	
	public AutomobileDTO createAutomobile(AutomobileDTO automobileDTO) throws ServiceException;
	
	public AutomobileDTO updateAutomobile(AutomobileDTO automobileDTO) throws ServiceException;
	
	public void deleteAutomobile(Long id) throws ServiceException;
	
	public AutomobileDTO getAutomobile(String manufacturer, String model, Long year, Boolean orderableParts) throws ServiceException;
	
	public List<AutomobileDTO> findByPart(String partName) throws ServiceException;
	
}
