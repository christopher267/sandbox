package com.charles.sandbox.business.part;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.charles.sandbox.business.api.part.IPartService;
import com.charles.sandbox.business.dataobject.part.EnginePartDTO;
import com.charles.sandbox.business.exception.ServiceException;
import com.charles.sandbox.persist.api.part.IPartDelegate;
import com.charles.sandbox.remote.api.dataobject.OrderablePartDTO;
import com.charles.sandbox.remote.api.exception.RemotingException;

@Component(value="enginePartService")
public class EnginePartService extends PartService implements IPartService<EnginePartDTO> {

	@Resource
	IPartDelegate<EnginePartDTO> enginePartDelegate;
	
	@Resource
	PartPredicate<EnginePartDTO> partPredicate;
	
	@Override
	public EnginePartDTO create(EnginePartDTO partDTO) throws ServiceException {
		return enginePartDelegate.create(partDTO);
	}

	@Override
	public EnginePartDTO update(EnginePartDTO partDTO) throws ServiceException {
		return enginePartDelegate.update(partDTO);
	}

	@Override
	public void delete(Long id) throws ServiceException {
		enginePartDelegate.delete(id);
	}

	@Override
	public List<EnginePartDTO> get(Long automobileId, boolean orderable) throws ServiceException {
		List<EnginePartDTO> engineParts = enginePartDelegate.getByAutomobileId(automobileId);
		
		if(orderable) {
			getOrderableParts(engineParts);
		}

		return engineParts;
	}

	@Override
	public List<EnginePartDTO> create(List<EnginePartDTO> parts) throws ServiceException {
		
		if(CollectionUtils.isEmpty(parts)) return null;
		
		List<EnginePartDTO> createdParts = new ArrayList<>();
		
		parts.stream().forEach(enginePart -> 
			createdParts.add(enginePartDelegate.create(enginePart)));
		
		return createdParts;
	}
	
	//TODO: This is the same code in InteriorParts, consolidate this functionality to base PartService -CTC
	private List<EnginePartDTO> getOrderableParts(List<EnginePartDTO> engineParts) throws ServiceException {
			Map<String, OrderablePartDTO> orderablePartMap;
			try {
				orderablePartMap = partStoreClient.getParts();
			} catch (RemotingException e) {
				//TODO: Add logging
				throw new ServiceException(String.format("Error retrieving orderable parts. Error: %s", e.getMessage()));
			}
			
	        engineParts = partPredicate
	                .filterParts(engineParts, partPredicate.isPartOrderable(orderablePartMap));
	        
	        return engineParts;
	}

	@Override
	public List<EnginePartDTO> get(String name) throws ServiceException {
		return enginePartDelegate.get(name);
	}

	@Override
	public EnginePartDTO get(Long id) throws ServiceException {
		return enginePartDelegate.get(id);
	}
	
}
