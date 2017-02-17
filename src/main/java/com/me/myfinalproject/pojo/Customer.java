	package com.me.myfinalproject.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="customer")
@PrimaryKeyJoinColumn(name="userID")
public class Customer extends User {
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="cust")
	private List<Wishlist> mywishlist;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="customer")
	private List<Booking> bookingHistory;

	public Customer(){
		mywishlist = new ArrayList<Wishlist>();
		bookingHistory = new ArrayList<Booking>();
		
	}
	

	public List<Wishlist> getMywishlist() {
		return mywishlist;
	}


	public void setMywishlist(List<Wishlist> mywishlist) {
		this.mywishlist = mywishlist;
	}


	public List<Booking> getBookingHistory() {
		return bookingHistory;
	}

	public void setBookingHistory(List<Booking> bookingHistory) {
		this.bookingHistory = bookingHistory;
	}

	
	
	
	
	

}