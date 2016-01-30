package br.com.ews.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.ews.repository.BoletoRepository;


@Component
public class BoletoListener {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoletoRepository repository;

	@JmsListener(destination = "queueBoleto", concurrency = "30-50")
	public void message(String xml) {
		logger.info("Mensagem recebida: " + xml);
		repository.imprimeUsuarios();
	}
	
}