package br.com.application.persistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.application.domain.Fornecedor;
import br.com.application.enumerator.EstoqueEnum;
import br.com.application.persistence.util.JDBConnectionUtil;

public class FornecedorPersistence {
	
	private static final String INSERT = "INSERT INTO APPLICATION.FORNECEDORES";
	private static final String UPDATE = "UPDATE APPLICATION.FORNECEDORES";
	private static final String ATTRIBUTES = "(fornecedor, abrangencia, tipo_fone, ddd, telefone, tipo_endereco, codigo_postal, logradouro, quadra, lote, bloco, rua, numero, complemento, uf, cidade)";
	private static final String ATTRIBUTES_UP = " fornecedor = ?, abrangencia = ?, tipo_fone = ?, ddd = ?, telefone = ?, tipo_endereco = ?, codigo_postal = ?, logradouro = ?, quadra = ?, lote = ?, bloco = ?, rua = ?, numero = ?, complemento = ?, uf = ?, cidade = ?";
	private static final String VALUES = " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String DELETE = "DELETE * FROM APPLICATION.FORNECEDORES";
	private static final String SELECT = "SELECT * FROM APPLICATION.FORNECEDORES";
	private static final String WHERE_BY_PK = " WHERE codigo = ?";
    
	List<Fornecedor> fornecedores;
	Fornecedor fornecedor;
	PreparedStatement preparedStatement;
	Connection connection;
	ResultSet resultSet;
	String clausuleSQL;
	
	public FornecedorPersistence() throws Exception {
		connection = JDBConnectionUtil.getConectionfactory();
	}
	
