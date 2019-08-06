package com.hibernate.training.mappings.onetoone.pojo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {
	
	private int rollNumber;
	private String name;
	private String area;
	private Student student;
	
	@Id	
	@Column(name="ROLL_NUMBER")
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@OneToOne(targetEntity=Student.class,cascade=CascadeType.ALL)
	@JoinColumn(name="ROLL_NUMBER",referencedColumnName="ROLL_NUMBER")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}	
}
