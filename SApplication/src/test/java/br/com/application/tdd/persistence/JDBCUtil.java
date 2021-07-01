package br.com.application.tdd.persistence;



import org.junit.Test;

import br.com.application.persistence.util.JDBConnectionUtil;

public class JDBCUtil {

	@Test
	public void JDBCUtil() throws Exception {
		JDBConnectionUtil.getConectionfactory();
	}
}
