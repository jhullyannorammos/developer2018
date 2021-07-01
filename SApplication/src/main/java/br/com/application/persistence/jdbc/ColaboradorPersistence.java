package br.com.application.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.application.domain.Colaborador;
import br.com.application.domain.embeddable.Endereco;
import br.com.application.domain.embeddable.Telefone;
import br.com.application.persistence.util.JDBConnectionUtil;
import br.com.application.util.DateUtil;

public class ColaboradorPersistence {
	
	private static final String INSERT = "INSERT INTO APPLICATION.COLABORADORES"; 
	private static final String SELECT = "SELECT * FROM APPLICATION.COLABORADORES";
	private static final String UPDATE = "UPDATE APPLICATION.COLABORADORES SET";
	private static final String DELETE = "DELETE FROM APPLICATION.COLABORADORES";
	
	private static final String ATTRIBUTE_OR = " nome_completo = ? OR matricula = ? OR email = ? OR cpf = ? OR cnh = ? OR rg = ? OR cargo = ? OR remuneracao = ? OR dataNascimento = ?";
	private static final String ATTRIBUTE_AND = " nome_completo = ? AND matricula = ? AND email = ? AND cpf = ? AND cnh = ? AND rg = ? AND cargo = ? AND remuneracao = ? AND dataNascimento = ?";
	
	private static final String ATTRIBUTES_COLABORADOR = "(nomecompleto, matricula, email, remuneracao, rg, cargo, cnh, cpf, dataNascimento)";
	private static final String ATTRIBUTES_ENDERECO = " tipo_endereco, codigo_postal, logradouro, lote, quadra, bloco, rua, cidade, numero, complemento, uf)";
	private static final String ATTRIBUTES_TELEFONE = " tipo_fone, ddd, telefone,";
	private static final String VALUES = " VALUES(?,?,?,?,?,?,?,?,?)";
	
	private static final String ATTRIBUTES_UP_COLABORADOR = "(nome_completo = ?, matricula = ?, email = ?, remuneracao = ?, rg = ?, cargo = ?, cnh = ?, cpf = ?, dataNascimento = ?";
	private static final String ATTRIBUTES_UP_ENDERECO = " tipo_endereco = ?, codigo_postal = ?, logradouro, lote = ?, quadra = ?, bloco = ?, rua = ?, cidade = ?, numero = ?, complemento = ?, uf)";
	private static final String ATTRIBUTES_UP_TELEFONE = " tipo_fone = ?, telefone = ?, ddd = ?,";
	
	private static final String WHERE_BY_FK = " WHERE departamento_id = ?";
	private static final String WHERE_BY_PK = " WHERE codigo = ?";
	private static final String WHERE = " WHERE ";
	private static final String OR = " OR ";
	
	private List<Colaborador> colaboradores;
	private Colaborador colaborador;
	private Endereco endereco;
	private Telefone telefone;
	
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;

	public ColaboradorPersistence() throws Exception {
		connection = JDBConnectionUtil.getConectionfactory();
	}

	public void save(Colaborador colaborador) throws Exception {
		
		telefone = new Telefone();
		telefone.setTelefone(colaborador.getTelefone().getTelefone());
		telefone.setTipo(colaborador.getTelefone().getTipo());
		telefone.setDDD(colaborador.getTelefone().getDDD());
		
		endereco = new Endereco();
		endereco.setTipo(colaborador.getEndereco().getTipo()); 
		endereco.setCep(colaborador.getEndereco().getCep()); 
		endereco.setLogradouro(colaborador.getEndereco().getLogradouro()); 
		endereco.setLote(colaborador.getEndereco().getLote()); 
		endereco.setQuadra(colaborador.getEndereco().getQuadra()); 
		endereco.setBloco(colaborador.getEndereco().getBloco()); 
		endereco.setRua(colaborador.getEndereco().getRua()); 
		endereco.setCidade(colaborador.getEndereco().getCidade()); 
		endereco.setNumero(colaborador.getEndereco().getNumero()); 
		endereco.setComplemento(colaborador.getEndereco().getComplemento()); 
		endereco.setUf(colaborador.getEndereco().getUf()); 
		
		try {
			preparedStatement = connection.prepareStatement(INSERT + ATTRIBUTES_COLABORADOR + VALUES);
			preparedStatement.setString(1, colaborador.getNomeCompleto());
			preparedStatement.setString(2, colaborador.getMatricula());
			preparedStatement.setString(3, colaborador.getEmail());
			preparedStatement.setDouble(4, colaborador.getRemuneracao());
			preparedStatement.setString(5, colaborador.getRg());
			preparedStatement.setString(6, colaborador.getCargo());
			preparedStatement.setString(7, colaborador.getCnh());
			preparedStatement.setString(8, colaborador.getCpf());
			//preparedStatement.setDate(9, DateUtil.converterCalendarToString(colaborador.getDataNascimento()));
			
			preparedStatement.setString(10, telefone.getTelefone());
			preparedStatement.setString(11, telefone.getTipo());
			preparedStatement.setString(12, telefone.getDDD());
			preparedStatement.setString(13, endereco.getTipo());
			preparedStatement.setString(14, endereco.getCep());
			preparedStatement.setString(15, endereco.getLogradouro());
			preparedStatement.setString(16, endereco.getLote());
			preparedStatement.setString(17, endereco.getQuadra());
			preparedStatement.setString(18, endereco.getBloco());
			preparedStatement.setString(19, endereco.getRua());
			preparedStatement.setString(20, endereco.getCidade());
			preparedStatement.setString(21, endereco.getNumero());
			preparedStatement.setString(22, endereco.getComplemento());
			preparedStatement.setString(23, endereco.getUf());
			preparedStatement.execute();
		} catch (SQLException exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}
	
	public void update(Colaborador colaborador) throws Exception {
	    try {
			preparedStatement = connection.prepareStatement(UPDATE + ATTRIBUTES_UP_COLABORADOR + ATTRIBUTES_UP_TELEFONE + ATTRIBUTES_UP_ENDERECO + WHERE_BY_PK);
			preparedStatement.setString(1, colaborador.getNomeCompleto());
			preparedStatement.setString(2, colaborador.getMatricula());
			preparedStatement.setString(3, colaborador.getEmail());
			preparedStatement.setDouble(4, colaborador.getRemuneracao());
			preparedStatement.setString(5, colaborador.getRg());
			preparedStatement.setString(6, colaborador.getCargo());
			preparedStatement.setString(7, colaborador.getCnh());
			preparedStatement.setString(8, colaborador.getCpf());
			//preparedStatement.setDate(9, DateUtil.converterCalendarToString(colaborador.getDataNascimento()));
			preparedStatement.setLong(10, colaborador.getId());
			preparedStatement.execute();
	    } catch (SQLException exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}

	public List<Colaborador> findAll() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			colaboradores = new ArrayList<Colaborador>();
			while (resultSet.next()) {
				colaborador = new Colaborador();
				colaborador.setNomeCompleto(resultSet.getString("nomeCompleto"));
				colaborador.setMatricula(resultSet.getString("matricula"));
				colaborador.setEmail(resultSet.getString("email"));
				colaborador.setCpf(resultSet.getString("cpf"));
				colaborador.setCnh(resultSet.getString("cnh"));
				colaborador.setRg(resultSet.getString("rg"));
				colaborador.setCargo(resultSet.getString("cargo"));
				colaborador.setRemuneracao(resultSet.getDouble("remuneracao"));
				colaborador.setDataNascimento(DateUtil.converterStringToCalendar(resultSet.getString("dataNascimento")));
				colaboradores.add(colaborador);
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		}finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return colaboradores;
		}
	}
	
