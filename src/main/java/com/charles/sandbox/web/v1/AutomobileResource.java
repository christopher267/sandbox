package com.charles.sandbox.web.v1;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charles.sandbox.business.api.automobile.IAutomobileService;
import com.charles.sandbox.web.dataobject.v1.AutomobileDTO;

@RestController
@RequestMapping(value = "v1/Automobile")
public class AutomobileResource {
    
    @Resource
    IAutomobileService automobileService;
    
    //TODO: Add in memory database for demo http://www.springboottutorial.com/spring-boot-and-h2-in-memory-database
    
    @RequestMapping(method = RequestMethod.GET, 
    		produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public AutomobileDTO getAutomobile(@RequestParam(required=true) String manufacturer,
    		@RequestParam(required=true) String model,
    		@RequestParam(required=true) Long year,
    		@RequestParam(required=false) Boolean orderableParts) throws Exception {
        return automobileService.getAutomobile(manufacturer, model, year, orderableParts);
    }
    
    @RequestMapping(method = RequestMethod.POST, 
    		produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public AutomobileDTO createAutomobile(@RequestBody AutomobileDTO automobile) throws Exception {
    	return automobileService.createAutomobile(automobile);
    }
    
    @RequestMapping(method = RequestMethod.PUT, 
    		produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public AutomobileDTO updateAutomobile(@RequestBody AutomobileDTO automobile) throws Exception {
        return automobileService.updateAutomobile(automobile);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, 
    		produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteAutomobile(@PathVariable("id") Long automobileId) throws Exception {
    	automobileService.deleteAutomobile(automobileId);
    }
    
    @RequestMapping(value = "/findByPart/{partName}", method = RequestMethod.GET, 
    		produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<AutomobileDTO> getAutomobile(@PathVariable("partName") String partName) throws Exception {
        return automobileService.findByPart(partName);
    }
}
