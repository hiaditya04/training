package com.hibernate.training.mappings.onetomany.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SUBJECT")
public class Subject {


  private int id=0;


  private String name;

    private List<Student> students;

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

  @OneToMany(fetch= FetchType.LAZY, targetEntity=Student.class, cascade= CascadeType.ALL)
  @JoinColumn(name="SUBJECT_ID",referencedColumnName="ID")
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
