package com.me.myfinalproject.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Dao {
	
	public Session getSession(){
		return HibernateDao.getSessionFactory().openSession();
	}
	
	
	
	protected Dao() {
	}
	
	protected void begin(){
		getSession().beginTransaction();
	}
	
	protected void commit(){
		getSession().getTransaction().commit();
	}
	
	protected void rollback(){
		try{
			getSession().getTransaction().rollback();
			
		}catch(HibernateException e){
			
			
		}
		try{
			getSession().close();
			
		}catch(HibernateException e){
			
			
		}
	}
	
	public void close(){
		getSession().close();
	}

}
