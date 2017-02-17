package com.me.myfinalproject.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="user")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userID;

	@NotEmpty(message = "Please enter your firstname.")
	@Column(name="firstname")
    private String firstname;
	
	@NotEmpty(message = "Please enter your lastname.")
	@Column(name="lastname")
    private String lastname;
	
	@NotEmpty(message = "Please enter your password.")
	@Size(min = 6, max = 20, message = "Your password must between 6 and 20 characters")
	@Column(name="password")
    private String password;
	
	
	@NotEmpty(message = "Please enter your email.")
	@Column(name="email")
    private String email;
	
	@Column(name="phone")
    private String phone;
	
	@Column(name="age")
	private int age;
	
	@NotEmpty(message = "Please enter your username.")
	@Column(name="username")
	private String username;
	
	@Column(name="role")
    private String role;
	
	
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	@Column(name="userstatus")
	private String userStatus;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
    private List<Comments> comments;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
    private List<Message> messages;
	

	public User(){
		comments = new ArrayList<Comments>();
		messages = new ArrayList<Message>();
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}


	
	
	

}
