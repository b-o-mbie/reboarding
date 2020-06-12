package com.szkhb.accenture.reboarding.service;

public interface EntryRequestHandlerService {

	public String createNewRequest();

	public String getStatusForRequest(int id);

	public String tryEnter(int id);

	public String tryExit(int id);
}
