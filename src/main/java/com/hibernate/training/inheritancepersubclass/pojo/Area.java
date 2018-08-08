package com.hibernate.training.inheritancepersubclass.pojo;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "TBLM_AREA")
@Inheritance(strategy= InheritanceType.JOINED)
public class Area{

	private int areaId;
	private String areaName;

	@Column(name="AREA_ID")
	@Id
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	@Column(name="AREA_NAME")
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}	 	
}