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
@Table(name="USERS_DATA")
public class User {
	
	@Id
	@GeneratedValue	
	@Column(name="USER_ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	//@ManyToMany(targetEntity=MobilePhone.class,mappedBy="users")
	@ManyToMany(targetEntity=MobilePhone.class,cascade=CascadeType.ALL)
	@JoinTable(name="MOBILE_PHONES_AND_USERS_REL",joinColumns=@JoinColumn(name="MOBILE_USER_ID",referencedColumnName="USER_ID"),inverseJoinColumns=@JoinColumn(name="MOBILE_PHONE_ID",referencedColumnName="PHONE_ID"))		
	private Set mobilePhones;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set getMobilePhones() {
		return mobilePhones;
	}
	public void setMobilePhones(Set mobilePhones) {
		this.mobilePhones = mobilePhones;
	}		
}
