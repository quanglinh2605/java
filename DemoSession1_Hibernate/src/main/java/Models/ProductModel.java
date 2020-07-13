package Models;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Product;
import entities.ProductEntity;

public class ProductModel {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Product> findall() {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product").getResultList();
			transaction.commit();
		} catch (Exception e) {
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> condition1(boolean status) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product where status=:status").setParameter("status", status)
					.getResultList();
			transaction.commit();
		} catch (Exception e) {
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> condition2(double min, double max) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product where price >= :min and price <=:max").setParameter("min", min)
					.setParameter("max", max).getResultList();
			transaction.commit();
		} catch (Exception e) {
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> condition3(int cate_id1, int cate_id2) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product where category.id = :cate_id1 or category.id = :cate_id2")
					.setParameter("cate_id1", cate_id1).setParameter("cate_id2", cate_id2).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> condition4(String cate_name) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product where category.name = :cate_name")
					.setParameter("cate_name", cate_name).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> sort1(boolean status) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product where status = :status order by price desc")
					.setParameter("status", status).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> limit1(int n) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product").setMaxResults(n).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> limit2(int n) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product order by price desc").setMaxResults(n).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> limit3(int start, int n) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product order by price desc").setFirstResult(start).setMaxResults(n)
					.getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> FindByYear(int year) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product where year(created) = :year").setParameter("year", year)
					.getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> FindByYear(int year, int month) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product where year(created) = :year and month(created) = :month")
					.setParameter("year", year).setParameter("month", month).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> FindByYear(int year, int month, int day) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery(
					"from Product where year(created) = :year and month(created) = :month and day(created) = :day")
					.setParameter("day", day).setParameter("year", year).setParameter("month", month).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> FindBycurrentDay() {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product where year(created) = year(current_date())").getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> FindByDate(Date created) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product where created = :created")
					.setParameter("created", created, TemporalType.DATE).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public List<Product> FindByDates(Date start, Date end) {
		List<Product> products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			products = session.createQuery("from Product where created >= :start and created <= :end")
					.setParameter("start", start, TemporalType.DATE).setParameter("end", end).getResultList();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

	public Long sum1() {
		Long result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Long) session.createQuery("select sum(quantity) from Product").getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public Long sum2(boolean status) {
		Long result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Long) session.createQuery("select sum(quantity) from Product where status = : status")
					.setParameter("status", status).getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public double sum3(boolean status) {
		Double result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Double) session.createQuery("select sum(quantity*price) from Product where status = : status")
					.setParameter("status", status).getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public Long count1() {
		Long result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Long) session.createQuery("select Count(id) from Product").getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public Double min() {
		Double result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Double) session.createQuery("select min(price) from Product").getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public Double max() {
		Double result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Double) session.createQuery("select max(price) from Product").getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public Double Average() {
		Double result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Double) session.createQuery("select avg(price) from Product").getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public Product find(int id) {
		Product result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Product) session.createQuery("from Product where id = :id").setParameter("id", id)
					.getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public List<ProductEntity> findallEntity() {
		List<ProductEntity> productEntities = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			productEntities = session
					.createQuery("select new entities.ProductEntity(id, name, price, description) from Product")
					.getResultList();
			transaction.commit();
		} catch (Exception e) {
			productEntities = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return productEntities;
	}

	public Product create(Product product) {
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

	public Product Update(Product product) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(product);
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

	public Boolean Delete(Product product) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(product);
			// SQL vs HQL
			// sql: from ProDuct wrong
			// hql: from Product
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
}
