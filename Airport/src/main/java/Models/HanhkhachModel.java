package Models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Hanhkhach;

public class HanhkhachModel {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Hanhkhach> timhanhkhachtheohoten(String hoten) {
		Session session = null;
		Transaction transaction = null;
		List<Hanhkhach> dsHK = new ArrayList<Hanhkhach>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			dsHK = session.createQuery("from Hanhkhach where hoten like :hoten")
					.setParameter("hoten", "%" + hoten + "%").getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			dsHK = null;
			if (transaction != null) {
				transaction.rollback();
			}
			// TODO: handle exception
		} finally {
			session.close();
		}
		return dsHK;
	}

	public Hanhkhach Create(Hanhkhach model) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(model);
			transaction.commit();
		} catch (Exception e) {
			model = null;
			System.err.println(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return model;
	}

	public Hanhkhach Update(Hanhkhach model) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(model);
			transaction.commit();
		} catch (Exception e) {
			model = null;
			System.err.println(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return model;
	}
}
