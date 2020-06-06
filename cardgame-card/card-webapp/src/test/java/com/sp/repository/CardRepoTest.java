package com.sp.repository;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sp.model.Card;
import com.sp.model.CardTemplate;
import com.sp.repository.CardRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CardRepoTest {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Test
	public void findCard() {
		Optional<Card> optCard = cardRepository.findById(1);
		assertTrue(optCard.isPresent());
		assertTrue(optCard.get().getId().equals(1));
	}
	@Test
	public void createCard() {
		CardTemplate cardTemplate = new CardTemplate(1, "Card", "Very short description", "Family", 100, 100, 100, 100, "url");
		Card cardTest = new Card(1, cardTemplate, 1);
		cardRepository.save(cardTest);
		Optional<Card> optCard = cardRepository.findById(1);
		assertTrue(optCard.isPresent());
		assertTrue(optCard.get().getId().equals(1));
		assertTrue(optCard.get().getOwnerId().equals(1));
		assertTrue(optCard.get().getTemplate().getId().equals(1));		
	}
	
	@Test
	public void updateCard() {
		CardTemplate cardTemplate = new CardTemplate(1, "Card", "Very short description", "Family", 100, 100, 100, 100, "url");
		Card cardTest = new Card(1, cardTemplate, 1);
		cardRepository.save(cardTest);		
		cardTest.setOwnerId(2);
		cardRepository.save(cardTest);
		Optional<Card> optCard = cardRepository.findById(1);
		assertTrue(optCard.isPresent());
		assertTrue(optCard.get().getId().equals(1));
		assertTrue(optCard.get().getOwnerId().equals(2));
		assertTrue(optCard.get().getTemplate().getId().equals(1));	
	}
	
	@Test
	public void deleteCard() {
		CardTemplate cardTemplate = new CardTemplate(1, "Card", "Very short description", "Family", 100, 100, 100, 100, "url");
		Card cardTest = new Card(1, cardTemplate, 1);
		cardRepository.save(cardTest);
		Optional<Card> optCard = cardRepository.findById(1);
		assertTrue(optCard.isPresent());
		cardRepository.deleteById(1);
		optCard = cardRepository.findById(1);
		assertTrue(!optCard.isPresent());		
	}
}
