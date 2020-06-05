package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.sp.model.Card;
import com.sp.model.Sale;
import com.sp.model.User;
import com.sp.repository.SaleRepository;

@Service
public class SaleService {

	@Autowired
	SaleRepository sRepository;

	public void create(Integer userId, Integer cardId, Double price) {
		
		RestTemplate restTemplate = new RestTemplate();
		Card card= restTemplate.getForObject("http://localhost:8081/"+cardId.toString(), Card.class);		 
		if (!card.getOwnerId().equals(userId)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		if (price < 0.0) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		Sale sale = new Sale(0, card.getId(), price);
		sRepository.save(sale);
	}

	public Iterable<Sale> getAll() {
		return sRepository.findAll();
	}

	public Sale getSale(Integer saleId) {
		return sRepository.findById(saleId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public void buy(Integer buyerId, Integer saleId) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		User buyer = restTemplate.getForObject("http://localhost:8080/"+buyerId, User.class);
		Sale sale = sRepository.findById(saleId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		Card card = restTemplate.getForObject("http://localhost:8081/"+sale.getCardId(), Card.class); 
		User owner = restTemplate.getForObject("http://localhost:8080/"+card.getOwnerId(), User.class);
		if (card.getOwnerId().equals(buyerId)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		Double price = sale.getPrice();
		if (buyer.getMoney() < price) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
		}
		buyer.setMoney(buyer.getMoney() - price);
		owner.setMoney(owner.getMoney() + price);
		card.setOwnerId(buyerId);

		restTemplate.postForObject("http://localhost:8081/", new HttpEntity<>(card), Card.class);
		restTemplate.postForObject("http://localhost:8080/", new HttpEntity<>(buyer), User.class);
		restTemplate.postForObject("http://localhost:8080/", new HttpEntity<>(owner), User.class);
		sRepository.delete(sale);
	}

}
