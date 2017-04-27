package com.hibernateTest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="STUDENTDETAILS")
public class StudentDetail {
	
	@Id @GeneratedValue(generator="newGenerator")
	@GenericGenerator(name="newGenerator", strategy="foreign", parameters={@Parameter(value="student", name="property")})
	private int roll_No;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="roll_No")
	private Student_Info student;
	
	public Student_Info getStudent() {
		return student;
	}

	public void setStudent(Student_Info student) {
		this.student = student;
	}

	private String student_mobile_number;

	public int getStudent_id() {
		return roll_No;
	}

	public void setStudent_id(int roll_No) {
		this.roll_No = roll_No;
	}

	public String getStudent_mobile_number() {
		return student_mobile_number;
	}

	public void setStudent_mobile_number(String student_mobile_number) {
		this.student_mobile_number = student_mobile_number;
	}

}
