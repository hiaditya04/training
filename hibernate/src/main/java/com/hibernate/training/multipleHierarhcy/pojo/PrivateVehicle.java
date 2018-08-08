package com.hibernate.training.multipleHierarhcy.pojo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PrivateVehicle extends Vehicle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String licenseType;

	
	@Column(name="LICENSE_TYPE")
	public String getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
}
