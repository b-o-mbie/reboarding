package com.szkhb.accenture.reboarding.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.szkhb.accenture.reboarding.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Override
	Optional<User> findById(Integer id);
}
