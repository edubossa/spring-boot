package br.com.ews.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Fornecedor implements RowMapper<Fornecedor> {

	private Integer idFornecedor;
	private Integer numBanco;
	private String nomeFornecedor;

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public Integer getNumBanco() {
		return numBanco;
	}

	public void setNumBanco(Integer numBanco) {
		this.numBanco = numBanco;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	
	
	@Override
	public String toString() {
		return "Fornecedor [idFornecedor=" + idFornecedor + ", numBanco=" + numBanco + ", nomeFornecedor="
				+ nomeFornecedor + "]";
	}

	@Override
	public Fornecedor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setIdFornecedor(rs.getInt("ID_FORNECEDOR"));
		fornecedor.setNumBanco(rs.getInt("NUM_BANCO"));
		fornecedor.setNomeFornecedor(rs.getString("NOME_FORNECEDOR"));
		return fornecedor;
	}

}
