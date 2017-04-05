package controller;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import dao.ControllerDao;
import dao.Idao;
import net.*;

/**
 * Classe ColecaoVeiculo, contém os métodos para criar e 
 * manipular uma coleção de classes do tipo Veiculo.
 * 
 * @author SHOW13
 *
 */

public class ColecaoVeiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Veiculo> veiculos;
	private INetClient iNet = new ControllerNetClient();
	private Idao id=new ControllerDao();

	
	private static String localizacao = new String("veiculos.obj");
	
	/*
	stream = id.recuparArq(this.veiculo,"veiculos.txt");
	(ArrayList<Veiculo>)stream;
	*/
	
	public ColecaoVeiculo(ArrayList<Veiculo> veiculo) {
		this.veiculos = veiculo;
	//	id.salvarEmArq(this.veiculos, localizacao);
	}

	public ColecaoVeiculo() {	 	
		this.veiculos = new ArrayList<Veiculo>();
	}
	
	/**
	 * Método utilizado para acessar servidor de arquivos e carregar as informações 
	 * contidas no arquivo "veiculos.obj" para o sistema. Retorna boolean, em caso 
	 * sucesso true, e em caso de falha exibe mensagem e retorna false.
	 * @return
	 * @throws Exception
	 */
	public boolean carregarArqDeVeiculos()throws Exception{
		
		try{
			Object obj = (Object) iNet.receberObject(localizacao);
			if(obj!=null){
				this.veiculos = (ArrayList<Veiculo>) obj;
				System.out.println(this.veiculos.toString());
				return true;
			}else{
				return false;
			}
			
			
			/*if(id.verificarArquivo(localizacao)){
				this.veiculos = (ArrayList<Veiculo>) id.carregarArq(localizacao);
			//	System.out.println(this.pessoas.toString());
				if(this.veiculos!=null){
					return true;
				}
			}*/
		}catch(Exception e){
	//		System.err.println("erro ao carregar arquivo");
		}
		return false;
	}
	
	/**
	 * Método utilizado para salvar a coleção de veículos no arquivo "veiculos.obj" 
	 * contido no servidor.
	 * @return
	 */
	public boolean salvarArqDeVeiculos(){
		try{
			iNet.enviarObject(this.veiculos, localizacao);
			return true;
		}catch(Exception e){
			
		}
		return false;
	}

	/**
	 * método utilizado para adicionar veiculos a coleção, passando como parâmetro 
	 * um objeto do tipo Veiculo, e retornando true em caso de êxito ou false em 
	 * caso de erro.
	 * @param v
	 * @return
	 * @throws Exception
	 */
	public boolean addVeiculo(Veiculo v)throws Exception{
		try{
			if(!veiculos.contains(v)){
				veiculos.add(v);
			//	id.salvarEmArq(this.veiculos, localizacao);
				iNet.enviarObject(this.veiculos, localizacao);
				return true;
			}
		}catch(Exception e){
			System.err.println("erro ao adionar veiculo");
		}
		return false;
		
	}
	
	/**
	 * método utilizado para listar veículos da coleção, retornando o objeto ArrayList 
	 * de todas os veículos adicionados na coleção em caso de êxito ou uma mensagem de 
	 * erro em caso de erro.
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Veiculo> listarVeiculos()throws Exception{
		try{
			//if(!this.veiculos.isEmpty()){
				return this.veiculos;
			//}
		}catch(Exception e){
			System.err.println("erro ao listar veiculos");
		}
			return null;
	}
	
	/**
	 * método utilizado para listar veículos com o atributo disponibilidade válido como
	 * true da coleção, retornando o objeto ArrayList de todas os veículos adicionados 
	 * na coleção em caso de êxito ou uma mensagem de erro em caso de erro.
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Veiculo> listarVeiculosDisponiveis()throws Exception {
		try{
			ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

			for (Veiculo v : this.veiculos){

				if( v.isDisponibilidade()){
					veiculos.add(v);
				}
			}
			return veiculos;
		}catch(Exception e){
			System.err.println("erro ao listar veiculos disponiveis");
		}
		return null;

	} 

	/**
	 * método utilizado para listar automóveis da coleção, retornando o objeto 
	 * ArrayList de todas os automóveis adicionados na coleção em caso de 
	 * êxito ou uma mensagem de erro em caso de erro.
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Automovel> listarAutomoveis()throws Exception {
		try{
			ArrayList<Automovel> automovel = new ArrayList<Automovel>();

			for (Veiculo veiculo : this.veiculos){

				if( veiculo instanceof Automovel){
					automovel.add((Automovel) veiculo);
				}
			}
			return automovel;
		}catch(Exception e){
			System.err.println("erro ao listar automoveis");
		}
		return null;

	} 

	/**
	 * método utilizado para listar motocicletas da coleção, retornando o objeto 
	 * ArrayList de todas as motocicletas adicionados na coleção em caso de 
	 * êxito ou uma mensagem de erro em caso de erro.
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Motocicleta> listarMotocicleta()throws Exception {
		try{
			ArrayList<Motocicleta> motocicleta = new ArrayList<Motocicleta>();

			for (Veiculo veiculo : this.veiculos){

				if( veiculo instanceof Motocicleta){
					motocicleta.add((Motocicleta) veiculo);
				}
			}
			return motocicleta;
		}catch(Exception e){
			System.err.println("erro ao listar motocicletas");
		}
		return null;

	}
	

/*	public Veiculo pesquisarVeiculo(String placa)throws Exception{
		try{
			for(Veiculo v : this.veiculos){
				if(v.getPlaca().getNumerosEletras().equalsIgnoreCase(placa)){
					return v;
				}
			}
			return null;
		}catch(Exception e){
			System.err.println("erro ao pesquisar veículo");
		}
		return null;
	}*/
	
	
	/**
	 * método utilizado para remover veículos da coleção, passando como parâmetro um 
	 * tipo String relativo ao número da placa dos veículos a serem removidos, e 
	 * retornando true em caso de êxito ou false em caso de erro.
	 * @param placa
	 * @return
	 * @throws Exception
	 */
	public boolean removerVeiculo(String placa) throws Exception{
		try{
		//	Idao id;
			//ObjectInputStream stream;
			
			for (Veiculo v : this.veiculos) {
				if(v.getPlaca().getNumerosEletras().equalsIgnoreCase(placa)){
					this.veiculos.remove(v);
					iNet.enviarObject(this.veiculos, localizacao);
				//	id.salvarEmArq(this.veiculos,localizacao);
					return true;
				}
			}

		}catch(Exception e){
			System.err.println("erro ao remover veiculo");
		}
		
		/*
		id.salvarEmrArq(this.veiculo,"veiculos.txt");
		*/
		return false;
	}
	

}
