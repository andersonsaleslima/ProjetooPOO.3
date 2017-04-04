package controller;

import java.io.Serializable;

/**
 * 
 * Classe Veiculo, contém informações relativas ao veiculo.
 * 
 * @author SHOW13
 *
 */

public abstract class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Placa placa;
	private boolean disponibilidade;
	private String marca;
	private String modelo;
	private double precoPorHra;




	/**
	 * 
	 */
	public Veiculo() {
		super();
	}


	public Veiculo(Placa placa, boolean disponibilidade, String marca, String modelo, double precoPorHra) {
		super();
		this.placa = placa;
		this.disponibilidade = disponibilidade;
		this.marca = marca;
		this.modelo = modelo;
		this.precoPorHra = precoPorHra;
	}

	public Placa getPlaca() {
		return placa;
	}
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getPrecoPorHra() {
		return precoPorHra;
	}
	public void setPrecoPorHra(double precoPorHra) {
		this.precoPorHra = precoPorHra;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (disponibilidade ? 1231 : 1237);
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precoPorHra);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Veiculo other = (Veiculo) obj;
		if (disponibilidade != other.disponibilidade)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (Double.doubleToLongBits(precoPorHra) != Double.doubleToLongBits(other.precoPorHra))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nVeiculo [placa=" + placa +  "Disponilidade=" +disponibilidade+", marca=" + marca + ", modelo="
				+ modelo + ", precoPorHra=" + precoPorHra + "]";
	}


}
