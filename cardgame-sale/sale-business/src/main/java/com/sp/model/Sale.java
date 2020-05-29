package com.sp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sale {
	@GeneratedValue
	@Id
	private Integer id;

	private Integer cardId;

	@Column(nullable = false)
	private Double price;

	public Sale() {
		super();
	}

	public Sale(Integer id, Integer cardId, Double price) {
		super();
		this.id = id;
		this.cardId = cardId;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCard() {
		return cardId;
	}

	public void setCard(Integer cardId) {
		this.cardId = cardId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		if (price < 0.0) {
			throw new RuntimeException("Price can't be negative");
		}
		this.price = price;
	}

}
