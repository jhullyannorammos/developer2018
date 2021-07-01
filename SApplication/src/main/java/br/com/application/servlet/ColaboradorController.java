package br.com.application.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import br.com.application.domain.Departamento;
import br.com.application.persistence.jpa.ColaboradorPersistence;
import br.com.application.persistence.jpa.DepartamentoPersistence;
import br.com.application.domain.Colaborador;
import br.com.application.util.DateUtil;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/Colaboradores" })
public class ColaboradorController extends HttpServlet {

	HashMap<String, Object> js = new HashMap<String, Object>();
	RequestDispatcher dispatcher = null;
	private JSONObject colaboradorJSON;
	private JSONArray colaboradoresJSON;
	Gson gson = null;
	PrintWriter printWriter;
	
	private ColaboradorPersistence colaboradorPersistence;
	private List<Colaborador> colaboradors;
	private Colaborador colaborador;
	
	DepartamentoPersistence departamentoPersistence;
	Departamento departamento;
	
	private String responseSucess = "transação realizada com sucesso"; 

	public ColaboradorController() {
		super();
	}
	
    private void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		js.put("ncp", request.getParameter("ncp").trim());
		js.put("crg", request.getParameter("crg").trim());
		js.put("rmc", request.getParameter("rmc").trim());
		js.put("dtn", request.getParameter("dtn").trim());
		js.put("cnh", request.getParameter("cnh").trim());
		js.put("cpf", request.getParameter("cpf").trim());
		js.put("rgg", request.getParameter("rgg").trim());
    	
		try {
			
			departamentoPersistence = new DepartamentoPersistence();
			departamento = departamentoPersistence.findBy(Long.parseLong(js.get("dpt").toString()));
			
			colaboradorPersistence = new ColaboradorPersistence();
			colaborador = new Colaborador();
			
			colaborador.setNomeCompleto(js.get("ncp").toString());
			colaborador.setCargo(js.get("crg").toString());
			colaborador.setRemuneracao(Double.parseDouble(js.get("rmc").toString()));
			colaborador.setDataNascimento(DateUtil.converterStringToCalendar(js.get("dtn").toString()));
			colaborador.setCnh(js.get("cnh").toString());
			colaborador.setCpf(js.get("cpf").toString());
			colaborador.setRg(js.get("rgg").toString());
			colaborador.setDepartamento(departamento);
			departamento.getColaboradores().add(colaborador);
			
			colaboradorPersistence.save(colaborador);
			departamentoPersistence.merge(departamento);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		} finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(responseSucess));
		}
	}
    
    
    private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
    	js.put("ice", request.getParameter("ice").trim());
    	js.put("crg", request.getParameter("crg").trim());
		js.put("rmc", request.getParameter("rmc").trim());
		js.put("dtn", request.getParameter("dtn").trim());
		js.put("cnh", request.getParameter("cnh").trim());
		js.put("cpf", request.getParameter("cpf").trim());
		js.put("rgg", request.getParameter("rgg").trim());
    	
		try {
			departamentoPersistence = new DepartamentoPersistence();
			departamento = departamentoPersistence.findBy(Long.parseLong(js.get("dpt").toString()));
			
			colaboradorPersistence = new ColaboradorPersistence();
			colaborador = colaboradorPersistence.findBy(Long.parseLong(js.get("idc").toString()));
			
			colaborador.setNomeCompleto(js.get("ncp").toString());
			colaborador.setCargo(js.get("crg").toString());
			colaborador.setRemuneracao(Double.parseDouble(js.get("rmc").toString()));
			colaborador.setDataNascimento(DateUtil.converterStringToCalendar(js.get("dtn").toString()));
			colaborador.setCnh(js.get("cnh").toString());
			colaborador.setCpf(js.get("cpf").toString());
			colaborador.setRg(js.get("rgg").toString());
			
			colaborador.setDepartamento(departamento);
			colaboradorPersistence.merge(colaborador);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		} finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(responseSucess));
		}
	}



	private void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		js.put("idc", request.getParameter("idc").trim());
		try {
			colaborador = colaboradorPersistence.findBy(Long.parseLong(js.get("idc").toString()));
			colaboradorPersistence.delete(colaborador);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		} finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(responseSucess));
		}
	}
	
    private void findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			colaboradorPersistence = new ColaboradorPersistence();
			colaboradors = new ArrayList<>();
			colaboradors = colaboradorPersistence.findAll();
			
			colaboradoresJSON = new JSONArray();
			for(Colaborador colaborador: colaboradors) {
				colaboradorJSON = new JSONObject();
				colaboradorJSON.put("datanascimento", DateUtil.converterCalendarToString(colaborador.getDataNascimento()));
				colaboradorJSON.put("departamento", colaborador.getDepartamento().getDepartamento());
				colaboradorJSON.put("hierarquia", colaborador.getDepartamento().getHierarquia());
				colaboradorJSON.put("sigla", colaborador.getDepartamento().getSigla());
				colaboradorJSON.put("nome", colaborador.getNomeCompleto());
				colaboradorJSON.put("remuneracao", colaborador.getRemuneracao());
				colaboradorJSON.put("cargo", colaborador.getCargo());
				colaboradorJSON.put("cnh", colaborador.getCnh());
				colaboradorJSON.put("cpf", colaborador.getCpf());
				colaboradorJSON.put("rg", colaborador.getRg());
				colaboradorJSON.put("codigo", colaborador.getId());
				colaboradoresJSON.put(colaboradorJSON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		} finally {
			response.setStatus(200);
			response.getWriter().print(colaboradoresJSON);
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
		response.setContentType("application/json; charset=utf-8");
		int operator = Integer.parseInt(request.getParameter("actionServlet"));

		switch (operator) {
		case 100:
			save(request, response);
			break;
		case 200:
			update(request, response);
			break;
		case 300:
			remove(request, response);
			break;
		case 400:
			findAll(request, response);
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
			Logger.getLogger(ColaboradorController.class.getName()).log(Level.SEVERE, null, ex);
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
			Logger.getLogger(ColaboradorController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Handles the HTTP <code>PUT</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception ex) {
			Logger.getLogger(ColaboradorController.class.getName()).log(Level.SEVERE, null, ex);
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
