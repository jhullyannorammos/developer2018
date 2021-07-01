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

import br.com.application.domain.Modelo;
import br.com.application.persistence.jpa.FornecedorPersistence;
import br.com.application.persistence.jpa.ModeloPersistence;
import br.com.application.domain.Fornecedor;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/Modelos"})
public class ModeloController extends HttpServlet {

	HashMap<String, Object> js = new HashMap<String, Object>();
	Gson gson = null;
	String jsonArray;

	ModeloPersistence modeloPersistence;
	List<Modelo> modelos;
	Modelo modelo;
	
	FornecedorPersistence fornecedorPersistence;
	List<Fornecedor> fornecedores;
	Fornecedor fornecedor;
	
	JSONArray modelosJSON;
	JSONObject modeloJSON;

	public ModeloController() {
		super();
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws Exception {

		js.put("mdl", request.getParameter("mdl").trim());
		js.put("ano", request.getParameter("ano").trim());
		js.put("fnd", request.getParameter("fnd").trim());
		try {
			
			fornecedorPersistence = new FornecedorPersistence();
			fornecedor = fornecedorPersistence.findBy(Long.parseLong(js.get("fnd").toString()));
			
			modeloPersistence = new ModeloPersistence();
			modelo = new Modelo();
			
			modelo.setModelo(js.get("mdl").toString());
			modelo.setLancamento(js.get("ano").toString());
			modelo.setFornecedor(fornecedor); 
            fornecedor.getModelos().add(modelo);
            
            modeloPersistence.save(modelo);
            fornecedorPersistence.merge(fornecedor);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(modelo.getModelo()));
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {

		js.put("idm", request.getParameter("idm").trim());
		js.put("ano", request.getParameter("ano").trim());
		js.put("mdl", request.getParameter("mdl").trim());
		try {
			
			modeloPersistence = new ModeloPersistence();
			modelo = modeloPersistence.findBy(Long.parseLong(js.get("idm").toString()));
			modelo.setLancamento(js.get("ano").toString());
            modelo.setModelo(js.get("mdl").toString());
			modeloPersistence.update(modelo);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(modelo.getModelo()));
		}
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

		js.put("idf", request.getParameter("idf").trim());
		try {
			
			modeloPersistence = new ModeloPersistence();
			modelo = modeloPersistence.findBy(Long.parseLong(js.get("idm").toString()));
			modeloPersistence.delete(modelo);
			
		} catch (IOException e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(modelo.getModelo()));
		}
	}

	
    
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			modeloPersistence = new ModeloPersistence();
			modelosJSON = new JSONArray();
			for(Modelo modelo: modeloPersistence.findAll()) {
				modeloJSON = new JSONObject();
				modeloJSON.put("fornecedor", modelo.getFornecedor().getFornecedor());
				modeloJSON.put("lancamento", modelo.getLancamento());
				modeloJSON.put("modelo", modelo.getModelo());
				modeloJSON.put("codigo", modelo.getId());
				modelosJSON.put(modeloJSON);
			}
		} catch (IOException e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(modelosJSON);
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
