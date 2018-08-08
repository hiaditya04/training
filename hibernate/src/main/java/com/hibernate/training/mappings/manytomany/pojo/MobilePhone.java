package com.hibernate.training.mappings.manytomany.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MOBILE_PHONES_DATA")
public class MobilePhone {
	
	@Id
	@GeneratedValue
	@Column(name="PHONE_ID")
	private int id;
	
	@Column(name="MODEL_NUMBER")
	private int modelNumber;
	
	@Column(name="MODEL_NAME")
	private String name;
	
	@ManyToMany(targetEntity=User.class,cascade=CascadeType.ALL)
	@JoinTable(name="MOBILE_PHONES_AND_USERS_REL",joinColumns=@JoinColumn(name="MOBILE_PHONE_ID",referencedColumnName="PHONE_ID"),inverseJoinColumns=@JoinColumn(name="MOBILE_USER_ID",referencedColumnName="USER_ID"))	
	private Set users;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set getUsers() {
		return users;
	}
	public void setUsers(Set users) {
		this.users = users;
	}		
}
