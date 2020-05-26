package com.sp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	@GeneratedValue
	@Id
	private Integer id;

	private String name;

	@JsonIgnore
	private String password;

	private Integer money;

	@JsonBackReference
	@OneToMany(mappedBy = "owner")
	private List<Card> cards;

	public User() {
	}

	public User(Integer id, String name, String password, Integer money, List<Card> cards) {
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

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
