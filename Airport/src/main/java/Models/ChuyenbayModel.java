package Models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Chuyenbay;

public class ChuyenbayModel {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Chuyenbay xemchuyenbay(String tencb) {
		Session session = null;
		Transaction transaction = null;
		Chuyenbay item = new Chuyenbay();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			item = (Chuyenbay) session.createQuery("from Chuyenbay where tencb = :tencb").setParameter("tencb", tencb)
					.getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			System.err.print(e.getMessage());
			item = null;
			if (transaction != null) {
				transaction.rollback();
			}
			// TODO: handle exception
		} finally {
			session.close();
		}
		return item;
	}

	public List<Chuyenbay> xemchuyenbaytheongay(int ngay, int thang, int nam) {
		Session session = null;
		Transaction transaction = null;
		List<Chuyenbay> item = new ArrayList<Chuyenbay>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			item = session
					.createQuery(
							"from Chuyenbay where year(ngaydi) = :nam and month(ngaydi) = :thang and day(ngaydi)=:ngay")
					.setParameter("ngay", ngay).setParameter("thang", thang).setParameter("nam", nam).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.print(e.getMessage());
			item = null;
			if (transaction != null) {
				transaction.rollback();
			}
			// TODO: handle exception
		} finally {
			session.close();
		}
		return item;
	}

	public Chuyenbay Create(Chuyenbay model) {
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
}
