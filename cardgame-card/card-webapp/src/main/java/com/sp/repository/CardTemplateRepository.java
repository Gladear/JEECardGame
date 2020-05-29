package com.sp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sp.model.CardTemplate;

public interface CardTemplateRepository extends CrudRepository<CardTemplate, Integer> {
	public List<CardTemplate> findByName(String name);
}
