package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

import com.demo.entities.Account;

public class AccountModels {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public List<Account> findAll(){
		Session session = null;
		Transaction transaction = null;
		List<Account> accounts = new ArrayList<Account>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			accounts = session.createQuery("from Account").getResultList();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				accounts = null;
			}
		}
		finally {
			session.close();
		}
		return accounts;
	}

	public List<Account> search(String keyword){
		Session session = null;
		Transaction transaction = null;
		List<Account> accounts = new ArrayList<Account>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			accounts = session.createQuery("from Account where fullname like :keyword").setParameter("keyword", "%"+keyword+"%").getResultList();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				accounts = null;
			}
		}
		finally {
			session.close();
		}
		return accounts;
	}
	
	public boolean create(Account account){
		Session session = null;
		Transaction transaction = null;
		boolean result = true;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(account);
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
	
	public boolean delete(Account account){
		Session session = null;
		Transaction transaction = null;
		boolean result = true;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(account);
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
	
	public boolean update(Account account){
		Session session = null;
		Transaction transaction = null;
		boolean result = true;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(account);
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				System.err.println(e.getMessage());
				transaction.rollback();
				result = false;
			}
		}
		finally {
			session.close();
		}
		return result;
	}
	
	public Account getbyid(int id){
		Session session = null;
		Transaction transaction = null;
		Account accounts = new Account();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			accounts = (Account) session.createQuery("from Account where id = :id").setParameter("id", id).getSingleResult();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				accounts = null;
			}
		}
		finally {
			session.close();
		}
		return accounts;
	}
	
	public Account getbyUsername(String username){
		Session session = null;
		Transaction transaction = null;
		Account accounts = new Account();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			accounts = (Account) session.createQuery("from Account where username = :username").setParameter("username", username).getSingleResult();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				accounts = null;
			}
		}
		finally {
			session.close();
		}
		return accounts;
	}
	
	public boolean login(String password, String username){
		Account account = new Account();
		account = getbyUsername(username);
		if(account!=null && account.isStatus()) {
			if(BCrypt.checkpw(password, account.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
