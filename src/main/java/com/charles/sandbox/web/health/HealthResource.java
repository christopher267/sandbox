package com.charles.sandbox.web.health;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charles.sandbox.web.dataobject.health.HealthVO;

@RestController
@RequestMapping(value = "/health")
public class HealthResource {
    
    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HealthVO ping() {
    	HealthVO healthVO = new HealthVO();
    	healthVO.setStatus("UP");
    	return healthVO;
    }
}