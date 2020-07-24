package com.szkhb.accenture.reboarding.service.basic;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szkhb.accenture.reboarding.domain.EntryRequest;
import com.szkhb.accenture.reboarding.repository.EntryRequestRepository;

@Service
public class EntryRequestProviderService {

  @Autowired
  private EntryRequestCreatorSerivce creatorService;

  @Autowired
  private EntryRequestRepository repository;

  public Optional<EntryRequest> getExistingEntryRequest(int userId) {
    return repository.findById(userId);
  }

  public EntryRequest getExistingOrCreateNewEntryRequest(int userId) {
    return getExistingEntryRequest(userId)
      .orElseGet(() -> creatorService.createEntryRequestForUser(userId));
  }

}
