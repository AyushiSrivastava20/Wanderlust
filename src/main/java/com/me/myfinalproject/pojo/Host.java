package com.me.myfinalproject.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="host")
@PrimaryKeyJoinColumn(name="userID")
public class Host extends User {
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "host")
	private List<Room> Listings;
	
	public Host(){
		Listings = new ArrayList<Room>();
	}

	public List<Room> getListings() {
		return Listings;
	}

	public void setListings(List<Room> listings) {
		Listings = listings;
	}
	
	
	

}
