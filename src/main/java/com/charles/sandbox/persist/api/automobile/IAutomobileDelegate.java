package com.charles.sandbox.persist.api.automobile;

import java.util.List;

import com.charles.sandbox.web.dataobject.v1.AutomobileDTO;

public interface IAutomobileDelegate<T extends AutomobileDTO> {
	
	public void create(T automobileDTO);
	
	public void update(T automobileDTO);
	
	public void delete(Long id);
	
	public T get(String manufacturer, String model, Long year);
	
	public T get(Long id);
	
	public List<T> get(List<Long> ids);

}
