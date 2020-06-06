package com.sp.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
public class CardTest {

	@Test
	public void createCard() {
		CardTemplate cardTemplate = new CardTemplate(1, "Card", "Very short description", "Family", 100, 100, 100, 100,
				"url");
		Card card = new Card(1, cardTemplate, 1);
		assertTrue(card.getId() == 1);
		assertTrue(card.getOwnerId() == 1);
	}
}
