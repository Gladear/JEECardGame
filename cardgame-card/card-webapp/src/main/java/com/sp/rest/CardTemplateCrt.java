package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.CardTemplate;
import com.sp.service.CardTemplateService;

@RestController
public class CardTemplateCrt {
	@Autowired
	CardTemplateService cService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/template")
	public Iterable<CardTemplate> getCards() {
		return cService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/template")
	public void addCard(@RequestBody CardTemplate card) {
		cService.updateCardTemplate(card);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/template/{id}")
	public CardTemplate getCard(@PathVariable String id) {
		return cService.getCardTemplate(Integer.valueOf(id));
	}

	@RequestMapping(method = RequestMethod.POST, value = "/template")
	public void updateCard(@RequestBody CardTemplate card) {
		cService.updateCardTemplate(card);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/template/{id}")
	public void deleteCard(@PathVariable String id) {
		cService.deleteCardTemplate(Integer.valueOf(id));
	}
}
