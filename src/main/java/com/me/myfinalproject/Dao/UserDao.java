package com.me.myfinalproject.Dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.me.myfinalproject.exception.AdUException;
import com.me.myfinalproject.pojo.Customer;
import com.me.myfinalproject.pojo.Host;
import com.me.myfinalproject.pojo.User;

public class UserDao extends Dao {
	
	private SessionFactory sessionFactory;
	private Session session;
	
	public User querybyNamePassword(String username, String password)
            throws Exception {
		try {
			
			sessionFactory = HibernateDao.getSessionFactory();
			session= sessionFactory.openSession();
			
            Query q = getSession().createQuery("from User where userName = :username and password = :password and userStatus=:status");
            q.setString("username", username);
            q.setString("password", password);
            q.setString("status", "Active");
            User user = (User) q.uniqueResult();
            session.close();
            return user;
		} catch (HibernateException e) {
			rollback();
            throw new Exception("Could not get user " + username, e);
		}
    }
	
	//display all users to admin
	
	public ArrayList<User> allUsers() throws Exception {
		
		Transaction tx = null;
		ArrayList<User> allusers1 = new ArrayList<User>();

		sessionFactory = HibernateDao.getSessionFactory();
		session= sessionFactory.openSession();
		
		try {
			
			tx = session.beginTransaction();
            Query q = getSession().createQuery("from User where role!=:role");
            q.setString("role", "a");
            allusers1 = (ArrayList<User>)q.list();
            tx.commit();
		    session.close();
            return allusers1;
            
		} catch (HibernateException e) {
			if(tx!=null)
		    rollback();
            throw new Exception("Could not get users");
		}
    }
	
	public void createCustomer(Customer customer) throws AdUException{
		
		try {
			sessionFactory = HibernateDao.getSessionFactory();
			session= sessionFactory.openSession();
            session.beginTransaction();
            
            session.save(customer);
            session.getTransaction().commit();
            session.close();

		}
		
		catch (HibernateException e) {
            rollback();
           
            throw new AdUException("Exception while creating user: " + e.getMessage());
        }
		
		
		
	}
	
public void createHost(Host host) throws AdUException{
		
		try {
			sessionFactory = HibernateDao.getSessionFactory();
			session= sessionFactory.openSession();
            session.beginTransaction();
            
            session.save(host);
            session.getTransaction().commit();
            session.close();

		}
		
		catch (HibernateException e) {
            rollback();
           
            throw new AdUException("Exception while creating user: " + e.getMessage());
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
    
    
    public boolean userUnique(String username)
            throws Exception {
		try {
			
			sessionFactory = HibernateDao.getSessionFactory();
			session= sessionFactory.openSession();
			
            Query q = getSession().createQuery("from User where userName = :username");
            q.setString("username", username);

            User user = (User) q.uniqueResult();
            session.close();
            if(user==null)
            	return true;
            else
            	return false;
            			
            			
            
		} catch (HibernateException e) {
			rollback();
            throw new Exception("Could not get user " + username, e);
		}
    }
    

}