	public Colaborador findById(Long codigo) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				colaborador = new Colaborador();
				colaborador.setNomeCompleto(resultSet.getString("nomeCompleto"));
				colaborador.setMatricula(resultSet.getString("matricula"));
				colaborador.setEmail(resultSet.getString("email"));
				colaborador.setCpf(resultSet.getString("cpf"));
				colaborador.setCnh(resultSet.getString("cnh"));
				colaborador.setRg(resultSet.getString("rg"));
				colaborador.setCargo(resultSet.getString("cargo"));
				colaborador.setRemuneracao(resultSet.getDouble("remuneracao"));
				colaborador.setDataNascimento(DateUtil.converterStringToCalendar(resultSet.getString("dataNascimento")));
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		}finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return colaborador;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Colaborador> findBy(String codigo) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT + WHERE_BY_FK);
			preparedStatement.setString(1, codigo);
			resultSet = preparedStatement.executeQuery();
			colaboradores = new ArrayList<Colaborador>();
			if (resultSet.next()) {
				colaborador = new Colaborador();
				colaborador.setNomeCompleto(resultSet.getString("nomeCompleto"));
				colaborador.setMatricula(resultSet.getString("matricula"));
				colaborador.setEmail(resultSet.getString("email"));
				colaborador.setCpf(resultSet.getString("cpf"));
				colaborador.setCnh(resultSet.getString("cnh"));
				colaborador.setRg(resultSet.getString("rg"));
				colaborador.setCargo(resultSet.getString("cargo"));
				colaborador.setRemuneracao(resultSet.getDouble("remuneracao"));
				colaborador.setDataNascimento(DateUtil.converterStringToCalendar(resultSet.getString("dataNascimento")));
				colaboradores.add(colaborador);
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		}finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return colaboradores;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Colaborador> findByAny(Map<String, Object> map) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT + ATTRIBUTE_OR + WHERE_BY_FK + WHERE_BY_PK);
			preparedStatement.setString(1, map.get("nomeCompleto").toString());
			preparedStatement.setString(2, map.get("matricula").toString());
			preparedStatement.setString(3, map.get("email").toString());
			preparedStatement.setString(4, map.get("cpf").toString());
			preparedStatement.setString(5, map.get("cnh").toString());
			preparedStatement.setString(6, map.get("rg").toString());
			preparedStatement.setString(7, map.get("cargo").toString());
			preparedStatement.setString(8, map.get("remuneracao").toString());
			preparedStatement.setString(9, map.get("dataNascimento").toString());
			preparedStatement.setString(10, map.get("departamento_id").toString());
			preparedStatement.setString(11, map.get("codigo").toString());
			resultSet = preparedStatement.executeQuery();
			
			colaboradores = new ArrayList<Colaborador>();
			if (resultSet.next()) {
				colaborador = new Colaborador();
				colaborador.setNomeCompleto(resultSet.getString("nomeCompleto"));
				colaborador.setMatricula(resultSet.getString("matricula"));
				colaborador.setEmail(resultSet.getString("email"));
				colaborador.setCpf(resultSet.getString("cpf"));
				colaborador.setCnh(resultSet.getString("cnh"));
				colaborador.setRg(resultSet.getString("rg"));
				colaborador.setCargo(resultSet.getString("cargo"));
				colaborador.setRemuneracao(resultSet.getDouble("remuneracao"));
				colaborador.setDataNascimento(DateUtil.converterStringToCalendar(resultSet.getString("dataNascimento")));
				colaboradores.add(colaborador);
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		}finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
			return colaboradores;
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
