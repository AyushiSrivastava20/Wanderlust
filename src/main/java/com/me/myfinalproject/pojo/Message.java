package com.me.myfinalproject.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date date;
	private String message;
	
	private int roomid;
	
	private String sendername;
	
	private String recname;
	
	
	@OneToOne
	private Message reply;

	
	@ManyToOne
	@JoinColumn(name="userID", nullable=false)
	private User user;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getRoomid() {
		return roomid;
	}


	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}


	public String getSendername() {
		return sendername;
	}


	public void setSendername(String sendername) {
		this.sendername = sendername;
	}


	public String getRecname() {
		return recname;
	}


	public void setRecname(String recname) {
		this.recname = recname;
	}


	public Message getReply() {
		return reply;
	}


	public void setReply(Message reply) {
		this.reply = reply;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
