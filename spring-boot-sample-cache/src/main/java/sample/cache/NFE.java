package sample.cache;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class NFE implements Serializable {

	private long numero;
	private String descricao;
	private Date dataEmissao;

	public NFE() {}

	public NFE(long numero, String descricao, Date dataEmissao) {
		this.numero = numero;
		this.descricao = descricao;
		this.dataEmissao = dataEmissao;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (numero ^ (numero >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NFE other = (NFE) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NFE [numero=" + numero + ", descricao=" + descricao + ", dataEmissao=" + dataEmissao + "]";
	}

}