package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entities.Customer;

public class CustomerModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public List<Customer> findAll(){
		Session session = null;
		Transaction transaction = null;
		List<Customer> customers = new ArrayList<Customer>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			customers = session.createQuery("from Customer").getResultList();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				customers = null;
			}
		}
		finally {
			session.close();
		}
		return customers;
	}
	public boolean create(Customer customer){
		Session session = null;
		Transaction transaction = null;
		boolean result = true;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(customer);
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
	public boolean update(Customer customer){
		Session session = null;
		Transaction transaction = null;
		boolean result = true;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(customer);
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
}
