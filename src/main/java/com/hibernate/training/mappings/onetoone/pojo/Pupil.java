package com.hibernate.training.mappings.onetoone.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PUPILS_DATA")
public class Pupil {

	int rollNumber;

	String name;

	String address;

	private Result result;

	@Id
	@Column(name = "ST_ROLL_NUMBER")
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

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToOne(targetEntity = Result.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ST_ROLL_NUMBER", referencedColumnName = "ST_ROLL_NUMBER")
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
}
