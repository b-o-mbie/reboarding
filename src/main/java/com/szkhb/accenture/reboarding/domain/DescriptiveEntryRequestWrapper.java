package com.szkhb.accenture.reboarding.domain;

import lombok.Data;

@Data
public class DescriptiveEntryRequestWrapper {

	private EntryRequest entryRequest;
	private int position;

}