	public void save(Fornecedor fornecedor) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(INSERT + ATTRIBUTES + VALUES);
			preparedStatement.setString(1, fornecedor.getFornecedor());
			preparedStatement.setString(2, EstoqueEnum.getEstoqueEnum(fornecedor.getFornecedor()).toString());
			preparedStatement.setString(3, fornecedor.getTelefone().getTipo());
			preparedStatement.setString(4, fornecedor.getTelefone().getDDD());
			preparedStatement.setString(5, fornecedor.getTelefone().getTelefone());
			preparedStatement.setString(6, fornecedor.getEndereco().getTipo());
			preparedStatement.setString(7, fornecedor.getEndereco().getCep());
			preparedStatement.setString(8, fornecedor.getEndereco().getLogradouro());
			preparedStatement.setString(9, fornecedor.getEndereco().getQuadra());
			preparedStatement.setString(10, fornecedor.getEndereco().getLote());
			preparedStatement.setString(11, fornecedor.getEndereco().getBloco());
			preparedStatement.setString(12, fornecedor.getEndereco().getRua());
			preparedStatement.setString(13, fornecedor.getEndereco().getNumero());
			preparedStatement.setString(14, fornecedor.getEndereco().getComplemento());
			preparedStatement.setString(15, fornecedor.getEndereco().getUf());
			preparedStatement.setString(16, fornecedor.getEndereco().getCidade());
			preparedStatement.execute();
		} catch (SQLException exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}
	
	
	public void update(Fornecedor fornecedor) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(UPDATE + ATTRIBUTES_UP + WHERE_BY_PK);
			preparedStatement.setString(1, fornecedor.getFornecedor());
			preparedStatement.setString(2, EstoqueEnum.getEstoqueEnum(fornecedor.getFornecedor()).toString());
			preparedStatement.setString(3, fornecedor.getTelefone().getTipo());
			preparedStatement.setString(4, fornecedor.getTelefone().getDDD());
			preparedStatement.setString(5, fornecedor.getTelefone().getTelefone());
			preparedStatement.setString(6, fornecedor.getEndereco().getTipo());
			preparedStatement.setString(7, fornecedor.getEndereco().getCep());
			preparedStatement.setString(8, fornecedor.getEndereco().getLogradouro());
			preparedStatement.setString(9, fornecedor.getEndereco().getQuadra());
			preparedStatement.setString(10, fornecedor.getEndereco().getLote());
			preparedStatement.setString(11, fornecedor.getEndereco().getBloco());
			preparedStatement.setString(12, fornecedor.getEndereco().getRua());
			preparedStatement.setString(13, fornecedor.getEndereco().getNumero());
			preparedStatement.setString(14, fornecedor.getEndereco().getComplemento());
			preparedStatement.setString(15, fornecedor.getEndereco().getUf());
			preparedStatement.setString(16, fornecedor.getEndereco().getCidade());
			preparedStatement.execute();
		} catch (SQLException exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
		}
	}

	public List<Fornecedor> findAll() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				fornecedor = new Fornecedor();
				fornecedor.getEndereco().setCep(resultSet.getString("codigo_postal"));
				fornecedor.getEndereco().setTipo(resultSet.getString("tipo_endereco"));
				//fornecedor.setAbrangencia(resultSet.getLong("abrangencia"));
				fornecedor.getEndereco().setComplemento(resultSet.getString("complemento"));
				fornecedor.setFornecedor(resultSet.getString("fornecedor"));
				fornecedor.getEndereco().setLogradouro(resultSet.getString("logradouro"));
				fornecedor.getTelefone().setTipo(resultSet.getString("tipo_fone"));
				fornecedor.getTelefone().setTelefone(resultSet.getString("telefone"));
				fornecedor.getEndereco().setQuadra(resultSet.getString("quadra"));
				fornecedor.getEndereco().setNumero(resultSet.getString("numero"));
				fornecedor.getEndereco().setCidade(resultSet.getString("cidade"));
				fornecedor.getEndereco().setBloco(resultSet.getString("bloco"));
				fornecedor.getEndereco().setLote(resultSet.getString("lote"));
				fornecedor.getEndereco().setUf(resultSet.getString("uf"));
				fornecedor.getEndereco().setRua(resultSet.getString("rua"));
				fornecedor.getTelefone().setDDD(resultSet.getString("ddd"));
				//fornecedor.setId(resultSet.getLong("codigo"));
				fornecedores.add(fornecedor);
			}
		} catch (SQLException SQLexception) {
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(SQLexception);
		}finally {
			JDBConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return fornecedores;
	}
	
	@SuppressWarnings("finally")
	public Fornecedor findById(Long codigo) throws Exception {
		try {
			preparedStatement = connection.prepareStatement(SELECT + WHERE_BY_PK);
			preparedStatement.setLong(1, codigo);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				fornecedor = new Fornecedor();
				fornecedor.getEndereco().setCep(resultSet.getString("codigo_postal"));
				fornecedor.getEndereco().setTipo(resultSet.getString("tipo_endereco"));
				//fornecedor.setAbrangencia(resultSet.getLong("abrangencia"));
				fornecedor.getEndereco().setComplemento(resultSet.getString("complemento"));
				fornecedor.setFornecedor(resultSet.getString("fornecedor"));
				fornecedor.getEndereco().setLogradouro(resultSet.getString("logradouro"));
				fornecedor.getTelefone().setTipo(resultSet.getString("tipo_fone"));
				fornecedor.getTelefone().setTelefone(resultSet.getString("telefone"));
				fornecedor.getEndereco().setQuadra(resultSet.getString("quadra"));
				fornecedor.getEndereco().setNumero(resultSet.getString("numero"));
				fornecedor.getEndereco().setCidade(resultSet.getString("cidade"));
				fornecedor.getEndereco().setBloco(resultSet.getString("bloco"));
				fornecedor.getEndereco().setLote(resultSet.getString("lote"));
				fornecedor.getEndereco().setUf(resultSet.getString("uf"));
				fornecedor.getEndereco().setRua(resultSet.getString("rua"));
				fornecedor.getTelefone().setDDD(resultSet.getString("ddd"));
				//fornecedor.setId(resultSet.getLong("codigo"));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			JDBConnectionUtil.rollback(connection);
			throw new RuntimeException(exception);
		} finally {
			JDBConnectionUtil.close(connection, preparedStatement);
			return fornecedor;
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
