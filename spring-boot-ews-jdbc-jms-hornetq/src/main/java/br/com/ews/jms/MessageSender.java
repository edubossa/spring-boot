package br.com.ews.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@Scheduled(fixedDelay = 1000*5)
	public void send() {
		logger.info("<<< Send Message JMS Horneqt - Fila: queueBoleto >>>");
		this.jmsTemplate.convertAndSend("queueBoleto", "Send Message JMS Horneqt");
	}

}
