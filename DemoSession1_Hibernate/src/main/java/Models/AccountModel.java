package Models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

import entities.Account;

public class AccountModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Account> findAll() {
		List<Account> lsAcc = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			lsAcc = session.createQuery("from Account").getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			lsAcc = null;
			if (transaction != null) {
				transaction.rollback();
			}
			// TODO: handle exception
		} finally {
			session.close();
		}
		return lsAcc;
	}

	public List<Account> find(String gender) {
		List<Account> lsAcc = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			lsAcc = session.createQuery("from Account where gender = :gender").setParameter("gender", gender)
					.getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			lsAcc = null;
			if (transaction != null) {
				transaction.rollback();
			}
			// TODO: handle exception
		} finally {
			session.close();
		}
		return lsAcc;
	}

	public List<Account> findcusByBirth() {
		List<Account> lsAcc = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			lsAcc = session.createQuery(
					"from Account where month(birthday) = month(current_date()) and day(birthday) = day(current_date())")
					.getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			lsAcc = null;
			if (transaction != null) {
				transaction.rollback();
			}
			// TODO: handle exception
		} finally {
			session.close();
		}
		return lsAcc;
	}

	public List<Account> findcusBydate(int month, int day) {
		List<Account> lsAcc = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			lsAcc = session.createQuery("from Account where month(birthday) = :month and day(birthday) = :day")
					.setParameter("month", month).setParameter("day", day).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			lsAcc = null;
			if (transaction != null) {
				transaction.rollback();
			}
			// TODO: handle exception
		} finally {
			session.close();
		}
		return lsAcc;
	}

	public List<Account> findbyAge(String gender) {
		List<Account> lsAcc = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			lsAcc = session
					.createQuery("from Account where gender = :gender and year(birthday) <= (year(current_date())-30) ")
					.setParameter("gender", gender).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			lsAcc = null;
			if (transaction != null) {
				transaction.rollback();
			}
			// TODO: handle exception
		} finally {
			session.close();
		}
		return lsAcc;
	}

	public Account findByUsername(String username) {
		Account Acc = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Acc = (Account) session.createQuery("from Account where username = :username")
					.setParameter("username", username).getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Acc = null;
			if (transaction != null) {
				transaction.rollback();
			}
			// TODO: handle exception
		} finally {
			session.close();
		}
		return Acc;
	}

	public Account create(Account account) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(account);
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
			transaction.commit();
		} catch (Exception e) {
			account = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return account;
	}

	public Account Login(String Username, String Password) {
		Account account = findByUsername(Username);
		if (account != null) {
			if (BCrypt.checkpw(Password, account.getPassword())) {
				return account;
			}
		}
		return null;
	}
}
