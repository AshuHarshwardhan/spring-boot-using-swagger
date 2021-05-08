package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated product ID")
	private long id;
	
	@ApiModelProperty(notes = "The first name of the user")
	@Size(min=4, message="First Name should have atleast 4 characters")
	@Column(name = "firstName")
	private String firstName;
	
	@ApiModelProperty(notes = "The last name of the user")
	@Size(min=4, message="First Name should have atleast 4 characters")
	@Column(name = "lastName")
	private String lastName;
	
	@ApiModelProperty(notes = "The username of the user")
	@Column(name = "userName")
	private String userName;
	
	@ApiModelProperty(notes = "The age of the user")
	@Column(name = "age")
	private int age;
	
	@ApiModelProperty(notes = "The email of the user")
	@Column(name = "email")
	private String email;
	
	@ApiModelProperty(notes = "Is the user married")
	@Column(name = "married")
	private boolean isMarried;

	public User() {
	}

	public User(String firstName, String lastName, String userName, int age, String email, boolean isMarried) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.age = age;
		this.email = email;
		this.isMarried = isMarried;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", age=" + age + ", email=" + email + ", isMarried=" + isMarried + "]";
	}
}