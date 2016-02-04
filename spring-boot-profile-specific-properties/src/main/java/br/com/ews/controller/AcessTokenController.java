package br.com.ews.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ews.model.User;

@RestController
public class AcessTokenController {
	
	@Value("${url.notificacao}")
	private String urlNotificacao;
	
	@Value("${url.envio}")
	private String urlEnvio;
	
	@Value("${acess.token}")
	private String acessToken;
	
	@RequestMapping(
			value = "/acess",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser() {
		
		User user = new User("Eduardo", "Wallace", acessToken, urlNotificacao, urlEnvio);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
