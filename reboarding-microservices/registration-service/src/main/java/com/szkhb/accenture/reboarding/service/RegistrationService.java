package com.szkhb.accenture.reboarding.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szkhb.accenture.reboarding.RegistrationServiceApplication;
import com.szkhb.accenture.reboarding.domain.EntryRequest;
import com.szkhb.accenture.reboarding.service.commons.discovery.EntryRequestHandlerProvider;

@Service
public class RegistrationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceApplication.class);

  @Autowired
  EntryRequestHandlerProvider entryRequestHandler;

  public EntryRequest getExistingOrCreateNewEntryRequest(int userId) {
    EntryRequest entryRequest = entryRequestHandler.getExistingEntryRequest(userId);

    if (entryRequest == null) {
      entryRequest = entryRequestHandler.getExistingOrCreateNewEntryRequest(userId);
    }

    if (entryRequest == null) {
      // TODO: throw exception: UNABLE TO CREATE NEW ENTRY FOR USER
      LOGGER.error("unable to create EntryRequest for " + userId);
    }

    return entryRequest;
  }

}
