package com.sp.service;

import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sp.model.Card;

@Service
public class CardRemoteService {
	private static final String SERVICE_URL = "http://localhost:8081/";

	private final RestTemplate restTemplate = new RestTemplate();

	public Optional<Card> findById(Integer cardID) {
		try {
			Card card = restTemplate.getForObject(SERVICE_URL + cardID, Card.class);
			return Optional.of(card);
		} catch (RestClientException ex) {
			return Optional.empty();
		}
	}

	public void update(Card card) {
		HttpEntity<Card> entity = new HttpEntity<>(card);
		restTemplate.postForObject(SERVICE_URL, entity, Card.class);
	}
}
