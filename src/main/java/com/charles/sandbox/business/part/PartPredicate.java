package com.charles.sandbox.business.part;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.charles.sandbox.business.dataobject.part.PartDTO;
import com.charles.sandbox.remote.api.dataobject.OrderablePartDTO;

@Component
public class PartPredicate<T extends PartDTO> {
	
    public Predicate<PartDTO> isPartOrderable(Map<String, OrderablePartDTO> orderablePartMap) {
        return p -> CollectionUtils.isEmpty(orderablePartMap) || orderablePartMap.containsKey(p.getPartName());
    }
     
    public List<T> filterParts(List<T> parts, Predicate<PartDTO> predicate) {
        return parts.stream().filter(predicate).collect(Collectors.<T>toList());
    }
}