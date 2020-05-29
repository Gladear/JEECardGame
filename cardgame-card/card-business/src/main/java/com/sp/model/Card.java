package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Card {
	@GeneratedValue
	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "card_template_id")
	private CardTemplate template;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User owner;

	@OneToOne(mappedBy = "card")
	private Sale sale;

	public Card() {
	}

	public Card(Integer id, CardTemplate template, User owner, Sale sale) {
		super();
		this.id = id;
		this.template = template;
		this.owner = owner;
		this.sale = sale;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CardTemplate getTemplate() {
		return template;
	}

	public void setTemplate(CardTemplate template) {
		this.template = template;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public boolean isOnSale() {
		return this.sale != null;
	}

}
