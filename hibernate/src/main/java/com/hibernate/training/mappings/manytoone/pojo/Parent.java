package com.hibernate.training.mappings.manytoone.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PARENTS_DATA")
public class Parent {
	
	@Id	
	@GeneratedValue(strategy=IDENTITY) 
	@Column(name="PARENT_ID")	
	private int id=0;
	
	@Column(name="NAME")
	private String name;
	
/*	@OneToMany(fetch=FetchType.LAZY, targetEntity=Children.class, cascade=CascadeType.ALL)
	@JoinColumn(name="PARENT_ID",referencedColumnName="PARENT_ID")
	private Set children;
*/	
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
/*	public Set getChildren() {
		return children;
	}
	public void setChildren(Set children) {
		this.children = children;
	}	
*/}
