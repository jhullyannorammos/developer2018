package br.com.application.servlet;

import java.io.IOException;
import java.util.ArrayList;
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

import br.com.application.domain.Cidade;
import br.com.application.persistence.jpa.CidadePersistence;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/Cidades" })
public class CidadeController extends HttpServlet {

	private JSONObject cidadeJSON;
	private JSONArray cidadesJSON;
	private CidadePersistence cidadePersistence;
	private Gson gson = null;

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			cidadePersistence = new CidadePersistence();
			cidadesJSON = new JSONArray();
			for(Cidade c: cidadePersistence.findAll()){
				cidadeJSON = new JSONObject();
				cidadeJSON.put("federacao", c.getFederacao());
				cidadeJSON.put("cidade", c.getCidade());
				cidadeJSON.put("capital", c.isCapital());
				cidadeJSON.put("sigla", c.getSigla());
				cidadeJSON.put("codigo", c.getId());
				cidadesJSON.put(cidadeJSON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(e.getMessage().toString());
		} finally {
			response.setStatus(200);
			response.getWriter().print(cidadesJSON);
		}
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException, Exception {
		gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");
		int op = Integer.parseInt(request.getParameter("actionServlet"));
		switch (op) {
		case 400:
			findAll(request, response);
			break;
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception ex) {
			Logger.getLogger(ProdutosController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
