package com.sp.repository;

import org.springframework.data.repository.CrudRepository;

import com.sp.model.Card;

public interface CardRepository extends CrudRepository<Card, Integer> {

	Iterable<Card> findAllByOwnerId(Integer id);
}
