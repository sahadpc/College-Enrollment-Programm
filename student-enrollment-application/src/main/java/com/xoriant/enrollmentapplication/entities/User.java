package com.xoriant.enrollmentapplication.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity(name = "user")
public class User {

	@Id
	@GeneratedValue
	private int userId;
	@NotNull
	@NotEmpty
	private String firstName;
	@NotNull
	@NotEmpty
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
	
	@ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_college",
		joinColumns = {
				@JoinColumn(name = "userId", referencedColumnName = "userId")
		},
		inverseJoinColumns = {
				@JoinColumn(name = "collegeId", referencedColumnName = "collegeId")
		})
	private List<College> colleges;
}
