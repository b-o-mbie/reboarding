package com.szkhb.accenture.reboarding.service.httpcommons.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.szkhb.accenture.reboarding.domain.EntryRequest;

@Service
public class EntryRequestToJSONConverterService {

	@Autowired
	ObjectWriter writer;

	public String entryRequestToJSON(EntryRequest entryRequest) {
		String json = null;
		try {
			writer.writeValueAsString(entryRequest);
		} catch (JsonProcessingException e) {
			json = e.getMessage();
		}
		return json;
	}
}
