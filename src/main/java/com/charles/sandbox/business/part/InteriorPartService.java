package com.charles.sandbox.business.part;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.charles.sandbox.business.api.part.IPartService;
import com.charles.sandbox.business.dataobject.part.InteriorPartDTO;
import com.charles.sandbox.business.dataobject.part.PartDetailDTO;
import com.charles.sandbox.business.exception.ServiceException;
import com.charles.sandbox.persist.api.part.IPartDelegate;
import com.charles.sandbox.persist.api.part.IPartDetailDelegate;
import com.charles.sandbox.remote.api.dataobject.OrderablePartDTO;
import com.charles.sandbox.remote.api.exception.RemotingException;

@Component
public class InteriorPartService extends PartService implements IPartService<InteriorPartDTO> {

	@Resource
	IPartDelegate<InteriorPartDTO> partDelegate;
	
	@Resource
	IPartDetailDelegate<PartDetailDTO> partDetailDelegate;
	
	@Resource
	PartPredicate<InteriorPartDTO> partPredicate;
	
	@Override
	public InteriorPartDTO createPart(InteriorPartDTO partDTO) throws ServiceException {
		return partDelegate.createPart(partDTO);
	}
	
	@Override
	public List<InteriorPartDTO> getParts(Long automobileId, Boolean orderable) throws ServiceException {
		List<InteriorPartDTO> interiorParts = partDelegate.readParts(automobileId);
		
		if(orderable) {
			getOrderableParts(interiorParts);
		}

		return interiorParts;
	}

	@Override
	public InteriorPartDTO updatePart(InteriorPartDTO partDTO) throws ServiceException {
		return partDelegate.updatePart(partDTO);
	}

	@Override
	public void deletePart(Long id) throws ServiceException {
		partDelegate.deletePart(id);
	}

	@Override
	public InteriorPartDTO getPart(Long id) throws ServiceException {
		return partDelegate.readPart(id);
	}

	@Override
	public List<InteriorPartDTO> createParts(List<InteriorPartDTO> parts) throws ServiceException {
		
		if(CollectionUtils.isEmpty(parts)) return null;
		
		List<InteriorPartDTO> createdParts = new ArrayList<>();
		
		parts.stream().forEach(enginePart -> 
			createdParts.add(partDelegate.createPart(enginePart)));
		
		return createdParts;
	}

	@Override
	public List<InteriorPartDTO> getParts(String name) throws ServiceException {
		return partDelegate.readParts(name);
	}
	
	//TODO: This is the same code in EngineParts, consolidate this functionality to base PartService -CTC
	private List<InteriorPartDTO> getOrderableParts(List<InteriorPartDTO> interiorParts) throws ServiceException {
		Map<String, OrderablePartDTO> orderablePartMap;
		try {
			orderablePartMap = partStoreClient.getParts();
		} catch (RemotingException e) {
			//TODO: Add logging
			throw new ServiceException(String.format("Error retrieving orderable parts. Error: %s", e.getMessage()));
		}
		
        interiorParts = partPredicate
                .filterParts(interiorParts, partPredicate.isPartOrderable(orderablePartMap));
        
        return interiorParts;
}
}
