package com.szkhb.accenture.reboarding.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class EntryRequest {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    @ManyToOne
    private User user;
    private LocalDateTime creationTimestamp = LocalDateTime.now();
    private boolean isAllowedToEnter = false;
    private boolean isEntered = false;
}
