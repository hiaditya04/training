package com.hibernate.training.mappings.manytoone.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SUBJECT")
public class Subject {


  private int id=0;


  private String name;

  /*	@OneToMany(fetch=FetchType.LAZY, targetEntity=Children.class, cascade=CascadeType.ALL)
    @JoinColumn(name="PARENT_ID",referencedColumnName="PARENT_ID")
    private Set children;
  */

  @Id
  @GeneratedValue(strategy=IDENTITY)
  @Column(name="ID")
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  @Column(name="NAME")
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
