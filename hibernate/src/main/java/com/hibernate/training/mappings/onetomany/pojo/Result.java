package com.hibernate.training.mappings.onetomany.pojo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PUPILS_RESULTS_DATA")
public class Result{
	
	private int rollNumber;
	
	
	private int mathsMarks;
	
	
	private int scienceMarks;
	
	
	private int totalMarks;
	
	private Pupil pupil;
	
	@Id	
	@Column(name="ROLL_NUMBER")
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	@Column(name="MATHS_MARKS")
	public int getMathsMarks() {
		return mathsMarks;
	}
	public void setMathsMarks(int mathsMarks) {
		this.mathsMarks = mathsMarks;
	}

	@Column(name="SCIENCE_MARKS")
	public int getScienceMarks() {
		return scienceMarks;
	}
	public void setScienceMarks(int scienceMarks) {
		this.scienceMarks = scienceMarks;
	}
	
	@Column(name="TOTAL_MARKS")
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	
	@OneToOne(targetEntity=Pupil.class,cascade=CascadeType.ALL)	
	@JoinColumn(name="ST_ROLL_NUMBER",referencedColumnName="ST_ROLL_NUMBER")
	public Pupil getPupil() {
		return pupil;
	}
	public void setPupil(Pupil pupil) {
		this.pupil = pupil;
	}	
}
