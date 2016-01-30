package br.com.ews.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.ews.model.Fornecedor;

//http://www.mkyong.com/spring/spring-jdbctemplate-querying-examples/
@Repository
public class BoletoRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Fornecedor> imprimeUsuarios() {
		String SQL = "SELECT * FROM TB_FORNECEDOR";
		List<Fornecedor> fornecedores = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<Fornecedor>(Fornecedor.class));
		logger.warn("lista fornecedores - size: " + fornecedores.size());
		return fornecedores;
	}
	
}
