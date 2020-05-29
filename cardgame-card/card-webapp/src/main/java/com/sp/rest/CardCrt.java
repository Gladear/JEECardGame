package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Card;
import com.sp.service.CardService;

@RestController
public class CardCrt {
	@Autowired
	CardService cService;

	@RequestMapping(method = RequestMethod.GET, value = "/cards")
	public Iterable<Card> getCards() {
		return cService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cards/user/{id}")
	public Iterable<Card> getUserCards(@PathVariable String id) {
		return cService.getAllForUser(Integer.valueOf(id));
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/card")
	public void addCard(@RequestBody Card card) {
		cService.updateCard(card);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/card/{id}")
	public Card getCard(@PathVariable String id) {
		return cService.getCard(Integer.valueOf(id));
	}

	@RequestMapping(method = RequestMethod.POST, value = "/card")
	public void updateCard(@RequestBody Card card) {
		cService.updateCard(card);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/card/{id}")
	public void deleteCard(@PathVariable String id) {
		cService.deleteCard(Integer.valueOf(id));
	}
	

}
