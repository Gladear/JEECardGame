package com.sp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Sale {
	@GeneratedValue
	@Id
	private Integer id;

	@OneToOne()
	@JoinColumn(name = "card_id", unique = true)
	private Card card;

	@Column(nullable = false)
	private Double price;

	public Sale() {
		super();
	}

	public Sale(Integer id, Card card, Double price) {
		super();
		this.id = id;
		this.card = card;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
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
