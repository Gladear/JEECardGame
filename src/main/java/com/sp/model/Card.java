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
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User owner;
}
