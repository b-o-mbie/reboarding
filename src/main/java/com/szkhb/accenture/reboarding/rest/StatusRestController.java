package com.szkhb.accenture.reboarding.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.szkhb.accenture.reboarding.service.ServiceFacade;


@RestController
@RequestMapping("status")
public class StatusRestController {

	private final ServiceFacade serviceFacade = new ServiceFacade();
	
	@RequestMapping(value = "/**")
	public String getStatus(@RequestParam int id){
		return serviceFacade.getStatusForRequest(id);
	}
}
