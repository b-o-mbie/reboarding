package com.szkhb.accenture.reboarding.service.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szkhb.accenture.reboarding.domain.EntryRequest;
import com.szkhb.accenture.reboarding.domain.User;
import com.szkhb.accenture.reboarding.repository.EntryRequestRepository;

@Service
public class EntryRequestCreatorSerivce {

  @Autowired
  private EntryRequestRepository repository;

  public EntryRequest createEntryRequestForUser(int userId) {
    EntryRequest entryRequest = getEntry(userId);
    repository.save(entryRequest);
    return entryRequest;
  }

  private EntryRequest getEntry(int userId) {
    EntryRequest entryRequest = new EntryRequest();
    entryRequest.setUser(getUser(userId));
    return entryRequest;
  }

  private User getUser(int userId) {
    User user = new User();
    user.setId(userId);
    return user;
  }
}
