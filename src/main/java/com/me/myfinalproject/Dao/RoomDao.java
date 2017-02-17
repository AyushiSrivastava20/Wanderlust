package com.me.myfinalproject.Dao;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.me.myfinalproject.exception.AdUException;
import com.me.myfinalproject.pojo.Customer;
import com.me.myfinalproject.pojo.Room;
import com.me.myfinalproject.pojo.Wishlist;

public class RoomDao extends Dao {
	
	private SessionFactory sessionFactory;
	private Session session;
	

	public void createRoom(Room room) throws AdUException{
		
		try {
			sessionFactory = HibernateDao.getSessionFactory();
			session= sessionFactory.openSession();
            session.beginTransaction();
            
            session.save(room);
            session.getTransaction().commit();
            session.close();

		}
		
		catch (HibernateException e) {
            rollback();
           
            throw new AdUException("Exception while creating room: " + e.getMessage());
        }
		
		
		
	}
	
	public ArrayList<Room> viewlist(int id) throws Exception{
		Transaction tx = null;
		ArrayList<Room> roomList = new ArrayList<Room>();
		
		sessionFactory = HibernateDao.getSessionFactory();
		session= sessionFactory.openSession();
		try {

			tx = session.beginTransaction();
		    Query query = getSession().createQuery("from Room where hostID=:roomid");
		    query.setInteger("roomid", id);
		    roomList = (ArrayList<Room>)query.list();
		    tx.commit();
		    session.close();
		    return roomList;
		    	
		}
		catch(HibernateException e){
			if(tx!=null)
			rollback();
		    throw new Exception("Could not get listing" + e);
	     }
		
		
		
	}
	
	public ArrayList<Room> showprop() throws Exception{
		Transaction tx = null;
		ArrayList<Room> roomList = new ArrayList<Room>();
		
		sessionFactory = HibernateDao.getSessionFactory();
		session= sessionFactory.openSession();
		try {

			tx = session.beginTransaction();
		    Query query = getSession().createQuery("from Room");
		  
		    roomList = (ArrayList<Room>)query.list();
		    tx.commit();
		    session.close();
		    return roomList;
		    	
		}
		catch(HibernateException e){
			if(tx!=null)
			rollback();
		    throw new Exception("Could not get listing" + e);
	     }
		
		
		
	}
	
	public ArrayList<Room> searchrooms(String city, String roomtype, Date begin, Date end) throws Exception{
		Transaction tx = null;
		ArrayList<Room> roomList = new ArrayList<Room>();
		
		sessionFactory = HibernateDao.getSessionFactory();
		session= sessionFactory.openSession();
		try {

			tx = session.beginTransaction();
		    Query query = getSession().createQuery("from Room r where r.roomID not in (Select b.roomID from Booking b where b.begin >=:begin and b.end <=:end) and r.roomtype=:roomtype and r.city=:city");
		    query.setString("city", city);
		    query.setString("roomtype",roomtype);
		    query.setDate("begin", begin);
		    query.setDate("end", end);
		    roomList = (ArrayList<Room>)query.list();
		    tx.commit();
		    session.close();
		    return roomList;
		    	
		}
		catch(HibernateException e){
			if(tx!=null)
			rollback();
		    throw new Exception("Could not get listing" + e);
	     }
		
		
		
	}
	
	public Room findRoom(Integer roomId) throws Exception{
	
		Transaction tx = null;
		Room r1 = new Room();
		sessionFactory = HibernateDao.getSessionFactory();
		session= sessionFactory.openSession();
		
		try {

			tx = session.beginTransaction();
		    Query query = getSession().createQuery("from Room where roomID=:roomID");
		    query.setInteger("roomID", roomId);
		    
		    r1 = (Room)query.uniqueResult();
		    tx.commit();
		    session.close();
		    return r1;
		    	
		}
		catch(HibernateException e){
			if(tx!=null)
			rollback();
		    throw new Exception("Could not get listing");
	     }
		
	
		
	}
	

public void saveWishList(Wishlist w) throws AdUException{
	
	
	try {
		sessionFactory = HibernateDao.getSessionFactory();
		session= sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(w);
        session.getTransaction().commit();
        session.close();

	}
	
	catch (HibernateException e) {
        rollback();
       
        throw new AdUException("Exception while adding wishlist " + e.getMessage());
    }
	
	
}

public ArrayList<Wishlist> viewwishlist( int id) throws Exception{
	Transaction tx = null;
	ArrayList<Wishlist> wishList = new ArrayList<Wishlist>();
	
	sessionFactory = HibernateDao.getSessionFactory();
	session= sessionFactory.openSession();
	try {

		tx = session.beginTransaction();
	    Query query = getSession().createQuery("from Wishlist where custid=:custid");
	    query.setInteger("custid",id);
	   
	    wishList = (ArrayList<Wishlist>)query.list();
	    tx.commit();
	    session.close();
	    return wishList;
	    	
	}
	catch(HibernateException e){
		if(tx!=null)
		rollback();
	    throw new Exception("Could not get listing" + e);
     }
	
	
	
}
	

	
	

}
