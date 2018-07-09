package com.charles.sandbox.persist.automobile;

import java.util.List;

import com.charles.sandbox.persist.api.automobile.IAutomobileDelegate;
import com.charles.sandbox.web.dataobject.v1.AutomobileDTO;

public class AutomobileDelegate implements IAutomobileDelegate<AutomobileDTO> {

	@Override
	public AutomobileDTO createAutomobile(AutomobileDTO automobileDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutomobileDTO updateAutomobile(AutomobileDTO automobileDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAutomobile(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AutomobileDTO getAutomobile(String manufacturer, String model, Long year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AutomobileDTO getAutomobile(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AutomobileDTO> getAutomobiles(List<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
