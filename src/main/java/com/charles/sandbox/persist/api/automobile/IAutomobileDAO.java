package com.charles.sandbox.persist.api.automobile;

import java.util.List;

import com.charles.sandbox.persist.dataobject.automobile.Automobile;

public interface IAutomobileDAO<T extends Automobile> {
	
	public void create(T automobile);
	
	public void update(T automobile);
	
	public void delete(Long id);
	
	public T get(String manufacturer, String model, Long year);
	
	public T get(Long id);
	
	public List<T> get(List<Long> ids);
	
}
