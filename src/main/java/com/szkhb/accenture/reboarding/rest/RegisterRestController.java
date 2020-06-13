package com.szkhb.accenture.reboarding.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.szkhb.accenture.reboarding.service.ServiceFacade;

@RestController
@RequestMapping("register")
public class RegisterRestController {
	
	private final ServiceFacade serviceFacade = new ServiceFacade();
	
	@RequestMapping(value = "/**")
	public String getStatus(){
		return serviceFacade.createNewRequest();
	}
}
