package com.szkhb.accenture.reboarding.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.szkhb.accenture.reboarding.service.EntryRequestHandlerService;

@RestController
@RequestMapping("exit")
public class ExitRestController {

	@Autowired
	private EntryRequestHandlerService service;

	@RequestMapping(value = "/**")
	public String exit(@RequestParam int id) {
		return service.tryExit(id);
	}
}
