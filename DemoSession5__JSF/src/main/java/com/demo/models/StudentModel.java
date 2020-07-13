package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

import com.demo.entities.Student;

public class StudentModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public List<Student> findAll(){
		Session session = null;
		Transaction transaction = null;
		List<Student> Students = new ArrayList<Student>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Students = session.createQuery("from Student").getResultList();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				Students = null;
			}
		}
		finally {
			session.close();
		}
		return Students;
	}

	public List<Student> search(String keyword){
		Session session = null;
		Transaction transaction = null;
		List<Student> Students = new ArrayList<Student>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Students = session.createQuery("from Student where fullname like :keyword").setParameter("keyword", "%"+keyword+"%").getResultList();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				Students = null;
			}
		}
		finally {
			session.close();
		}
		return Students;
	}
	
	public boolean create(Student Student){
		Session session = null;
		Transaction transaction = null;
		boolean result = true;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(Student);
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
	
	public boolean delete(Student Student){
		Session session = null;
		Transaction transaction = null;
		boolean result = true;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(Student);
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
	
	public boolean update(Student Student){
		Session session = null;
		Transaction transaction = null;
		boolean result = true;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(Student);
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
	
	public Student getbyid(int id){
		Session session = null;
		Transaction transaction = null;
		Student Students = new Student();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Students = (Student) session.createQuery("from Student where id = :id").setParameter("id", id).getSingleResult();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				Students = null;
			}
		}
		finally {
			session.close();
		}
		return Students;
	}
	
	public Student getbyUsername(String username){
		Session session = null;
		Transaction transaction = null;
		Student Students = new Student();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Students = (Student) session.createQuery("from Student where username = :username").setParameter("username", username).getSingleResult();
			transaction.commit();
		} catch (Exception e) {			
			if(transaction != null) {
				transaction.rollback();
				Students = null;
			}
		}
		finally {
			session.close();
		}
		return Students;
	}
	
	public boolean login(String password, String username){
		Student Student = new Student();
		Student = getbyUsername(username);
		if(Student!=null && Student.isStatus()) {
			if(BCrypt.checkpw(password, Student.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
