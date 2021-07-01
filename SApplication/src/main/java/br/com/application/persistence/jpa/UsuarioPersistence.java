package br.com.application.persistence.jpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.application.domain.Usuario;
import br.com.application.infrastructure.PersistenceGeneric;
import br.com.application.persistence.util.JDBConnectionUtil;
import br.com.application.persistence.util.HibernateUtil;

public class UsuarioPersistence extends PersistenceGeneric<Usuario> {
	
	Usuario usuario;
	Session session;
	
	@SuppressWarnings("finally")
	public Usuario getUsuario(String logon) throws Exception {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			usuario = (Usuario) session.createQuery("from Usuario where logon = :name").setParameter("logon", logon);
		} catch (Exception exception) {
			exception.printStackTrace();
		}finally {
			return usuario;
		}
		
	}

	@SuppressWarnings("finally")
	public Usuario getUsuario(String logon, String password) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			usuario = (Usuario) session.createQuery("from Usuario where logon = :logon and password = :password")
					.setParameter("password", password)
					.setParameter("logon", logon);
		} catch (Exception exception) {
			exception.printStackTrace();
		}finally {
			return usuario;
		}
	}
    
}
