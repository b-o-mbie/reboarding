package com.szkhb.accenture.reboarding.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EntryRequest {
	private int id;
	private LocalDateTime creationTimestamp;
	private boolean isAllowedToEnter;
	private boolean isEntered;
}
