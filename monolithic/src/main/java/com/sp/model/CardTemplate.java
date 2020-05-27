package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "CardTemplate")
public class CardTemplate {
	@GeneratedValue
	@Id
	private Integer id;
	private String name;
	private String description;
	private String family;
	private int hp;
	private int energy;
	private int attack;
	private int defense;
	private String imgUrl;

	public CardTemplate() {
	}

	public CardTemplate(Integer id, String name, String description, String family, int hp, int energy, int attack,
			int defense, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.family = family;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defense = defense;
		this.imgUrl = imgUrl;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
