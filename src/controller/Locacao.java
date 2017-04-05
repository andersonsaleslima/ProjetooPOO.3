package controller;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;


/**
 * Classe Locacao, contém informações relativas à locação feita. 
 * 
 * @author SHOW13
 *
 */



import java.time.LocalDateTime;
import java.time.Period;
public class Locacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private LocalDateTime dataRetirada;
	private LocalDateTime dataDevolucao;
	private Pessoa pessoa;
	private Veiculo veiculo;
	
		
	
	/**
	 * 
	 */
	public Locacao() {
		
		super();
		
	}
	
	public Locacao(LocalDateTime dataRetirada, LocalDateTime dataDevolucao, Pessoa pessoa, Veiculo veiculo) {
		this.dataRetirada = dataRetirada;
		this.dataDevolucao = dataDevolucao;
		this.pessoa = pessoa;
		this.veiculo = veiculo;
	}
	/**
	 * Calcula Valor da Locação
	 */
/*	public  double calcValorLoc(){
				
		Period p=Period.between(dataRetirada,dataDevolucao);
		
		return veiculo.getPrecoPorHra()*p.getDays();
	}*/
	/**
	 * Calcula Valor da Locação
	 */
	public  double calcValorLoc(){
				
		//Period p=Period.between(dataRetirada,dataDevolucao);
		Duration testeDuration = Duration.between(dataRetirada,dataDevolucao);
		   int p = (int) testeDuration.toHours();
		
		return veiculo.getPrecoPorHra()*p;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public LocalDateTime getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(LocalDateTime dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDevolucao == null) ? 0 : dataDevolucao.hashCode());
		result = prime * result + ((dataRetirada == null) ? 0 : dataRetirada.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
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
		Locacao other = (Locacao) obj;
		if (dataDevolucao == null) {
			if (other.dataDevolucao != null)
				return false;
		} else if (!dataDevolucao.equals(other.dataDevolucao))
			return false;
		if (dataRetirada == null) {
			if (other.dataRetirada != null)
				return false;
		} else if (!dataRetirada.equals(other.dataRetirada))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "\nLocacao [dataRetirada=" + dataRetirada + ", dataDevolucao=" + dataDevolucao + ", pessoa[nome=" + pessoa.getNome()+ 
				", CPF=" + pessoa.getCpf() + ", Veiculo=" + veiculo.toString() + " Id da Locação: "+this.id+
				" Valor Da Locacao: "+calcValorLoc()+ "]\n";
	}
	
	
	

}
