package com.charles.sandbox.business.automobile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.charles.sandbox.api.part.IPartSerice;
import com.charles.sandbox.business.api.automobile.IAutomobileService;
import com.charles.sandbox.business.dataobject.part.EnginePartDTO;
import com.charles.sandbox.business.dataobject.part.InteriorPartDTO;
import com.charles.sandbox.business.exception.ServiceException;
import com.charles.sandbox.persist.api.automobile.IAutomobileDelegate;
import com.charles.sandbox.web.dataobject.v1.AutomobileDTO;

public class AutomobileService implements IAutomobileService {
	
	@Resource
	IAutomobileDelegate<AutomobileDTO> automobileDelegate;
	
	@Resource
	IPartSerice<EnginePartDTO> enginePartService;
	
	@Resource
	IPartSerice<InteriorPartDTO> interiorPartService;
	
	@Override
	public AutomobileDTO createAutomobile(AutomobileDTO automobileDTO) throws ServiceException {
		
		try {
			automobileDTO = automobileDelegate.createAutomobile(automobileDTO);
			
			enginePartService.createParts(automobileDTO.getEngineParts());
			
			interiorPartService.createParts(automobileDTO.getInteriorParts());
			
		} catch (ServiceException e) {
			// TODO: Add logging
			throw e;
		}
		
		return automobileDTO;
	}

	@Override
	public AutomobileDTO updateAutomobile(AutomobileDTO automobileDTO) throws ServiceException {
		return automobileDelegate.updateAutomobile(automobileDTO);
	}

	@Override
	public void deleteAutomobile(Long id) throws ServiceException {
		automobileDelegate.deleteAutomobile(id);
	}

	@Override
	public AutomobileDTO getAutomobile(String manufacturer, String model, Long year, Boolean orderableParts) throws ServiceException {
		AutomobileDTO automobileDTO = automobileDelegate.getAutomobile(manufacturer, model, year);
		
		automobileDTO.setEngineParts(enginePartService.getParts(automobileDTO.getId(), orderableParts));
		automobileDTO.setInteriorParts(interiorPartService.getParts(automobileDTO.getId(), orderableParts));
		
		return automobileDTO;
	}

	@Override
	public List<AutomobileDTO> findByPart(String partName) throws ServiceException {
		
		List<EnginePartDTO> parts = enginePartService.getParts(partName);
		
		List<Long> automobileIds = new ArrayList<>();
		automobileIds = parts.stream().map(EnginePartDTO::getId).collect(Collectors.toList());
		
		List<AutomobileDTO> automobileList = automobileDelegate.getAutomobiles(automobileIds);
		
		return automobileList;
	}
}
