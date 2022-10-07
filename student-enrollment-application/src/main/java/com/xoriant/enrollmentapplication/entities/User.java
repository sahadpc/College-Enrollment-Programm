package com.xoriant.enrollmentapplication.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD

=======
>>>>>>> 372f855fd7f8a0b45697dc5a441b2833ac574ead
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
=======

=======
>>>>>>> 372f855fd7f8a0b45697dc5a441b2833ac574ead
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
@Entity(name = "user")
public class User {

	@Id
	@GeneratedValue
	private int userId;
	@NotNull
	@NotEmpty
	private String firstName;
	private String middleName;
	@NotNull
	@NotEmpty
	private String lastName;
	@NotNull
	private long mobileNumber;
	@Email
	private String emailId;
	@NotNull
	@NotEmpty
	private String userPassword;

	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "marks_id", referencedColumnName = "marksId")
	private StudentMarks studentMarks;

	@OneToMany (cascade = CascadeType.ALL) 
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private List<Address> address;
	
<<<<<<< HEAD
<<<<<<< HEAD

=======
<<<<<<< HEAD
=======

>>>>>>> 372f855fd7f8a0b45697dc5a441b2833ac574ead
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
=======
=======

>>>>>>> 372f855fd7f8a0b45697dc5a441b2833ac574ead
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public StudentMarks getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(StudentMarks studentMarks) {
		this.studentMarks = studentMarks;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

<<<<<<< HEAD
<<<<<<< HEAD
	
=======
<<<<<<< HEAD
=======
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_course",
			joinColumns = { @JoinColumn(name = "userId")},
			inverseJoinColumns = { @JoinColumn(name = "courseId")}
			)
	private List<Course> courses = new ArrayList<Course>();
=======
	
>>>>>>> 372f855fd7f8a0b45697dc5a441b2833ac574ead
<<<<<<< HEAD
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
=======
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
}
