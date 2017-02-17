package com.me.myfinalproject.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="room")
public class Room {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int roomID;
	
	@NotEmpty(message = "Please enter your Name.")
	@Column(name="name")
	private String name;
	
	@NotEmpty(message = "Please enter your Address.")
	@Column(name="address")
    private String address;
	
	@NotEmpty(message = "Please enter your Street.")
	@Column(name="street")
    private String street;
	
	@NotEmpty(message = "Please enter your City.")
	@Column(name="city")
    private String city;
	
	@NotEmpty(message = "Please enter your State.")
	@Column(name="state")
    private String state;
	
	@Column(name="roomtype")
    private String roomtype;
	
	@Column(name="propertytype")
    private String propertytype;
	
	@NotEmpty(message = "Please enter your Aminities.")
	@Column(name="aminities")
    private String aminities;
	
	
	@Column(name="owner")
	private String owner;
	
	@Column(name="rules")
    private String rules;

	@Column(name="status")
	private boolean status;
	
	@Column(name="cost")
	private int cost;
	
	@Column(name="description")
	private String description;
	
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="hostID", nullable=false)
     private Host host;
	

    private String photoName;
    
    @Transient
    private MultipartFile photo;
	 
	@OneToMany(fetch = FetchType.LAZY, mappedBy="room")
    private List<Comments> commentList;
	
	public Room(){
		
		commentList = new ArrayList<Comments>();
		
	}
	
	

	public int getRoomID() {
		return roomID;
	}



	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getPropertytype() {
		return propertytype;
	}

	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}

	public String getAminities() {
		return aminities;
	}

	public void setAminities(String aminities) {
		this.aminities = aminities;
	}

	
    
	
	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

	public int getCost() {
		return cost;
	}



	public void setCost(int cost) {
		this.cost = cost;
	}



	public Host getHost() {
		return host;
	}



	public void setHost(Host host) {
		this.host = host;
	}



	public String getOwner() {
		return owner;
	}



	public void setOwner(String owner) {
		this.owner = owner;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<Comments> getCommentList() {
		return commentList;
	}



	public void setCommentList(List<Comments> commentList) {
		this.commentList = commentList;
	}



	public String getPhotoName() {
		return photoName;
	}



	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}



	public MultipartFile getPhoto() {
		return photo;
	}



	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}


	

}
