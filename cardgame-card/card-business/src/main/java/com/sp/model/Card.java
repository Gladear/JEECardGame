package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Card {
	@GeneratedValue
	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "card_template_id")
	private CardTemplate template;

	private Integer ownerId;

	public Card() {
	}

	public Card(Integer id, CardTemplate template, Integer ownerId) {
		super();
		this.id = id;
		this.template = template;
		this.ownerId = ownerId;
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

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}


}
