package com.hibernate.training.mappings.onetoone.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="com.hibernate.training.mappings.onetoone.pojo.Student")
@Table(name = "STUDENT")
public class Student {

	private int rollNumber;

	private String name;

	private Address address;

	@Id
	@Column(name = "ROLL_NUMBER")
	//@GeneratedValue
	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ROLL_NUMBER", referencedColumnName = "ROLL_NUMBER")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
