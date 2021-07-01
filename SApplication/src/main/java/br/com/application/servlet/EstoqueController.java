package br.com.application.servlet;

import br.com.application.domain.Modelo;
import br.com.application.enumerator.EstoqueEnum;
import br.com.application.persistence.jpa.EstoquePersistence;
import br.com.application.persistence.jpa.ModeloPersistence;
import br.com.application.domain.Estoque;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/Estoques" })
public class EstoqueController extends HttpServlet {

	private HashMap<String, Object> js = new HashMap<String, Object>();
	private Gson gson = null;
	private  String jsonArray;
	
	private ModeloPersistence modeloPersistence;
	private Modelo modelo;
	
	private EstoquePersistence estoquePersistence;
	private List<Estoque> estoques;
	private Estoque estoque;
	
	private JSONArray estoquesJSON;
	private JSONObject estoqueJSON;


	public EstoqueController() {
		super();
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		js.put("idm", request.getParameter("idm").trim());
		js.put("qtd", request.getParameter("qtd").trim());
		js.put("enum", request.getParameter("enum").trim());
		try {
			modeloPersistence = new ModeloPersistence();
			modelo = new Modelo();
			modelo = modeloPersistence.findBy(Long.parseLong(js.get("idm").toString()));
			
			estoquePersistence = new EstoquePersistence();
			estoque = new Estoque();
			
			estoque.setModelo(modelo.getModelo());
			estoque.setEstoque(EstoqueEnum.getEstoqueEnum(js.get("enum").toString()));
			estoque.setQuantidade(Long.parseLong(js.get("qtd").toString()));
			estoquePersistence.save(estoque);

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		} finally {
			
			response.setStatus(200);
			response.getWriter().print(gson.toJson(modelo.getModelo().toString()));
		}
	}
	
    private void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	js.put("idm", request.getParameter("idm").trim());
		try {
			//estoque = estoqueJDBC.getEstoqueByModeloId(Long.parseLong(js.get("idm").toString()));
			//estoqueJDBC.update(estoque);
			//estoque.setQuantidade(Long.parseLong(js.get("qtd").toString()));
			//js.put("qtd", request.getParameter("qtd").trim());
			
			estoquePersistence = new EstoquePersistence();
			estoque = estoquePersistence.findBy(Long.parseLong(js.get("idm").toString()));
			estoque.setQuantidade(estoque.getQuantidade() + 1);
			estoquePersistence.merge(estoque);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		} finally {
			response.setStatus(200);
			response.getWriter().print(estoque.getQuantidade());
		}
	}
    
    private void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	js.put("idm", request.getParameter("idm").trim());
		try {
			//estoque.setQuantidade(Long.parseLong(js.get("qtd").toString()));
			//js.put("qtd", request.getParameter("qtd").trim());
			
			estoquePersistence = new EstoquePersistence();
			estoque = estoquePersistence.findBy(Long.parseLong(js.get("idm").toString()));
			estoque.setQuantidade(estoque.getQuantidade() - 1);
			estoquePersistence.merge(estoque);

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		} finally {
			response.setStatus(200);
			response.getWriter().print(estoque.getQuantidade());
		}
	}
    
    private void findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			estoquePersistence = new EstoquePersistence();
			estoques = new ArrayList<Estoque>();
			estoques = estoquePersistence.findAll();
			
			estoquesJSON = new JSONArray();
			
			for(Estoque estoque : estoques) {
				estoqueJSON = new JSONObject();
				estoqueJSON.put("quantidade", estoque.getQuantidade());
				estoqueJSON.put("tipo", estoque.getEstoque().toString());
				estoqueJSON.put("modelo", estoque.getModelo());
				estoquesJSON.put(estoqueJSON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(estoquesJSON);
		}
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");
		int op = Integer.parseInt(request.getParameter("actionServlet"));
		switch (op) {
		case 100:
			save(request, response);
			break;
		case 200:
			remove(request, response);
			break;
		case 300:
			add(request, response);
			break;
		case 400:
			findAll(request, response);
			break;
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
