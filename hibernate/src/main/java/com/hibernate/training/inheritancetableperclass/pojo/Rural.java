package com.hibernate.training.inheritancetableperclass.pojo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TBLM_RURAL")
@DiscriminatorValue("rural")
public class Rural extends Area{
	
	int totalSchools;
	int population;

	@Column(name="TOTAL_SCHOOLS")
	public int getTotalSchools() {
		return totalSchools;
	}
	public void setTotalSchools(int totalSchools) {
		this.totalSchools = totalSchools;
	}
	@Column(name="TOTAL_POPULATION")
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	} 	
}