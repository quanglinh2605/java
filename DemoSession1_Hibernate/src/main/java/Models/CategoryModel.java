package Models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Category;

public class CategoryModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Category> findAll() {
		List<Category> categories = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			categories = session.createQuery("from Category").getResultList();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			categories = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return categories;
	}

	public Category create(Category category) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(category);
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			category = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return category;
	}
}
