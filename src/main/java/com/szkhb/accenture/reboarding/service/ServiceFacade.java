package com.szkhb.accenture.reboarding.service;

public class ServiceFacade {

	private EntryRequestHandlerService dummyEntryRequestHandlerService;
	
	public ServiceFacade() {
		dummyEntryRequestHandlerService = new DummyEntryRequestHandlerService();
	}
	
	public String tryEnter(int id) {
		return dummyEntryRequestHandlerService.tryEnter(id);
	}
	
	public String tryExit(int id) {
		return dummyEntryRequestHandlerService.tryExit(id);
	}
	
	public String createNewRequest(){
		return dummyEntryRequestHandlerService.createNewRequest();
	}
	
	public String getStatusForRequest(int id){
		return dummyEntryRequestHandlerService.getStatusForRequest(id);
	}
}
