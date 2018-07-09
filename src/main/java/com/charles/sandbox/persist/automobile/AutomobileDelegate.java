package com.charles.sandbox.persist.automobile;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.charles.sandbox.persist.api.automobile.IAutomobileDAO;
import com.charles.sandbox.persist.api.automobile.IAutomobileDelegate;
import com.charles.sandbox.persist.dataobject.automobile.Automobile;
import com.charles.sandbox.persist.util.AutomobileMapperUtil;
import com.charles.sandbox.web.dataobject.v1.AutomobileDTO;

@Component
public class AutomobileDelegate implements IAutomobileDelegate<AutomobileDTO> {

	@Resource
	IAutomobileDAO<Automobile> automobileDAO;
	
	@Resource
	AutomobileMapperUtil mapperUtil;
	
	@Override
	public void create(AutomobileDTO automobileDTO) {
		automobileDAO.create(mapperUtil.map(new Automobile(), automobileDTO));
	}

	@Override
	public void update(AutomobileDTO automobileDTO) {
		automobileDAO.update(mapperUtil.map(new Automobile(), automobileDTO));
		
	}

	@Override
	public void delete(Long id) {
		automobileDAO.delete(id);
	}

	@Override
	public AutomobileDTO get(String manufacturer, String model, Long year) {
		return mapperUtil.mapReverse(automobileDAO.get(manufacturer, model, year), new AutomobileDTO());
	}

	@Override
	public AutomobileDTO get(Long id) {
		return mapperUtil.mapReverse(automobileDAO.get(id), new AutomobileDTO());
	}

	@Override
	public List<AutomobileDTO> get(List<Long> ids) {
		return mapperUtil.mapReverseList(automobileDAO.get(ids), new ArrayList<AutomobileDTO>());
	}
}
