package com.me.myfinalproject.Dao;


import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.me.myfinalproject.pojo.Booking;
import com.me.myfinalproject.pojo.Customer;
import com.me.myfinalproject.pojo.Host;
import com.me.myfinalproject.pojo.Room;
import com.me.myfinalproject.pojo.User;




public class BookingDao extends Dao {

	private SessionFactory sessionFactory;
	private Session session;
	
public void createbooking(Booking booking){
		
		try {
			sessionFactory = HibernateDao.getSessionFactory();
			session= sessionFactory.openSession();
            session.beginTransaction();
            
            session.save(booking);
            session.getTransaction().commit();
            session.close();

		}
		
		catch (HibernateException e) {
            rollback();
          
        }
		
	
}


   
public Room getRoom(int roomID){
	   
	   try{
		  begin();
		  Query query=getSession().createQuery("from Room where roomID=:roomid");
		  query.setInteger("roomid", roomID);
		  Room room=(Room)query.uniqueResult();
		  return room;
	   }
	    catch (HibernateException e) {
            rollback();
          
        }
	return null;
	   
	   
  }
   
  public ArrayList<Booking> showTrips(int id) throws Exception{
	    Transaction tx = null;
		ArrayList<Booking> bookList = new ArrayList<Booking>();
		
		sessionFactory = HibernateDao.getSessionFactory();
		session= sessionFactory.openSession();
		try {

			 tx = session.beginTransaction();
			 Query query = getSession().createQuery("from Booking where user_id=:user_id");
			 query.setInteger("user_id", id);
		    bookList = (ArrayList<Booking>)query.list();
		    tx.commit();
		    session.close();
		    return bookList;
		    	
		}
		catch(HibernateException e){
			if(tx!=null)
			rollback();
		    throw new Exception("Could not get trips");
	     }
		
  }
  
  public User getUser(int id)
          throws Exception {
		try {
			
			sessionFactory = HibernateDao.getSessionFactory();
			session= sessionFactory.openSession();
			
          Query q = getSession().createQuery("from User where userID=:userID");
          q.setInteger("userID", id);
          User user = (User) q.uniqueResult();
          session.close();
          return user;
		} catch (HibernateException e) {
			rollback();
          throw new Exception("Could not get user " + e);
		}
  }
  
  public ArrayList<Booking> showVisits() throws Exception{
	    Transaction tx = null;
		ArrayList<Booking> visits = new ArrayList<Booking>();
		
		sessionFactory = HibernateDao.getSessionFactory();
		session= sessionFactory.openSession();
		try {

			tx = session.beginTransaction();
			Query query = getSession().createQuery("from Booking");
			
		    visits = (ArrayList<Booking>)query.list();
		    tx.commit();
		    session.close();
		    return visits;
		    	
		}
		catch(HibernateException e){
			if(tx!=null)
			rollback();
		    throw new Exception("Could not get trips");
	     }
	    
  }
  
  public ArrayList<Booking> checkBooking(Date begin, Date end) throws Exception{
	  Transaction tx = null;
		ArrayList<Booking> checkL = new ArrayList<Booking>();
		
		sessionFactory = HibernateDao.getSessionFactory();
		session= sessionFactory.openSession();
		try {

			tx = session.beginTransaction();
			Query query = getSession().createQuery("from Booking b where b.begin >=:begin and b.end <=:end");
			query.setDate("begin", begin);
		    query.setDate("end", end);
		    checkL = (ArrayList<Booking>)query.list();
		    tx.commit();
		    session.close();
		    return checkL;
		    	
		}
		catch(HibernateException e){
			if(tx!=null)
			rollback();
		    throw new Exception("Could not get trips");
	     }
	  
  }
  
  
	

}
