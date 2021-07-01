package br.com.application.infrastructure;

import br.com.application.persistence.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Juliano Ramos
 */
public class PersistenceGeneric<Entity> {
    
    Class<Entity> classes;

	@SuppressWarnings("unchecked")
	public PersistenceGeneric() {
		this.classes = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
	public void save(Entity entity) throws Exception {
            
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;

	    try {
	        transaction = session.beginTransaction();
	        session.save(entity);
	        transaction.commit();
	    } catch (RuntimeException error) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        throw error;
	    } finally {
		  session.close();
	    }
	}

	@SuppressWarnings("unchecked")
	public List<Entity> findAll() throws Exception {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        Criteria criteria = session.createCriteria(classes);
	        List<Entity> resultado = criteria.list();
	        return resultado;
	    } catch (RuntimeException error) {
	        throw error;
	    } finally {
	        session.close();
	    }
	}
	
	@SuppressWarnings("unchecked")
	public List<Entity> findByOrdenation(String order) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
		    Criteria criteria = session.createCriteria(classes);
		    criteria.addOrder(Order.asc(order));
		    List<Entity> entities = criteria.list();
		    return entities;
		} catch (RuntimeException error) {
		    throw error;
		} finally {
		    session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entity findBy(Long codigo) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
		    Criteria criteria = session.createCriteria(classes);
		    criteria.add(Restrictions.idEq(codigo));
		    Entity entity = (Entity) criteria.uniqueResult();
		    return entity;
		} catch (RuntimeException error) {
		    throw error;
		} finally {
		    session.close();
		}
	}
	
	public void delete(Entity entity) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
		    transaction = session.beginTransaction();
		    session.delete(entity);
		    transaction.commit();
		} catch (RuntimeException error) {
		    if (transaction != null) {
		  	transaction.rollback();
		    }
		    throw error;
		} finally {
			session.close();
		}
	}
	
	public void update(Entity entity) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
		    transaction = session.beginTransaction();
		    session.update(entity);
		    transaction.commit();
		} catch (RuntimeException error) {
		    if (transaction != null) {
			transaction.rollback();
		    }
		    throw error;
		} finally {
		    session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entity merge(Entity entity) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
		    transaction = session.beginTransaction();
		    Entity retorno = (Entity) session.merge(entity);
		    transaction.commit();
		    return retorno;
		} catch (RuntimeException error) {
		    if (transaction != null) {
			transaction.rollback();
		    }
		    throw error;
		} finally {
			session.close();
		}
	}
    
}
