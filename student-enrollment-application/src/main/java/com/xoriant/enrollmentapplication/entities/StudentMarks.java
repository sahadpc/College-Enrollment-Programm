package com.xoriant.enrollmentapplication.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity(name = "studentmarks")
public class StudentMarks {
	
	@Id
	@GeneratedValue
	private int marksId;
	
	@OneToOne(mappedBy = "studentMarks")
	//@JoinColumn(name = "userId"/* ,referencedColumnName = "userId" */)
	private User user;
	
	private double sscMarks;
	
	public int getMarksId() {
		return marksId;
	}
	public void setMarksId(int marksId) {
		this.marksId = marksId;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getSscMarks() {
		return sscMarks;
	}
	public void setSscMarks(double sscMarks) {
		this.sscMarks = sscMarks;
	}
}
