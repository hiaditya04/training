package com.hibernate.training.basic.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.StringJoiner;

@Entity
@Table(name="TBLM_STUDENT")
public class Student {
    private int rollNumber;
    private String name;
    private String address;

    public Student() {
    }

    public Student(int i, String name, String address) {

        this.rollNumber = i;
        this.name = name;
        this.address = address;
    }

    @Id
    @Column(name = "ROLL_NUMBER")
    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Column(name = "FIRST_NAME")
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

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("rollNumber=" + rollNumber)
                .add("name='" + name + "'")
                .add("address='" + address + "'")
                .toString();
    }
}
