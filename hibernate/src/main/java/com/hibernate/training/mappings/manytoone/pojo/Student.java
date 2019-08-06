package com.hibernate.training.mappings.manytoone.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="com.hibernate.training.mappings.manytoone.pojo.Student")
@Table(name = "STUDENT")
public class Student {



  private int rollNumber;

  private String name;

  private Subject subject;

  @Id
  @Column(name = "ROLL_NUMBER")
  @GeneratedValue
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

  @ManyToOne(targetEntity=Subject.class,cascade = CascadeType.ALL)//CASCADETYPE.ALL
  @JoinColumn(name="SUBJECT_ID",referencedColumnName="ID")
  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }
}
