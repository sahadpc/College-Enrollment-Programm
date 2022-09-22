package com.xoriant.enrollmentapplication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "studentmarks")
public class StudentMarks {
	
	@Id
	@GeneratedValue
	private int marksId;
	@OneToOne(mappedBy = "studentmarks")/* (cascade = CascadeType.ALL,fetch = FetchType.EAGER) */
	@JoinColumn(name="userId",referencedColumnName = "userId")
	private User userId;
	
	private double sscMarks;
	
	public int getMarksId() {
		return marksId;
	}
	public void setMarksId(int marksId) {
		this.marksId = marksId;
	}

	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public double getSscMarks() {
		return sscMarks;
	}
	public void setSscMarks(double sscMarks) {
		this.sscMarks = sscMarks;
	}
}
