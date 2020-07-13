package Models;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Invoice;

public class InvoiceModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Invoice> findAll() {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			invoices = session.createQuery("from Invoice").getResultList();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			invoices = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return invoices;
	}

	public List<Invoice> findByPayment(String payment) {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			invoices = session.createQuery("from Invoice where payment = :payment ").setParameter("payment", payment)
					.getResultList();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			invoices = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return invoices;
	}

	public List<Invoice> findByGender(String gender) {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			invoices = session.createQuery("from Invoice where account.gender = :gender ")
					.setParameter("gender", gender).getResultList();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			invoices = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return invoices;
	}

	public List<Invoice> findInvoice(String name, String payment) {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			invoices = session.createQuery("from Invoice where payment = :payment and account.fullname = :name ")
					.setParameter("payment", payment).setParameter("name", name).getResultList();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			invoices = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return invoices;
	}

	public List<Invoice> SearchInvoice(String search) {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			invoices = session.createQuery("from Invoice where account.fullname like :search ")
					.setParameter("search", "%" + search + "%").getResultList();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			invoices = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return invoices;
	}

	public List<Invoice> SearchInvoicebyYearandName(String name, int year) {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			invoices = session.createQuery("from Invoice where account.fullname like :name and year(created) = :year ")
					.setParameter("search", "%" + name + "%").getResultList();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			invoices = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return invoices;
	}

	public List<Invoice> SearchInvoicebyPaymentandDate(String payment, int year, int month) {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			invoices = session.createQuery(
					"from Invoice where payment = :payment and year(created) = :year and month(created) = :month ")
					.setParameter("year", year).setParameter("month", month).setParameter("payment", payment)
					.getResultList();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			invoices = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return invoices;
	}

	public List<Invoice> SearchInvoiceNewinCurrentYear(String fullname, int n) {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			invoices = session.createQuery(
					"from Invoice where account.fullname like :fullname and year(created) = year(current_Date()) order by id")
					.setMaxResults(n).setParameter("fullname", "%" + fullname + "%").getResultList();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			invoices = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return invoices;
	}

	public List<Invoice> SearchInvoiceNewbyPayment(String payment, int n) {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			invoices = session.createQuery(
					"from Invoice where Account.fullname = payment and year(created) = year(current_Date()) order by created")
					.setMaxResults(n).setParameter("payment", payment).getResultList();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			invoices = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return invoices;
	}

	public List<Invoice> SearchInvoicebyTime(String fullname, Date start, Date end) {
		List<Invoice> invoices = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			invoices = session.createQuery(
					"from Invoice where Account.fullname like :fullname and created <= :start and created >= :end")
					.setParameter("fullnamet", fullname).setParameter("start", start).setParameter("end", end)
					.getResultList();
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			invoices = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return invoices;
	}

	public Invoice create(Invoice invoice) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(invoice);
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			invoice = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return invoice;
	}
}
