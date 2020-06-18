package com.szkhb.accenture.reboarding.service.basic;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.szkhb.accenture.reboarding.domain.EntryRequest;

@Service
public class EntryRequestProviderService {

	public Optional<EntryRequest> findEntryRequestByUserId(int userId) {
		return Optional.empty();
	}

	public EntryRequest getExistingOrNewEntryRequestById(int userId) {
		return null;
	}

}
