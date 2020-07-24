package com.szkhb.accenture.reboarding.service.basic;

import org.springframework.stereotype.Service;

import com.szkhb.accenture.reboarding.domain.DescriptiveEntryRequestWrapper;
import com.szkhb.accenture.reboarding.domain.EntryRequest;

@Service
public class DescriptiveEntryRequestWrapperService {

  public DescriptiveEntryRequestWrapper wrap(EntryRequest entryRequest) {
    DescriptiveEntryRequestWrapper bundle = new DescriptiveEntryRequestWrapper();
    bundle.setEntryRequest(entryRequest);
    bundle.setPosition(0);
    return bundle;
  }
}
