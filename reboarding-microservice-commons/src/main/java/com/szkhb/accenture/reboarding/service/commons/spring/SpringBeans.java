package com.szkhb.accenture.reboarding.service.commons.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

@Configuration
public class SpringBeans {

    private RestTemplate restTemplate = new RestTemplate();

    private ObjectWriter objectWriter;
    private ObjectReader objectReader;

    @Bean
    public RestTemplate restTemplate() {
        return restTemplate;
    }

    @Bean
    public ObjectWriter objecWriter() {
        return objectWriter;
    }

    @Bean
    public ObjectReader objectReader() {
        return objectReader;
    }

    @Autowired
    private void init() {
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
        objectWriter = mapper.writer();
        objectReader = mapper.reader();
    }
}
