package com.sp.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
public class CardTemplateTest {

	@Test
	public void createCardTemplate() {
		CardTemplate cardTemplate = new CardTemplate(1, "Card", "Very short description", "Family", 100, 100, 100, 100,
				"url");
		assertTrue(cardTemplate.getId() == 1);
		assertTrue(cardTemplate.getName() == "Card");
		assertTrue(cardTemplate.getDescription() == "Very short description");
		assertTrue(cardTemplate.getFamily() == "Family");
		assertTrue(cardTemplate.getHp() == 100);
		assertTrue(cardTemplate.getEnergy() == 100);
		assertTrue(cardTemplate.getAttack() == 100);
		assertTrue(cardTemplate.getDefense() == 100);
		assertTrue(cardTemplate.getImgUrl() == "url");
	}
}
