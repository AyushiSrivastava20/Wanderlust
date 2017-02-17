package com.me.myfinalproject.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.me.myfinalproject.pojo.Comments;


public class CommentDao extends Dao {
	
	private SessionFactory sessionFactory;
	private Session session;
	

	public void addComment(Comments comment){
		
		try {
			sessionFactory = HibernateDao.getSessionFactory();
			session= sessionFactory.openSession();
            session.beginTransaction();
            
            session.save(comment);
            session.getTransaction().commit();
            session.close();

		}
		
		catch (HibernateException e) {
            rollback();
           
            
        }
		
		
		
	}

}
