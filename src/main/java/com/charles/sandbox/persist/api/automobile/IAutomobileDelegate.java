package com.charles.sandbox.persist.api.automobile;

import java.util.List;

import com.charles.sandbox.web.dataobject.v1.AutomobileDTO;

public interface IAutomobileDelegate<T extends AutomobileDTO> {
	
	public T createAutomobile(T automobileDTO);
	
	public T updateAutomobile(T automobileDTO);
	
	public void deleteAutomobile(Long id);
	
	public T getAutomobile(String manufacturer, String model, Long year);
	
	public T getAutomobile(Long id);
	
	public List<T> getAutomobiles(List<Long> ids);
	
}
