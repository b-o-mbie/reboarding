package com.szkhb.accenture.reboarding.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.szkhb.accenture.reboarding.service.EntryRequestHandlerService;

@RestController
@RequestMapping("status")
public class StatusRestController {

	@Autowired
	private EntryRequestHandlerService service;

	@RequestMapping(value = "/**")
	public String getStatus(@RequestParam int id) {
		return service.getStatusForRequest(id);
	}
}
