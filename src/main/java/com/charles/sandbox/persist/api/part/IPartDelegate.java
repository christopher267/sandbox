package com.charles.sandbox.persist.api.part;

import java.util.List;

import com.charles.sandbox.business.dataobject.part.PartDTO;

public interface IPartDelegate<T extends PartDTO> {
	
	public T create(T partDTO);
	
	public T update(T partDTO);
	
	public void delete(Long id);
	
	public List<T> getByAutomobileId(Long automobileId);
	
	public T get(Long id);
	
	public List<T> get(String name);

}
