package br.com.application.servlet;

import java.io.IOException;
import java.util.HashMap;
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

import br.com.application.domain.Mercadoria;
import br.com.application.domain.Modelo;
import br.com.application.domain.Produto;
import br.com.application.domain.embeddable.Configuracao;
import br.com.application.persistence.jpa.DepartamentoPersistence;
import br.com.application.persistence.jpa.EstoquePersistence;
import br.com.application.persistence.jpa.MercadoriaPersistence;
import br.com.application.persistence.jpa.ModeloPersistence;
import br.com.application.persistence.jpa.ProdutoPersistence;
import br.com.application.domain.Departamento;
import br.com.application.domain.Estoque;
import br.com.application.util.DateUtil;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/Mercadorias" })
public class MercadoriaController extends HttpServlet {
	
	JSONArray mercadoriasJSON;
	JSONObject mercadoriaJSON;
	
	EstoquePersistence EstoquePersistence;
	Estoque Estoque;
	
	ProdutoPersistence produtoPersistence;
	Produto produto;
	
	MercadoriaPersistence mercadoriaPersistence;
	Mercadoria mercadoria;
	
	DepartamentoPersistence departamentoPersistence;
	Departamento departamento;
	
	Configuracao configuracao;
	
	HashMap<String, Object> js = new HashMap<String, Object>();
	Gson gson = null;
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		js.put("idi", request.getParameter("idi").trim());
		js.put("idpt", request.getParameter("idpt").trim());
		js.put("srl", request.getParameter("srl").trim());
		js.put("typ", request.getParameter("typ").trim());
		js.put("ptm", request.getParameter("ptm").trim());
		
		js.put("dtg", request.getParameter("dtg").trim());
		js.put("ptm", request.getParameter("ptm").trim());
		js.put("amz", request.getParameter("amz").trim());
		js.put("cnt", request.getParameter("cnt").trim());
		js.put("pcs", request.getParameter("pcs").trim());
		js.put("sgr", request.getParameter("sgr").trim());
		js.put("bth", request.getParameter("bth").trim());
		js.put("cmr", request.getParameter("cmr").trim());
		js.put("gfc", request.getParameter("gfc").trim());
		js.put("mmr", request.getParameter("mmr").trim());
		js.put("tela", request.getParameter("tela").trim());
		js.put("btr", request.getParameter("btr").trim());
		js.put("som", request.getParameter("som").trim());
		js.put("cor", request.getParameter("cor").trim());
		js.put("os", request.getParameter("os").trim());
		js.put("op", request.getParameter("op").trim());
		
