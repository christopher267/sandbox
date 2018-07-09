package com.charles.sandbox.business.part;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.charles.sandbox.business.api.part.IPartService;
import com.charles.sandbox.business.dataobject.part.EnginePartDTO;
import com.charles.sandbox.business.dataobject.part.PartDetailDTO;
import com.charles.sandbox.business.exception.ServiceException;
import com.charles.sandbox.persist.api.part.IPartDelegate;
import com.charles.sandbox.persist.api.part.IPartDetailDelegate;
import com.charles.sandbox.remote.api.dataobject.OrderablePartDTO;
import com.charles.sandbox.remote.api.exception.RemotingException;

@Component
public class EnginePartService extends PartService implements IPartService<EnginePartDTO> {

	@Resource
	IPartDelegate<EnginePartDTO> partDelegate;
	
	@Resource
	IPartDetailDelegate<PartDetailDTO> partDetailDelegate;
	
	@Resource
	PartPredicate<EnginePartDTO> partPredicate;
	
	@Override
	public EnginePartDTO createPart(EnginePartDTO partDTO) throws ServiceException {
		return partDelegate.createPart(partDTO);
	}

	@Override
	public EnginePartDTO updatePart(EnginePartDTO partDTO) throws ServiceException {
		return partDelegate.updatePart(partDTO);
	}

	@Override
	public void deletePart(Long id) throws ServiceException {
		partDelegate.deletePart(id);
	}

	@Override
	public List<EnginePartDTO> getParts(Long automobileId, Boolean orderable) throws ServiceException {
		List<EnginePartDTO> engineParts = partDelegate.readParts(automobileId);
		
		if(orderable) {
			getOrderableParts(engineParts);
		}

		return engineParts;
	}

	@Override
	public List<EnginePartDTO> createParts(List<EnginePartDTO> parts) throws ServiceException {
		
		if(CollectionUtils.isEmpty(parts)) return null;
		
		List<EnginePartDTO> createdParts = new ArrayList<>();
		
		parts.stream().forEach(enginePart -> 
			createdParts.add(partDelegate.createPart(enginePart)));
		
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
	public List<EnginePartDTO> getParts(String name) throws ServiceException {
		return partDelegate.readParts(name);
	}

	@Override
	public EnginePartDTO getPart(Long id) throws ServiceException {
		return partDelegate.readPart(id);
	}
	
}
