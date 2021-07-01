package br.com.application.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.application.domain.Patrimonio;
import br.com.application.persistence.jpa.PatrimonioPersistence;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/Patrimonio" })
public class PatrimonioController extends HttpServlet{
	
	private PatrimonioPersistence patrimonioPersistence;
	private List<Patrimonio> patrimonios;
	private Patrimonio patrimonio;

	private JSONArray patrimoniosJSON;
	private JSONObject patrimonioJSON;
	
	private HashMap<String, Object> js = new HashMap<String, Object>();
	private Gson gson = null;
	
	public PatrimonioController() {
		super();
	}
	
	private void persist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(patrimonio));
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(patrimonio.getPatrimonio()));
		}
	}
	
	private void findBy(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
		}catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(exception.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(patrimoniosJSON);
		}
	}
	
	private void findAll(HttpServletResponse response) throws Exception {
		try {
			patrimonioPersistence = new PatrimonioPersistence();
			patrimoniosJSON = new JSONArray();
			for(Patrimonio patrimonio : patrimonioPersistence.findAll()) {
				patrimonioJSON = new JSONObject();
				patrimonioJSON.put("sistema", patrimonio.getSoftwareLicense().getSistema().toString());
				patrimonioJSON.put("key", patrimonio.getSoftwareLicense().getKey().toString());
				patrimonioJSON.put("patrimonio", patrimonio.getPatrimonio());
				patrimoniosJSON.put(patrimonioJSON);
			}
		}catch (Exception exception) {
			exception.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(exception.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(patrimoniosJSON);
		}
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException, Exception {
		gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");
		int op = Integer.parseInt(request.getParameter("actionServlet"));
		switch (op) {
		case 100:
			persist(request, response);
			break;
		case 200:
			delete(request, response);
			break;
		case 300:
			findBy(request, response);
			break;
		case 400:
			findAll(response);
			break;
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception ex) {
			Logger.getLogger(ProdutosController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception ex) {
			Logger.getLogger(ProdutosController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
