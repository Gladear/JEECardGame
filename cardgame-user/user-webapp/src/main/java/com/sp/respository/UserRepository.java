package com.sp.respository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public Optional<User> findByName(String name);
}
