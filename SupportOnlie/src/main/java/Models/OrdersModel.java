package Models;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Orders;

public class OrdersModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@SuppressWarnings("unchecked")
	public List<Orders> findall() {
		List<Orders> orders = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			orders = session.createQuery("from Orders order by id desc").getResultList();
			transaction.commit();
		} catch (Exception e) {
			orders = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return orders;
	}

	public boolean create(Orders orders) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(orders);
			transaction.commit();
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Orders> findByPriority(String priority) {
		List<Orders> orders = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			orders = session.createQuery("from Orders where priority =: priority").setParameter("priority", priority)
					.getResultList();
			transaction.commit();
		} catch (Exception e) {
			orders = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return orders;
	}

	public Orders find(int id) {
		Orders orders = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			orders = (Orders) session.createQuery("from Orders where id =: id").setParameter("id", id)
					.getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			orders = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return orders;
	}

	public boolean update(Orders orders) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(orders);
			transaction.commit();
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Orders> FindByDates(Date start, Date end) {
		List<Orders> orders = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			orders = session.createQuery("from Orders where created >= :start and created <= :end")
					.setParameter("start", start, TemporalType.DATE).setParameter("end", end, TemporalType.DATE)
					.getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			orders = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return orders;
	}
}
