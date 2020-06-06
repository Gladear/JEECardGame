package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sp.model.Card;
import com.sp.model.Sale;
import com.sp.model.User;
import com.sp.repository.SaleRepository;

@Service
public class SaleService {

	@Autowired
	SaleRepository sRepository;

	@Autowired
	UserRemoteService uService;

	@Autowired
	CardRemoteService cService;

	public void create(Integer userId, Integer cardId, Double price) {
		Card card = cService.findById(cardId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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
		User buyer = uService.findById(buyerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		Sale sale = sRepository.findById(saleId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		Card card = cService.findById(sale.getCardId())
				.orElseThrow(() -> new RuntimeException("Cannot find card associated to sale"));
		User owner = uService.findById(card.getOwnerId())
				.orElseThrow(() -> new RuntimeException("Cannot find owner associated to sale"));
		if (card.getOwnerId().equals(buyerId)) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
		}
		Double price = sale.getPrice();
		if (buyer.getMoney() < price) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);
		}
		card.setOwnerId(buyerId);
		buyer.setMoney(buyer.getMoney() - price);
		owner.setMoney(owner.getMoney() + price);
		cService.update(card);
		uService.update(buyer);
		uService.update(owner);
		sRepository.delete(sale);
	}

}
