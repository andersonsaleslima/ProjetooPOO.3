package controller;

import java.io.Serializable;

/**
 * Classe motocicleta, contém informações relativas à motocicleta, 
 * herdando os atributos da classe Veiculo.
 * 
 * @author SHOW13
 *
 */

public class Motocicleta extends Veiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String estilo;

	
	
	/**
	 * 
	 */
	public Motocicleta() {
		super();
	}

	public Motocicleta(Placa placa, boolean disponibilidade, String marca, String modelo, double precoPorHra,
			String estilo) {
		super(placa, disponibilidade, marca, modelo, precoPorHra);
		this.estilo = estilo;
	}
	
	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((estilo == null) ? 0 : estilo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motocicleta other = (Motocicleta) obj;
		if (estilo == null) {
			if (other.estilo != null)
				return false;
		} else if (!estilo.equals(other.estilo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nMotocicleta [estilo=" + estilo + ", Placa=" + getPlaca() + ", Disponibilidade="
				+ isDisponibilidade() + ", Marca=" + getMarca() + ", getModelo=" + getModelo()
				+ ", getPrecoPorHra=" + getPrecoPorHra() + "]\n";
	}
	
	
	

}
