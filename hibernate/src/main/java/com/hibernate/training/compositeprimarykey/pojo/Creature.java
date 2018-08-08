package com.hibernate.training.compositeprimarykey.pojo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name="TBLM_CREATURE")
@Entity
public class Creature implements Serializable{

	private CreatureId creatureId;
	private String color;

	@EmbeddedId
	public CreatureId getCreatureId() {
		return creatureId;
	}

	public void setCreatureId(CreatureId creatureId) {
		this.creatureId = creatureId;
	}

	@Column(name="COLOR")
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	 
}