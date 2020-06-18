package com.szkhb.accenture.reboarding.service.midsingleton;

import org.springframework.stereotype.Service;

import com.szkhb.accenture.reboarding.domain.EntryRequest;
import com.szkhb.accenture.reboarding.service.repository.interceptor.EntryRequestModificationInterceptor;

@Service
public class EntryRequestPassCacher implements EntryRequestModificationInterceptor {

	public int getPositionInQueue(EntryRequest entryRequest) {
		return -1;
	}

}
