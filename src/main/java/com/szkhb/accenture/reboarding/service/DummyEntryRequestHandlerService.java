package com.szkhb.accenture.reboarding.service;

import org.springframework.stereotype.Service;

@Service
public class DummyEntryRequestHandlerService implements EntryRequestHandlerService {

	@Override
	public String createNewRequest() {
		return "==> return with new EntryRequest";
	}

	@Override
	public String getStatusForRequest(int id) {
		return "==> getStatusForRequest: ID: "+id;
	}

	@Override
	public String tryEnter(int id) {
		return "==> tryEnter: ID: "+id;
	}

	@Override
	public String tryExit(int id) {
		return "==> tryExit: ID: "+id;
	}

}
