package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entities.Order;

public class OrderModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public List<Order> findAll(){
		Session session = null;
		Transaction transaction = null;
		List<Order> Orders = new ArrayList<Order>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Orders = session.createQuery("from Order").getResultList();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				Orders = null;
			}
		}
		finally {
			session.close();
		}
		return Orders;
	}
	public boolean create(Order Order){
		Session session = null;
		Transaction transaction = null;
		boolean result = true;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(Order);
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				result = false;
			}
		}
		finally {
			session.close();
		}
		return result;
	}
	public boolean update(Order Order){
		Session session = null;
		Transaction transaction = null;
		boolean result = true;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(Order);
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				result = false;
			}
		}
		finally {
			session.close();
		}
		return result;
	}
	public boolean delete(Order Order){
		Session session = null;
		Transaction transaction = null;
		boolean result = true;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(Order);
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				result = false;
			}
		}
		finally {
			session.close();
		}
		return result;
	}
	public List<Order> getbyCusId(int id){
		Session session = null;
		Transaction transaction = null;
		List<Order> Orders = new ArrayList<Order>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Orders = session.createQuery("from Order where customerId = :id").setParameter("id", id).getResultList();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				Orders = null;
			}
		}
		finally {
			session.close();
		}
		return Orders;
	}
}
