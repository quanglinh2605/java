package Models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Chitietchuyenbay;

public class ChitietModel {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Chitietchuyenbay> danhsachdiemdung(String tencb) {
		Session session = null;
		Transaction transaction = null;
		List<Chitietchuyenbay> dsdiemdung = new ArrayList<Chitietchuyenbay>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			dsdiemdung = session.createQuery("from Chitietchuyenbay where chuyenbay.tencb = :tencb")
					.setParameter("tencb", tencb).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.print(e.getMessage());
			dsdiemdung = null;
			if (transaction != null) {
				transaction.rollback();
			}
			// TODO: handle exception
		} finally {
			session.close();
		}
		return dsdiemdung;
	}

	public Chitietchuyenbay Create(Chitietchuyenbay model) {
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
