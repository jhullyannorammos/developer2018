package br.com.application.tdd.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Test;

import br.com.application.persistence.util.HibernateUtil;

public class HibernateUtilTest {
	@Test
	public void conectar() throws HibernateException, Exception{
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		sessao.close();
		HibernateUtil.getSessionFactory().close();
	}
}
