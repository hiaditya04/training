package com.hibernate.training.multipleHierarhcy.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TBLM_CAR")
public class Car extends PrivateVehicle {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String makeYear;
	private String brand;
	private String typeOfWheelDrive;
	
	
	@Column(name="MAKE_YEAR")
	public String getMakeYear() {
		return makeYear;
	}
	public void setMakeYear(String makeYear) {
		this.makeYear = makeYear;
	}
	@Column(name="BRAND")
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Column(name="TYPE_OF_WHEEL_DRIVE")
	public String getTypeOfWheelDrive() {
		return typeOfWheelDrive;
	}
	public void setTypeOfWheelDrive(String typeOfWheelDrive) {
		this.typeOfWheelDrive = typeOfWheelDrive;
	}
	

}
