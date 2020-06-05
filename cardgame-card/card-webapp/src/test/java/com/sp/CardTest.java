package com.sp.model;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sp.repository.CardRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CardTest {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Test
	public void createCard() {
		User user = new User(1, "User", "password", 100, new ArrayList<Card>());
		CardTemplate cardTemplate = new CardTemplate(1, "Card", "Very short description", "Family", 100, 100, 100, 100, "url");
		Sale sale = new Sale(1, , 5);
		List <Card> cardList = cardRepository.findById(1);
		assertTrue(cardList.size() == 1);
		assertTrue(cardList.get(0).getId().equals(1));
	}
}
