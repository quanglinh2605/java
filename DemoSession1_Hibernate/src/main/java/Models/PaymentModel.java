package Models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.InvoiceDetail;

public class PaymentModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Double totalPrice(int id) {
		Double result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Double) session
					.createQuery("select sum(price*quantity) from InvoiceDetail where invoice.id = :id")
					.setParameter("id", id).getSingleResult();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public Double totalPriceOfaCus(int id, int year) {
		Double result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Double) session.createQuery(
					"select sum(price*quantity) from InvoiceDetail where invoice.account.id = :id and year(invoice.created) = :year")
					.setParameter("id", id).setParameter("year", year).getSingleResult();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public Long countInvoice(int month, int year) {
		Long result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Long) session
					.createQuery(
							"select Count(id) from Invoice where month(created) = :month and year(created) = :year")
					.setParameter("month", month).setParameter("year", year).getSingleResult();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public Double totalPrice(String payment) {
		Double result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Double) session
					.createQuery("select sum(price*quantity) from InvoiceDetail where invoice.payment = :payment")
					.setParameter("payment", payment).getSingleResult();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public InvoiceDetail create(InvoiceDetail product) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(product);
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			product = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return product;
	}
}
