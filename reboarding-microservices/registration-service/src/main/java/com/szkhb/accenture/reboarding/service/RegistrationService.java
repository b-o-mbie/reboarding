package com.szkhb.accenture.reboarding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szkhb.accenture.reboarding.domain.EntryRequest;
import com.szkhb.accenture.reboarding.service.httpcommons.EntryRequestHandlerProvider;

@Service
public class RegistrationService {

	@Autowired
	EntryRequestHandlerProvider entryRequestHandler;

	public EntryRequest getExistingOrCreateNewEntryRequest(int userId) {
		EntryRequest entryRequest = entryRequestHandler.getExistingEntryRequest(userId);

		if (entryRequest == null) {
			entryRequest = entryRequestHandler.createNewEntryRequest(userId);
		}

		if (entryRequest == null) {
			// TODO: throw exception: UNABLE TO CREATE NEW ENTRY FOR USER
		}

		return entryRequest;
	}

}
