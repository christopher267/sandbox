package com.charles.sandbox.persist.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.charles.sandbox.persist.dataobject.automobile.Automobile;
import com.charles.sandbox.web.dataobject.v1.AutomobileDTO;

@Component
public class AutomobileMapperUtil {
	
	//TODO: implement mapping such as Orika
	
	/**
	 * Maps an AutomobileDTO to an Automobile
	 * @param automobile
	 * @return
	 */
	public Automobile map(Automobile automobile, AutomobileDTO automobileDTO) {
		//TODO: implement mapping
		return automobile;
	}
	
	/**
	 * Maps an Automobile to an AutomobileDTO
	 * @param automobile
	 * @param automobileDTO
	 * @return
	 */
	public AutomobileDTO mapReverse(Automobile automobile, AutomobileDTO automobileDTO) {
		//TODO: implement mapping
		return automobileDTO;
	}
	
	/**
	 * Maps a List of Automobile to a List of AutomobileDTO
	 * @param automobiles
	 * @param automobileDTOs
	 * @return
	 */
	public List<AutomobileDTO> mapReverseList(List<Automobile> automobiles, List<AutomobileDTO> automobileDTOs) {
		//TODO: implement mapping
		return automobileDTOs;
	}
}
