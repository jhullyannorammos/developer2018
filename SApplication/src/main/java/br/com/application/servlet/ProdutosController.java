package br.com.application.servlet;

import br.com.application.domain.Modelo;
import br.com.application.domain.Produto;
import br.com.application.persistence.jpa.FornecedorPersistence;
import br.com.application.persistence.jpa.ModeloPersistence;
import br.com.application.persistence.jpa.ProdutoPersistence;
import br.com.application.domain.Fornecedor;

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


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/Produtos" })
public class ProdutosController extends HttpServlet {

	HashMap<String, Object> js = new HashMap<String, Object>();
	String jsonArray;
	Gson gson = null;
	
	List<Produto> produtos;
	ProdutoPersistence produtoPersistence;
	Produto produto;
	
	List<Modelo> modelos;
	ModeloPersistence modeloPersistence;
	Modelo modelo;
	
	List<Fornecedor> fornecedors;
	FornecedorPersistence fornecedorPersistence;
	Fornecedor fornecedor;
	
	private JSONObject produtoJSON;
	private JSONArray produtosJSON;

	public ProdutosController() {
		super();
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws Exception {

		js.put("idm", request.getParameter("idm").trim());
		js.put("pdt", request.getParameter("pdt").trim());
		js.put("vlr", request.getParameter("vlr").trim());
		try {
			modeloPersistence = new ModeloPersistence();
			modelo = modeloPersistence.findBy(Long.parseLong(js.get("idm").toString()));

			produtoPersistence = new ProdutoPersistence();
			produto = new Produto();
			produto.setModelo(modelo);
			produto.setProduto(js.get("pdt").toString());
			produto.setValor(Double.parseDouble(js.get("vlr").toString()));
			produtoPersistence.save(produto);
			

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(produto.getProduto()));
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		js.put("idproduto", request.getParameter("idproduto").trim());
		js.put("idmodelo", request.getParameter("idmodelo").trim());
		js.put("descricao", request.getParameter("descricao").trim());
		js.put("valor", request.getParameter("valor").trim());
		js.put("produto", request.getParameter("produto").trim());
		js.put("vlr", request.getParameter("vlr").trim());
		try {
			modeloPersistence = new ModeloPersistence();
			modelo = modeloPersistence.findBy(Long.parseLong(js.get("idmodelo").toString()));

			produtoPersistence = new ProdutoPersistence();
			produto = new Produto();
			produto = produtoPersistence.findBy(Long.parseLong(js.get("idproduto").toString()));
			produto.setModelo(modelo);
			produto.setProduto(js.get("produto").toString());
			produto.setValor(Double.parseDouble(js.get("vlr").toString()));
			produtoPersistence.merge(produto);

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(produto.getProduto()));
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

		js.put("idproduto", request.getParameter("idproduto").trim());
		try {
			produtoPersistence = new ProdutoPersistence();
			produto = produtoPersistence.findBy(Long.parseLong(js.get("idproduto").toString()));
			produtoPersistence.delete(produto);

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(produto.getProduto()));
		}

	}
	
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			produtoPersistence = new ProdutoPersistence();		
			produtosJSON = new JSONArray();
			for(Produto produto : produtoPersistence.findAll()) {
				produtoJSON = new JSONObject();
				produtoJSON.put("fornecedor", produto.getModelo().getFornecedor().getFornecedor());
				produtoJSON.put("abrangencia", produto.getModelo().getFornecedor().getAbrangencia());
				produtoJSON.put("modelo", produto.getModelo().getModelo());
				produtoJSON.put("produto", produto.getProduto());
				produtoJSON.put("valor", produto.getValor());
				produtoJSON.put("codigo", produto.getId());
				produtosJSON.put(produtoJSON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(e.getMessage());
		}finally {
			response.setStatus(200);
			response.getWriter().print(new Gson().toJson(produtosJSON));
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
