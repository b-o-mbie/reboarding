package com.szkhb.accenture.reboarding.service.commons.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

@Service
public class ObjectToJSONConverterService {

  @Autowired
  ObjectWriter writer;

  public <T> String convert(T entryRequest) {
    String json = null;
    try {
      json = writer.writeValueAsString(entryRequest);
    } catch (JsonProcessingException e) {
      json = e.getMessage();
    }
    return json;
  }
}
