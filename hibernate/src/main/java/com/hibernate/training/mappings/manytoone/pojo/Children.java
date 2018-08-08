package com.hibernate.training.mappings.manytoone.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Author : RAJ
 */
@Entity
@Table(name="CHILDREN_DATA")
public class Children {
	
	@Id
	@GeneratedValue
	@Column(name="CHILD_ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AGE")
	private int age;
	
	@ManyToOne(targetEntity=Parent.class,cascade=CascadeType.ALL)
	@JoinColumn(name="PARENT_ID",referencedColumnName="PARENT_ID")	
	private Parent parentObj;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public Parent getParentObj() {
		return parentObj;
	}
	public void setParentObj(Parent parentObj) {
		this.parentObj = parentObj;
	}
	public void setAge(int age) {
		this.age = age;
	}
 
}
