package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

import com.demo.entities.Mobile;

public class MobileModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public List<Mobile> findAll(){
		Session session = null;
		Transaction transaction = null;
		List<Mobile> Mobiles = new ArrayList<Mobile>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Mobiles = session.createQuery("from Mobile").getResultList();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				Mobiles = null;
			}
		}
		finally {
			session.close();
		}
		return Mobiles;
	}

	public List<Mobile> search(String keyword){
		Session session = null;
		Transaction transaction = null;
		List<Mobile> Mobiles = new ArrayList<Mobile>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Mobiles = session.createQuery("from Mobile where name like :keyword").setParameter("keyword", "%"+keyword+"%").getResultList();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				Mobiles = null;
			}
		}
		finally {
			session.close();
		}
		return Mobiles;
	}
		
	public List<Mobile> search(double min, double max){
		Session session = null;
		Transaction transaction = null;
		List<Mobile> Mobiles = new ArrayList<Mobile>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Mobiles = session.createQuery("from Mobile where price <= :max and price >= :min").setParameter(":min",min).setParameter(":max", max).getResultList();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				Mobiles = null;
			}
		}
		finally {
			session.close();
		}
		return Mobiles;
	}
	
	public Mobile getbyid(int id){
		Session session = null;
		Transaction transaction = null;
		Mobile Mobiles = new Mobile();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Mobiles = (Mobile) session.createQuery("from Mobile where id = :id").setParameter("id", id).getSingleResult();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				Mobiles = null;
			}
		}
		finally {
			session.close();
		}
		return Mobiles;
	}
	
	public Mobile getbyname(String username){
		Session session = null;
		Transaction transaction = null;
		Mobile Mobiles = new Mobile();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Mobiles = (Mobile) session.createQuery("from Mobile where name = :username").setParameter("username", username).getSingleResult();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				Mobiles = null;
			}
		}
		finally {
			session.close();
		}
		return Mobiles;
	}
	
	
}
