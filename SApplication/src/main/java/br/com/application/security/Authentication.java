package br.com.application.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.application.persistence.util.HibernateUtil;

@WebFilter(urlPatterns={"/pages/*"})  
public class Authentication implements Filter {
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
         try {
			//HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest requisition = (HttpServletRequest) request;
		HttpSession session = requisition.getSession();
		String url = requisition.getServletPath();
		Logado logado = (Logado) session.getAttribute("usuario");
		
		if (logado == null && !url.equalsIgnoreCase("Usuario?actionServlet=200")){ 
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/logon2.jsp");
	    	dispatcher.forward(request, response);
	    	return;
	    }
		
		chain.doFilter(request, response);
	}

}
