package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;

@Service
public class CardService {
	@Autowired
	CardRepository cRepository;
	
	public Iterable<Card> getAll() {
		return cRepository.findAll();
	}

	public void createCard(Card card) {
		cRepository.save(card);
	}
	
	public Card getCard(Integer id) {
		Optional<Card> card = cRepository.findById(id);
		return card.orElse(null);
	}

	public void updateCard(Card card) {
		cRepository.save(card);
	}

	public void deleteCard(Integer id) {
		cRepository.deleteById(id);
	}
}
