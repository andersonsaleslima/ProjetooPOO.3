package controller;

import java.io.Serializable;

/**
 * Classe Placa, contém informações relativas à placa de algum veiculo.
 * 
 * @author SHOW13
 *
 */


public class Placa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String estado;
	private String cidade;
	private String NumerosEletras;
	
	
	
	
	/**
	 * 
	 */
	public Placa() {
		super();
	}

	public Placa(String estado, String cidade, String numerosEletras) {
		
		this.estado = estado;
		this.cidade = cidade;
		NumerosEletras = numerosEletras;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getNumerosEletras() {
		return NumerosEletras;
	}
	public void setNumerosEletras(String numerosEletras) {
		NumerosEletras = numerosEletras;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NumerosEletras == null) ? 0 : NumerosEletras.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		Placa other = (Placa) obj;
		if (NumerosEletras == null) {
			if (other.NumerosEletras != null)
				return false;
		} else if (!NumerosEletras.equals(other.NumerosEletras))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Placa [estado=" + estado + ", cidade=" + cidade + ", NumerosEletras=" + NumerosEletras + "]";
	}
	
	
	
	

}
