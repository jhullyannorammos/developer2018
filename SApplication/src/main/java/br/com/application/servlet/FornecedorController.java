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

import br.com.application.domain.Fornecedor;
import br.com.application.enumerator.FornecedorEnum;
import br.com.application.persistence.jpa.FornecedorPersistence;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/Fornecedores" })
public class FornecedorController extends HttpServlet {

	HashMap<String, Object> responseModel;
	Gson gson = null;
	
	JSONArray fornecedoresJSON;
	JSONObject fornecedorJSON;

	List<Fornecedor> fornecedores;
	FornecedorPersistence fornecedorPersistence;
	Fornecedor fornecedor;

	public FornecedorController() {
		super();
		responseModel = new HashMap<String, Object>();
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws Exception {

		responseModel.put("fbt", request.getParameter("fbt").trim());
		responseModel.put("abg", request.getParameter("abg").trim());
		
		responseModel.put("ddd", request.getParameter("ddd").trim());
		responseModel.put("tlf", request.getParameter("tlf").trim());
		responseModel.put("tpf", request.getParameter("tpf").trim());
		
		responseModel.put("cep", request.getParameter("cep").trim());
		responseModel.put("tpe", request.getParameter("tpe").trim());
		responseModel.put("lgd", request.getParameter("lgd").trim());
		responseModel.put("blc", request.getParameter("blc").trim());
		responseModel.put("lte", request.getParameter("lte").trim());
		responseModel.put("qdr", request.getParameter("qdr").trim());
		responseModel.put("nmr", request.getParameter("nmr").trim());
		responseModel.put("cpm", request.getParameter("cpm").trim());
		responseModel.put("cdd", request.getParameter("cdd").trim());
		responseModel.put("uf", request.getParameter("uf").trim());
		
		try {
			fornecedorPersistence = new FornecedorPersistence();
			fornecedor = new Fornecedor();
			fornecedor.setFornecedor(responseModel.get("fbt").toString());
			fornecedor.setAbrangencia(FornecedorEnum.getFornecedorEnum(responseModel.get("abg").toString()));
			
			fornecedor.setFornecedor(responseModel.get("ddd").toString());
			fornecedor.setFornecedor(responseModel.get("tlf").toString());
			fornecedor.setFornecedor(responseModel.get("tpf").toString());
			
			fornecedor.setFornecedor(responseModel.get("cep").toString());
			fornecedor.setFornecedor(responseModel.get("tpe").toString());
			fornecedor.setFornecedor(responseModel.get("lgd").toString());
			fornecedor.setFornecedor(responseModel.get("blc").toString());
			fornecedor.setFornecedor(responseModel.get("lte").toString());
			fornecedor.setFornecedor(responseModel.get("qdr").toString());
			fornecedor.setFornecedor(responseModel.get("nmr").toString());
			fornecedor.setFornecedor(responseModel.get("cpm").toString());
			fornecedor.setFornecedor(responseModel.get("cdd").toString());
			fornecedor.setFornecedor(responseModel.get("uf").toString());
			
			fornecedorPersistence.save(fornecedor);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(fornecedor.getFornecedor()));
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {

		responseModel.put("idf", request.getParameter("idf").trim());
		responseModel.put("fbt", request.getParameter("fbt").trim());
		responseModel.put("abg", request.getParameter("abg").trim());
		
		responseModel.put("ddd", request.getParameter("ddd").trim());
		responseModel.put("tlf", request.getParameter("tlf").trim());
		responseModel.put("tpf", request.getParameter("tpf").trim());
		
		responseModel.put("cep", request.getParameter("cep").trim());
		responseModel.put("tpe", request.getParameter("tpe").trim());
		responseModel.put("lgd", request.getParameter("lgd").trim());
		responseModel.put("blc", request.getParameter("blc").trim());
		responseModel.put("lte", request.getParameter("lte").trim());
		responseModel.put("qdr", request.getParameter("qdr").trim());
		responseModel.put("nmr", request.getParameter("nmr").trim());
		responseModel.put("cpm", request.getParameter("cpm").trim());
		responseModel.put("cdd", request.getParameter("cdd").trim());
		responseModel.put("uf", request.getParameter("uf").trim());
		
		try {
			
			fornecedorPersistence = new FornecedorPersistence();
			fornecedor = fornecedorPersistence.findBy(Long.parseLong(responseModel.get("idf").toString()));
			fornecedor.setFornecedor(responseModel.get("fbt").toString());
			fornecedor.setAbrangencia(FornecedorEnum.getFornecedorEnum(responseModel.get("abg").toString()));
			
			fornecedor.setFornecedor(responseModel.get("ddd").toString());
			fornecedor.setFornecedor(responseModel.get("tlf").toString());
			fornecedor.setFornecedor(responseModel.get("tpf").toString());
			
			fornecedor.setFornecedor(responseModel.get("cep").toString());
			fornecedor.setFornecedor(responseModel.get("tpe").toString());
			fornecedor.setFornecedor(responseModel.get("lgd").toString());
			fornecedor.setFornecedor(responseModel.get("blc").toString());
			fornecedor.setFornecedor(responseModel.get("lte").toString());
			fornecedor.setFornecedor(responseModel.get("qdr").toString());
			fornecedor.setFornecedor(responseModel.get("nmr").toString());
			fornecedor.setFornecedor(responseModel.get("cpm").toString());
			fornecedor.setFornecedor(responseModel.get("cdd").toString());
			fornecedor.setFornecedor(responseModel.get("uf").toString());
			
			fornecedorPersistence.update(fornecedor);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(fornecedor.getFornecedor()));
		}
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

		responseModel.put("idf", request.getParameter("idf").trim());
		try {
			fornecedorPersistence = new FornecedorPersistence();
			fornecedor = fornecedorPersistence.findBy(Long.parseLong(responseModel.get("idf").toString()));
			//fornecedorPersistence.delete(Long.parseLong(responseModel.get("idf").toString()));
			fornecedorPersistence.delete(fornecedor);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(fornecedor.getFornecedor()));
		}
	}
	
	
	private void findAll(HttpServletResponse response) throws Exception {
		try {
			fornecedorPersistence = new FornecedorPersistence();
			fornecedoresJSON = new JSONArray();
			for(Fornecedor fornecedor: fornecedorPersistence.findAll()) {
				fornecedorJSON = new JSONObject();
				fornecedorJSON.put("abrangencia", fornecedor.getAbrangencia());
				fornecedorJSON.put("fornecedor", fornecedor.getFornecedor());
				fornecedorJSON.put("codigo", fornecedor.getId());
				fornecedoresJSON.put(fornecedorJSON);
			}
		} catch (IOException e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(fornecedoresJSON);
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
			update(request, response);
			break;
		case 300:
			delete(request, response);
			break;
		case 400:
			findAll(response);
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