		try {
			
			mercadoriaPersistence = new MercadoriaPersistence();
			mercadoria = mercadoriaPersistence.findBy(Long.parseLong(js.get("idm").toString()));
			
			departamentoPersistence = new DepartamentoPersistence();
			departamento = departamentoPersistence.findBy(Long.parseLong(js.get("idpt").toString()));
		
			produtoPersistence = new ProdutoPersistence();
			produto = produtoPersistence.findBy(Long.parseLong(js.get("idp").toString()));
			
			mercadoriaPersistence = new MercadoriaPersistence();
			mercadoria = new Mercadoria();
			mercadoria.setProduto(produto);
			mercadoria.setSerial(js.get("srl").toString());
			mercadoria.setEstocada(Boolean.FALSE);
			mercadoria.setConfiguracao(configuracao);
			
			if(js.get("stk").toString().equals("SIM")) {
				mercadoria.setEstocada(Boolean.TRUE);
			}
			
			configuracao = new Configuracao();
			configuracao.setGarantia(DateUtil.converterStringToCalendar(js.get("dtg").toString()));
			configuracao.setArmazenamento(js.get("amz").toString());
			configuracao.setConectividade(js.get("cnt").toString());
			configuracao.setProcessamento(js.get("pcs").toString());
			configuracao.setSegurança(js.get("sgr").toString());
			configuracao.setBluethoot(js.get("bth").toString());
			configuracao.setCamera(js.get("cmr").toString());
			configuracao.setGrafico(js.get("gfc").toString());
			configuracao.setMemoria(js.get("mmr").toString());
			configuracao.setTela(js.get("tela").toString());
			configuracao.setBateria(js.get("btr").toString());
			configuracao.setSom(js.get("som").toString());
			configuracao.setCor(js.get("cor").toString());
			configuracao.setOS(js.get("os").toString());
			configuracao.setBivolt(Boolean.FALSE);
			
			if(js.get("os").toString().equals("SIM")) {
				configuracao.setBivolt(Boolean.TRUE);
			}
			
			
			mercadoria.setConfiguracao(configuracao);
			mercadoriaPersistence.merge(mercadoria);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(mercadoria.getId());
		}
	}
	
	private void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		js.put("idp", request.getParameter("idp").trim());
		js.put("idpt", request.getParameter("idpt").trim());
		js.put("srl", request.getParameter("srl").trim());
		js.put("typ", request.getParameter("typ").trim());
		js.put("ptm", request.getParameter("ptm").trim());
		js.put("stk", request.getParameter("stk").trim());
		
		js.put("dtg", request.getParameter("dtg").trim());
		js.put("ptm", request.getParameter("ptm").trim());
		js.put("amz", request.getParameter("amz").trim());
		js.put("cnt", request.getParameter("cnt").trim());
		js.put("pcs", request.getParameter("pcs").trim());
		js.put("sgr", request.getParameter("sgr").trim());
		js.put("bth", request.getParameter("bth").trim());
		js.put("cmr", request.getParameter("cmr").trim());
		js.put("gfc", request.getParameter("gfc").trim());
		js.put("mmr", request.getParameter("mmr").trim());
		js.put("tela", request.getParameter("tela").trim());
		js.put("btr", request.getParameter("btr").trim());
		js.put("som", request.getParameter("som").trim());
		js.put("cor", request.getParameter("cor").trim());
		js.put("os", request.getParameter("os").trim());
		js.put("op", request.getParameter("op").trim());
		
		try {
			
			configuracao = new Configuracao();
			configuracao.setGarantia(DateUtil.converterStringToCalendar(js.get("dtg").toString()));
			configuracao.setArmazenamento(js.get("amz").toString());
			configuracao.setConectividade(js.get("cnt").toString());
			configuracao.setProcessamento(js.get("pcs").toString());
			configuracao.setSegurança(js.get("sgr").toString());
			configuracao.setBluethoot(js.get("bth").toString());
			configuracao.setCamera(js.get("cmr").toString());
			configuracao.setGrafico(js.get("gfc").toString());
			configuracao.setMemoria(js.get("mmr").toString());
			configuracao.setTela(js.get("tela").toString());
			configuracao.setBateria(js.get("btr").toString());
			configuracao.setSom(js.get("som").toString());
			configuracao.setCor(js.get("cor").toString());
			configuracao.setOS(js.get("os").toString());
			
			if(js.get("op").toString().equals("SIM")) {	configuracao.setBivolt(Boolean.FALSE); }
			
			departamentoPersistence = new DepartamentoPersistence();
			departamento = departamentoPersistence.findBy(Long.parseLong(js.get("idpt").toString()));
		
			produtoPersistence = new ProdutoPersistence();
			produto = produtoPersistence.findBy(Long.parseLong(js.get("idp").toString()));
			
			mercadoriaPersistence = new MercadoriaPersistence();
			mercadoria = new Mercadoria();
			mercadoria.setProduto(produto);
			mercadoria.setSerial(js.get("srl").toString());
			mercadoria.setEstocada(Boolean.FALSE);
			mercadoria.setConfiguracao(configuracao);
			
			if(js.get("stk").toString().equals("SIM")) { mercadoria.setEstocada(Boolean.TRUE); }
			mercadoria = mercadoriaPersistence.merge(mercadoria);
		
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(mercadoria));
		}
	}
	
	private void findAll(HttpServletResponse response) throws Exception {
		try {
			mercadoriaPersistence = new MercadoriaPersistence();
			mercadoriasJSON = new JSONArray();
			for(Mercadoria mercadoria : mercadoriaPersistence.findAll()) {
				mercadoriaJSON = new JSONObject();
				mercadoriaJSON.put("serial number", mercadoria.getSerial());
				mercadoriaJSON.put("fornecedor", mercadoria.getProduto().getModelo().getFornecedor().getFornecedor().toString());
				mercadoriaJSON.put("modelo", mercadoria.getProduto().getModelo().getModelo());
				mercadoriaJSON.put("produto", mercadoria.getProduto().getProduto());
				mercadoriaJSON.put("valor", mercadoria.getProduto().getValor());
				mercadoriaJSON.put("codigo", mercadoria.getId());
				mercadoriasJSON.put(mercadoriaJSON);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(mercadoriasJSON);
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
