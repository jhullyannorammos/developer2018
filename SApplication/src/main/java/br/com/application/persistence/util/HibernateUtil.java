package br.com.application.persistence.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.ReturningWork;

/**
 *
 * @author Juliano Ramos
 */
public class HibernateUtil {
    
	private static SessionFactory sessionfactory = managerSessionfactory();
    /**
     * @return the sessionfactory
     */
	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory2() throws Exception {
        if(sessionfactory == null){
            Configuration configuration = new AnnotationConfiguration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionfactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionfactory;
    }
	
	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory() throws Exception {
        if(sessionfactory == null){
            Configuration configuration = new Configuration().configure();
            sessionfactory = configuration.buildSessionFactory();
        }
        return sessionfactory;
    }
	
	private static SessionFactory managerSessionfactory() {
		return sessionfactory;
	}
	
	public static Connection getConnection(){
		Session session = managerSessionfactory().openSession();
		
		Connection connection = session.doReturningWork(new ReturningWork<Connection>() {
			@Override
			public Connection execute(Connection conn) throws SQLException {
				return conn;
			}
		});
		
		return connection;
	}
}
