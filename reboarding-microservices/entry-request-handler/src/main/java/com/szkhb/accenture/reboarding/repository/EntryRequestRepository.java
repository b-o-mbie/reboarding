package com.szkhb.accenture.reboarding.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.szkhb.accenture.reboarding.domain.EntryRequest;

@Repository
public interface EntryRequestRepository extends CrudRepository<EntryRequest, Integer> {

	@Override
	Optional<EntryRequest> findById(Integer id);
}
