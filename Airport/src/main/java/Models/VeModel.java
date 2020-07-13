package Models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Thongkekhachhang;
import entities.Ve;

public class VeModel {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Ve> dsve() {
		Session session = null;
		Transaction transaction = null;
		List<Ve> dsve = new ArrayList<Ve>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			dsve = session.createQuery("from Ve where Hanhkhach.hoten =:hoten").getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			dsve = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return dsve;
	}

	public List<Ve> dsvecuaHK(String hoten) {
		Session session = null;
		Transaction transaction = null;
		List<Ve> dsve = new ArrayList<Ve>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			dsve = session.createQuery("from Ve where hanhkhach.hoten like :hoten")
					.setParameter("hoten", "%" + hoten + "%").getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			dsve = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return dsve;
	}

	public List<Ve> sovemoinhat(String hoten, int n) {
		Session session = null;
		Transaction transaction = null;
		List<Ve> dsve = new ArrayList<Ve>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			dsve = session.createQuery("from Ve where hanhkhach.hoten =:hoten").setParameter("hoten", hoten)
					.setMaxResults(n).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			dsve = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return dsve;
	}

	public Ve Create(Ve model) {
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

	public long soghe(int loaighe) {
		Session session = null;
		Transaction transaction = null;
		long soghe = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			soghe = (Long) session.createQuery("select Count(loaighe) from Ve where loaighe = :loaighe")
					.setParameter("loaighe", loaighe).getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			soghe = 0;
			System.err.println(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return soghe;
	}

	public long sove(String hoten) {
		Session session = null;
		Transaction transaction = null;
		long sove = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			sove = (Long) session.createQuery("select Count(id) from Ve where hanhkhach.hoten = :hoten ")
					.setParameter("hoten", hoten).getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			sove = 0;
			System.err.println(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return sove;
	}

	public double tongtien(String hoten) {
		Session session = null;
		Transaction transaction = null;
		double tongtien = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			tongtien = (Double) session.createQuery("select Sum(giaghe) from Ve where hanhkhach.hoten = :hoten ")
					.setParameter("hoten", hoten).getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			tongtien = 0;
			System.err.println(e.getMessage());
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return tongtien;
	}

	public List<Thongkekhachhang> dsthongkeve() {
		Session session = null;
		Transaction transaction = null;
		List<Thongkekhachhang> dsthongke = new ArrayList<Thongkekhachhang>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			dsthongke = session.createQuery(
					"select new entities.Thongkekhachhang(hk.hoten, v.size) from Hanhkhach hk JOIN hk.ves v group by hk.mahk ")
					.getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			dsthongke = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return dsthongke;
	}

	public List<Ve> danhsachkhachhangmuatren10ve() {
		Session session = null;
		Transaction transaction = null;
		List<Ve> dsthongke = new ArrayList<Ve>();
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			dsthongke = session.createQuery("from Ve Group By hanhkhach having Count(mahk)>1").getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			dsthongke = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return dsthongke;
	}
}
