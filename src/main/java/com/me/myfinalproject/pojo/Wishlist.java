package com.me.myfinalproject.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="wishlist")
public class Wishlist {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int wishID;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="custid", nullable=false)
    private Customer cust;
	
	@Column(name="roomID")
	private int roomID;
	
	@Column(name="roomname")
	private String roomname;
	
	@Column(name="roomcity")
	private String roomcity;

	public int getWishID() {
		return wishID;
	}

	public void setWishID(int wishID) {
		this.wishID = wishID;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getRoomcity() {
		return roomcity;
	}

	public void setRoomcity(String roomcity) {
		this.roomcity = roomcity;
	}
	
	

}
