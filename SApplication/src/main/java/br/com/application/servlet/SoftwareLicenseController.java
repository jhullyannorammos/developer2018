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

import br.com.application.domain.SoftwareLicense;
import br.com.application.persistence.jpa.SoftwareLicensePersistence;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/SoftwareLicense" })
public class SoftwareLicenseController extends HttpServlet{

	private SoftwareLicensePersistence SLicensePersistence;
	private SoftwareLicense SLicense;
	private JSONArray SLicensesJSON;
	private JSONObject SLicenseJSON;
	private Gson gson = null;
	
	public SoftwareLicenseController() {
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
			response.getWriter().print(gson.toJson(SLicense.getPatrimonio()));
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
			response.getWriter().print(gson.toJson(SLicense.getPatrimonio()));
		}
	}
	
	private void findBy(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(SLicenseJSON);
		}
	}
	
	private void findAll(HttpServletResponse response) throws Exception {
		try {
			SLicensePersistence = new SoftwareLicensePersistence();
			SLicensesJSON = new JSONArray();
			for(SoftwareLicense softwareLicense : SLicensePersistence.findAll()) {
				SLicenseJSON = new JSONObject();
				SLicenseJSON.put("key", softwareLicense.getKey());
				SLicenseJSON.put("sistema", softwareLicense.getSistema());
				SLicensesJSON.put(SLicenseJSON);
			}
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(SLicensesJSON);
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

