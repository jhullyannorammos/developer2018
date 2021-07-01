package br.com.application.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.application.domain.Cidade;
import br.com.application.domain.Mercadoria;
import br.com.application.enumerator.EstoqueEnum;
import br.com.application.enumerator.SoftwareEnum;
import br.com.application.persistence.util.JDBConnectionUtil;
import br.com.application.util.DateUtil;

public class MercadoriaPersistence {

	private static final String INSERT = "INSERT INTO APPLICATION.MERCADORIAS() VALUES(?,?,?)";
	private static final String SELECT = "SELECT * FROM APPLICATION.MERCADORIAS";
	private static final String DELETE = "DELETE * FROM APPLICATION.MERCADORIAS";
	private static final String UPDATE = "UPDATE APPLICATION.MERCADORIAS SET SERIALNUMBER = ? ";
	private static final String WHERE_BY_FK = " WHERE modelo = ?";
	private static final String WHERE_BY_PK = " WHERE codigo = ?";
    
	List<Map<String, Object>> maps;
	Map<String, Object> map;

	List<Mercadoria> mercadorias;
	Mercadoria mercadoria;

	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;

	public MercadoriaPersistence() throws Exception {
		connection = JDBConnectionUtil.getConectionfactory();
	}

	public void save(Mercadoria mercadoria) throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, mercadoria.getSerial());
			preparedStatement.setBoolean(2, mercadoria.isEstocada());
			preparedStatement.setLong(3, mercadoria.getPatrimonio().getId());
			preparedStatement.setLong(4, mercadoria.getProduto().getId());
			preparedStatement.setLong(5, mercadoria.getEstoque().getId());
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}

	public void update(Mercadoria mercadoria) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(UPDATE + WHERE_BY_PK);
			preparedStatement.setString(1, mercadoria.getSerial());
			preparedStatement.setBoolean(2, mercadoria.isEstocada());
			preparedStatement.setLong(3, mercadoria.getPatrimonio().getId());
			preparedStatement.setLong(4, mercadoria.getProduto().getId());
			preparedStatement.setLong(5, mercadoria.getEstoque().getId());
			preparedStatement.setLong(6, mercadoria.getId());
			preparedStatement.execute();
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}

	public List<Mercadoria> findAll() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			mercadorias = new ArrayList<Mercadoria>();
			while (resultSet.next()) {
				mercadoria = new Mercadoria();
				mercadoria.getConfiguracao().setGarantia(DateUtil.converterStringToCalendar(resultSet.getDate("Garantia").toString()));
				mercadoria.getConfiguracao().setArmazenamento(resultSet.getString("codigo"));
				mercadoria.getConfiguracao().setConectividade(resultSet.getString("conectividade"));
				mercadoria.getConfiguracao().setProcessamento(resultSet.getString("processamento"));
				mercadoria.getConfiguracao().setUnidadeOtica(resultSet.getBoolean("unidadeOtica"));
				mercadoria.getConfiguracao().setBluethoot(resultSet.getString("bluetooth"));
				mercadoria.getConfiguracao().setSegurança(resultSet.getString("segurança"));
				mercadoria.getConfiguracao().setBateria(resultSet.getString("bateria"));
				mercadoria.getConfiguracao().setGrafico(resultSet.getString("grafico"));
				mercadoria.getConfiguracao().setMemoria(resultSet.getString("memoria"));
				mercadoria.getConfiguracao().setBivolt(resultSet.getBoolean("bivolt"));
				mercadoria.getConfiguracao().setCamera(resultSet.getString("camera"));
				mercadoria.getConfiguracao().setTela(resultSet.getString("tela"));
				mercadoria.getConfiguracao().setSom(resultSet.getString("som"));
				mercadoria.getConfiguracao().setCor(resultSet.getString("cor"));
				mercadoria.getConfiguracao().setOS(resultSet.getString("OS"));

				mercadoria.getPatrimonio().getSoftwareLicense().setSistema(SoftwareEnum.getSoftwareEnum(resultSet.getString("sistema")));
				mercadoria.getPatrimonio().getSoftwareLicense().setKey(resultSet.getString("key"));
				mercadoria.getPatrimonio().setPatrimonio(resultSet.getString("patrimonio"));
				mercadoria.getPatrimonio().setSucateado(resultSet.getBoolean("sucateado"));

				mercadoria.getEstoque().setEstoque(EstoqueEnum.getEstoqueEnum(resultSet.getString("estoque")));
				mercadoria.getEstoque().setQuantidade(resultSet.getLong("quantidade"));
				mercadoria.getEstoque().setModelo(resultSet.getString("modelo"));

				mercadoria.setEstocada(resultSet.getBoolean("estocada"));
				mercadoria.setSerial(resultSet.getString("serialnumber"));
				//mercadoria.setId(resultSet.getLong("codigo"));
				mercadorias.add(mercadoria);
			}
		} catch (SQLException exception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return mercadorias;
		}
	}

	@SuppressWarnings("finally")
	public List<Mercadoria> find() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			maps = new ArrayList<Map<String, Object>>();
			while (resultSet.next()) {
				map = new HashMap<String, Object>();

				map.put("mercadorias.codigo", resultSet.getLong("mercadorias.codigo"));
				map.put("patrimonio_id", resultSet.getLong("patrimonio_id"));
				map.put("produto_id", resultSet.getLong("produto_id"));
				map.put("estoque_id", resultSet.getLong("estoque_id"));

				map.put("armazenamento", resultSet.getString("armazenamento"));
				map.put("conectividade", resultSet.getString("conectividade"));
				map.put("processamento", resultSet.getString("processamento"));
				map.put("unidadeOtica", resultSet.getString("unidadeOtica"));
				map.put("bluetooth", resultSet.getString("bluetooth"));
				map.put("segurança", resultSet.getString("segurança"));
				map.put("Garantia", resultSet.getString("Garantia"));
				map.put("bateria", resultSet.getString("bateria"));
				map.put("grafico", resultSet.getString("grafico"));
				map.put("memoria", resultSet.getString("memoria"));
				map.put("bivolt", resultSet.getString("bivolt"));
				map.put("camera", resultSet.getString("camera"));
				map.put("tela", resultSet.getString("tela"));
				map.put("som", resultSet.getString("som"));
				map.put("cor", resultSet.getString("cor"));
				map.put("OS", resultSet.getString("OS"));

				map.put("estocada", resultSet.getString("estocada"));
				map.put("serialnumber", resultSet.getString("serialnumber"));
				map.put("patrimonio", resultSet.getString("patrimonio"));
				map.put("sucateado", resultSet.getBoolean("sucateado"));
				map.put("sistema", resultSet.getString("sistema"));
				map.put("key", resultSet.getString("key"));
				map.put("quantidade", resultSet.getString("quantidade"));
				map.put("modelo", resultSet.getString("modelo"));

				maps.add(map);
			}
		} catch (SQLException exception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return mercadorias;
		}
	}
	
	public Mercadoria findById(long codigo) throws SQLException {
		try {
			preparedStatement = connection.prepareStatement(SELECT + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				mercadoria = new Mercadoria();
				mercadoria.getConfiguracao().setGarantia(DateUtil.converterStringToCalendar(resultSet.getDate("Garantia").toString()));
				mercadoria.getConfiguracao().setArmazenamento(resultSet.getString("codigo"));
				mercadoria.getConfiguracao().setConectividade(resultSet.getString("conectividade"));
				mercadoria.getConfiguracao().setProcessamento(resultSet.getString("processamento"));
				mercadoria.getConfiguracao().setUnidadeOtica(resultSet.getBoolean("unidadeOtica"));
				mercadoria.getConfiguracao().setBluethoot(resultSet.getString("bluetooth"));
				mercadoria.getConfiguracao().setSegurança(resultSet.getString("segurança"));
				mercadoria.getConfiguracao().setBateria(resultSet.getString("bateria"));
				mercadoria.getConfiguracao().setGrafico(resultSet.getString("grafico"));
				mercadoria.getConfiguracao().setMemoria(resultSet.getString("memoria"));
				mercadoria.getConfiguracao().setBivolt(resultSet.getBoolean("bivolt"));
				mercadoria.getConfiguracao().setCamera(resultSet.getString("camera"));
				mercadoria.getConfiguracao().setTela(resultSet.getString("tela"));
				mercadoria.getConfiguracao().setSom(resultSet.getString("som"));
				mercadoria.getConfiguracao().setCor(resultSet.getString("cor"));
				mercadoria.getConfiguracao().setOS(resultSet.getString("OS"));

				mercadoria.getPatrimonio().getSoftwareLicense().setSistema(SoftwareEnum.getSoftwareEnum(resultSet.getString("sistema")));
				mercadoria.getPatrimonio().getSoftwareLicense().setKey(resultSet.getString("key"));
				mercadoria.getPatrimonio().setPatrimonio(resultSet.getString("patrimonio"));
				mercadoria.getPatrimonio().setSucateado(resultSet.getBoolean("sucateado"));

				mercadoria.getEstoque().setEstoque(EstoqueEnum.getEstoqueEnum(resultSet.getString("estoque")));
				mercadoria.getEstoque().setQuantidade(resultSet.getLong("quantidade"));
				mercadoria.getEstoque().setModelo(resultSet.getString("modelo"));

				mercadoria.setEstocada(resultSet.getBoolean("estocada"));
				mercadoria.setSerial(resultSet.getString("serialnumber"));
				//mercadoria.setId(resultSet.getLong("codigo"));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return mercadoria;
		}
	}

	public void delete(Long codigo) throws Exception {
		try {
			preparedStatement = this.connection.prepareStatement(DELETE + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			preparedStatement.execute();
		} catch (SQLException exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}

}
