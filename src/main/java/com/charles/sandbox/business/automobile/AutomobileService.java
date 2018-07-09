package com.charles.sandbox.business.automobile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.charles.sandbox.business.api.automobile.IAutomobileService;
import com.charles.sandbox.business.api.part.IPartService;
import com.charles.sandbox.business.dataobject.part.EnginePartDTO;
import com.charles.sandbox.business.dataobject.part.InteriorPartDTO;
import com.charles.sandbox.business.exception.ServiceException;
import com.charles.sandbox.persist.api.automobile.IAutomobileDelegate;
import com.charles.sandbox.web.dataobject.v1.AutomobileDTO;

@Component
public class AutomobileService implements IAutomobileService {
	
	@Resource
	IAutomobileDelegate<AutomobileDTO> automobileDelegate;
	
	@Resource
	IPartService<EnginePartDTO> enginePartService;
	
	@Resource
	IPartService<InteriorPartDTO> interiorPartService;
	
	@Override
	public AutomobileDTO createAutomobile(AutomobileDTO automobileDTO) throws ServiceException {
		
		try {
			automobileDelegate.create(automobileDTO);
			
			enginePartService.create(automobileDTO.getEngineParts());
			
			interiorPartService.create(automobileDTO.getInteriorParts());
			
		} catch (ServiceException e) {
			// TODO: Add logging
			throw e;
		}
		
		return automobileDTO;
	}

	@Override
	public AutomobileDTO updateAutomobile(AutomobileDTO automobileDTO) throws ServiceException {
		automobileDelegate.update(automobileDTO);
		return automobileDTO;
	}

	@Override
	public void deleteAutomobile(Long id) throws ServiceException {
		automobileDelegate.delete(id);
	}

	@Override
	public AutomobileDTO getAutomobile(String manufacturer, String model, Long year, Boolean orderableParts) throws ServiceException {
		AutomobileDTO automobileDTO = automobileDelegate.get(manufacturer, model, year);
		
		automobileDTO.setEngineParts(enginePartService.get(automobileDTO.getId(), orderableParts));
		automobileDTO.setInteriorParts(interiorPartService.get(automobileDTO.getId(), orderableParts));
		
		return automobileDTO;
	}

	@Override
	public List<AutomobileDTO> findByPart(String partName) throws ServiceException {
		
		List<EnginePartDTO> parts = enginePartService.get(partName);
		
		List<Long> automobileIds = new ArrayList<>();
		automobileIds = parts.stream().map(EnginePartDTO::getId).collect(Collectors.toList());
		
		List<AutomobileDTO> automobileList = automobileDelegate.get(automobileIds);
		
		return automobileList;
	}
}
