package br.com.application.servlet;


import br.com.application.security.Criptografy;
import br.com.application.security.Logado;
import br.com.application.domain.Usuario;
import br.com.application.enumerator.UsuarioEnum;
import br.com.application.enumerator.UsuarioStatus;
import br.com.application.persistence.jpa.UsuarioPersistence;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*   @author Juliano Ramos  */

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/Security" })
public class LoginController extends HttpServlet {

	HashMap<String, Object> js = new HashMap<String, Object>();
	HttpServletRequest httpRequest = null;
	RequestDispatcher dispatcher = null;
	String url = "application?pg=156";

	HttpSession session = null;
	Gson gson = null;

	Logado logado;

	private UsuarioPersistence usuarioPersistence;
	private Usuario usuario;

	public LoginController() {
		super();
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			session.invalidate(); 
		} catch (Exception e) {
			
		}finally {
			response.sendRedirect("autenticar.jsp?Service=193");
		}
	}
	
	private void resetPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		js.put("idu", request.getParameter("idu").trim());
		try {
			
		}catch(Exception exception) {
			
		}finally {
			
		}
		
	}

	private void logon(HttpServletRequest request, HttpServletResponse response) throws Exception {

		js.put("lgn", request.getParameter("lgn").trim());
		js.put("psw", request.getParameter("psw").trim());
		js.put("url", request.getParameter("url").trim());

		usuarioPersistence = new UsuarioPersistence();
		usuario = new Usuario();
		usuario = usuarioPersistence.getUsuario(js.get("lgn").toString(), js.get("psw").toString());
		
		if (usuario != null) {
			logado = new Logado();
			logado.setIdentificador(usuario.getUsername());
			logado.setLogin(usuario.getEmail());
			logado.setSenha(usuario.getPassword());
			
			httpRequest = (HttpServletRequest) request;
			session = httpRequest.getSession();
			session.setAttribute("usuario", logado);
			
			dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} else {
			dispatcher = request.getRequestDispatcher("autenticar.jsp?Service=193");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * Processo para autorizar o logon capturando login e senha para retornar
	 * resposta
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 */
	private void save(HttpServletRequest request, HttpServletResponse response) throws Exception {

		js.put("eml", request.getParameter("eml").trim());
		js.put("ncp", request.getParameter("ncp").trim());
		js.put("pwd", request.getParameter("pwd").trim());
		try {
			usuarioPersistence = new UsuarioPersistence();
			usuario = new Usuario();
			usuario.setUsername(js.get("ncp").toString());
			usuario.setPerfil(UsuarioEnum.EXTERNAL);
			usuario.setStatus(UsuarioStatus.INATIVO);
			usuario.setEmail(js.get("eml").toString());
			usuario.setPassword(Criptografy.convertStringToMD5(js.get("pwd").toString()));
			usuarioPersistence.save(usuario);
		} catch (Exception e) {
			response.getWriter().print(gson.toJson(usuario.getEmail()));
		}
	}

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		gson = new GsonBuilder().setPrettyPrinting().create();
		int op = Integer.parseInt(request.getParameter("actionServlet"));
		switch (op) {
		case 100:
			save(request, response);
			break;
		case 200:
			logon(request, response);
			break;
		case 300:
			logout(request, response);
			break;
		case 400:
			resetPassword(request, response);
			break;
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
