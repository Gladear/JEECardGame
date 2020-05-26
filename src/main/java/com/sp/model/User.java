package com.sp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@GeneratedValue
	@Id
	private Integer id;
	private String name;
	private String password;

	@OneToMany(mappedBy = "owner")
	private List<Card> cards;

	public User() {
	}

	public User(Integer id, String name, String password, List<Card> cards) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.cards = cards;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
