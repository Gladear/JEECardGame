package com.sp.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sp.model.Card;
import com.sp.model.CardTemplate;
import com.sp.service.CardService;

@RunWith(SpringRunner.class)
@WebMvcTest(CardCrt.class)
public class CardCrtIntegrationTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private CardService service;

	@Test
	public void givenCards_thenReturnJsonArray() throws Exception {
		CardTemplate template = new CardTemplate();
		template.setId(1);
		template.setAttack(50);
		
		Card inst1 = new Card();
		inst1.setId(1);
		inst1.setTemplate(template);
		inst1.setOwnerId(1);
		
		Card inst2 = new Card();
		inst2.setId(2);
		inst2.setTemplate(template);
		inst2.setOwnerId(2);
		
		List<Card> allCards = Lists.list(inst1, inst2);
		
		given(service.getAll()).willReturn(allCards);
		
		mvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].id", is(inst1.getId())))
			.andExpect(jsonPath("$[0].template.id", is(template.getId())))
			.andExpect(jsonPath("$[1].id", is(inst2.getId())))
			.andExpect(jsonPath("$[1].template.id", is(template.getId())));
	}
	
	@Test
	public void givenCard_thenReturnJsonObject() throws Exception {
		CardTemplate template = new CardTemplate();
		template.setId(1);
		template.setAttack(50);

		Integer cardId = 1;
		
		Card card = new Card();
		card.setId(cardId);
		card.setTemplate(template);
		card.setOwnerId(1);
		
		given(service.getCard(cardId)).willReturn(card);
		
		mvc.perform(get("/" + cardId))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(card.getId())))
			.andExpect(jsonPath("$.ownerId", is(card.getOwnerId())))
			.andExpect(jsonPath("$.template.id", is(card.getTemplate().getId())))
			.andExpect(jsonPath("$.template.attack", is(card.getTemplate().getAttack())))
			.andExpect(jsonPath("$.password").doesNotExist());
	}
}
