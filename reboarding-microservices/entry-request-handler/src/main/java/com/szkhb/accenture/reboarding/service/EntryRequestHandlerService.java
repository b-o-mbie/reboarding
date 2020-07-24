package com.szkhb.accenture.reboarding.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szkhb.accenture.reboarding.domain.DescriptiveEntryRequestWrapper;
import com.szkhb.accenture.reboarding.domain.EntryRequest;
import com.szkhb.accenture.reboarding.service.basic.DescriptiveEntryRequestWrapperService;
import com.szkhb.accenture.reboarding.service.basic.EntryRequestProviderService;

@Service
public class EntryRequestHandlerService {

  @Autowired
  private EntryRequestProviderService entryRequestProviderService;

  @Autowired
  private DescriptiveEntryRequestWrapperService descriptiveEntryRequestBundlerService;

  public EntryRequest getExistingOrCreateNewEntryRequest(int userId) {
    return entryRequestProviderService.getExistingOrCreateNewEntryRequest(userId);
  }

  public Optional<EntryRequest> getExistingEntryRequest(int userId) {
    return entryRequestProviderService.getExistingEntryRequest(userId);
  }

  public Optional<DescriptiveEntryRequestWrapper> getStatusForRequest(int userId) {
    return getExistingEntryRequest(userId)
      .map(descriptiveEntryRequestBundlerService::wrap);
  }

  public Boolean tryEnter(int id) {
    return null;
  }

  public Boolean tryExit(int id) {
    return null;
  }

}
