package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sp.model.Card;
import com.sp.model.Sale;
import com.sp.model.User;
import com.sp.repository.CardRepository;
import com.sp.repository.SaleRepository;
import com.sp.repository.UserRepository;

@Service
public class SaleService {
	@Autowired
	CardRepository cRepository;

	@Autowired
	SaleRepository sRepository;

	@Autowired
	UserRepository uRepository;

	public void create(Integer userId, Integer cardId, Double price) {
		Card card = cRepository.findById(cardId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		if (!card.getOwner().getId().equals(userId)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		if (price < 0.0) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		Sale sale = new Sale(0, card, price);
		sRepository.save(sale);
	}

	public Iterable<Sale> getAll() {
		return sRepository.findAll();
	}

	public Sale getSale(Integer saleId) {
		return sRepository.findById(saleId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public void buy(Integer userId, Integer saleId) {
		User buyer = uRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		Sale sale = sRepository.findById(saleId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		Card card = sale.getCard();
		if (card.getOwner().getId().equals(userId)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		Double price = sale.getPrice();
		if (buyer.getMoney() < price) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
		}
		User owner = card.getOwner();
		card.setOwner(buyer);
		owner.setMoney(owner.getMoney() + price);
		buyer.setMoney(buyer.getMoney() - price);
		uRepository.save(owner);
		uRepository.save(buyer);
		cRepository.save(card);
		sRepository.delete(sale);
	}

}
