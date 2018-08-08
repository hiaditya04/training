package com.hibernate.training.inheritancetableperconcreteclass.pojo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TBLM_URBAN")
@DiscriminatorValue("URBAN")
public class Urban extends Area {
		
	int totalColleges;
	int population;

	@Column(name="TOTAL_COLLEGE")
	public int getTotalColleges() {
		return totalColleges;
	}
	public void setTotalColleges(int totalColleges) {
		this.totalColleges = totalColleges;
	}

	@Column(name="TOTAL_POPULATION")
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}	
}