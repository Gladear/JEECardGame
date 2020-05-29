package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.CardTemplate;
import com.sp.repository.CardTemplateRepository;

@Service
public class CardTemplateService {
	@Autowired
	CardTemplateRepository cRepository;

	public Iterable<CardTemplate> getAll() {
		return cRepository.findAll();
	}
	
	public void createCardTemplate(CardTemplate card) {
		cRepository.save(card);
	}

	public CardTemplate getCardTemplate(Integer id) {
		Optional<CardTemplate> card = cRepository.findById(id);
		return card.orElse(null);
	}

	public void updateCardTemplate(CardTemplate card) {
		cRepository.save(card);
	}

	public void deleteCardTemplate(Integer id) {
		cRepository.deleteById(id);
	}
}
