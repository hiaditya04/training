package com.hibernate.training.inheritancepersubclass.pojo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TBLM_RURAL")

@PrimaryKeyJoinColumn(name="AREA_ID")
public class Rural extends Area {
	
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