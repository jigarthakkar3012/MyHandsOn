package com.hibernateTest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT") 
public class Student_Info {
	@Id 
	@GeneratedValue
	private int roll_No;
	private String studentName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="roll_No")
	private StudentDetail studentDetail;
	
	public StudentDetail getStudentDetail() {
		return studentDetail;
	}

	public void setStudentDetail(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}

	public int getRollNo() {
		return roll_No;
	}

	public void setRollNo(int roll_No) {
		this.roll_No = roll_No;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
