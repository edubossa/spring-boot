package br.com.ews.model;

public class User {

	private String nome;
	private String sobrenome;
	private String acessToken;
	private String urlNotificacao;
	private String urlEnvio;

	public User() {
		super();
	}

	public User(String nome, String sobrenome, String acessToken, String urlNotificacao, String urlEnvio) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.acessToken = acessToken;
		this.urlNotificacao = urlNotificacao;
		this.urlEnvio = urlEnvio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getAcessToken() {
		return acessToken;
	}

	public void setAcessToken(String acessToken) {
		this.acessToken = acessToken;
	}

	public String getUrlNotificacao() {
		return urlNotificacao;
	}

	public void setUrlNotificacao(String urlNotificacao) {
		this.urlNotificacao = urlNotificacao;
	}

	public String getUrlEnvio() {
		return urlEnvio;
	}

	public void setUrlEnvio(String urlEnvio) {
		this.urlEnvio = urlEnvio;
	}

}
