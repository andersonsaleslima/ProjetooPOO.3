package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import dao.ControllerDao;
import dao.Idao;
import net.*;

/**
 * Classe ColecaoPessoa, cont�m os m�todos para criar e 
 * manipular uma cole��o de classes do tipo Pessoa.
 * 
 * @author SHOW13
 *
 */

public class ColecaoPessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private INetClient iNet = new ControllerNetClient();
	private Idao id=new ControllerDao();
	private static String localizacao = new String("pessoas.obj");
	
	private ArrayList<Pessoa> pessoas; /*= id.carregarArq("bd.dat");*/
	
	public ColecaoPessoa(ArrayList<Pessoa> pessoas){
		this.pessoas = pessoas;
	}

	public ColecaoPessoa(){
		this.pessoas = new ArrayList<Pessoa>();
	}

	
/*	public void recuperarArquivo() throws IOException, ClassNotFoundException{
		try{
			FileInputStream file = new FileInputStream(localizacao); 
			ObjectInputStream stream = new ObjectInputStream(file);
			ArrayList<Pessoa> readObject = (ArrayList<Pessoa>) stream.readObject();
			this.pessoas = readObject;
			stream.close();
		}catch(IOException io){
			System.err.println("erro ao obter arquivo");
		}
	}*/
	
	/**
	 * M�todo utilizado para acessar servidor de arquivos e carregar as 
	 * informa��es contidas no arquivo "pessoas.obj" para o sistema. 
	 * Retorna boolean, em caso sucesso true, e em caso de falha 
	 * exibe mensagem e retorna false.
	 * @return
	 * @throws Exception
	 */

	public boolean carregarArqDePessoas()throws Exception{
		
		try{
			Object obj = (Object) iNet.receberObject(localizacao);
			if(obj!=null){
				this.pessoas = (ArrayList<Pessoa>) obj;
				System.out.println(this.pessoas.toString());
				return true;
			}else{
				return false;
			}

		/*	Object obj = (Object) id.carregarArq(localizacao);
			if(obj==null){
		//		System.out.println("objeto nulo");
				return false;
			}else{
				this.pessoas = (ArrayList<Pessoa>) obj;
			//	System.out.println(this.pessoas.toString());
					return true;
			}*/

		//	}
		}catch(Exception e){
		//	e.printStackTrace();
		//	System.err.println("erro ao carregar arquivo - Colecao Pessoa");
		}
		return false;
	}
	
	/**
	 * M�todo utilizado para salvar a cole��o de pessoas no 
	 * arquivo "pessoas.obj" contido no servidor.
	 * @return
	 * @throws Exception
	 */
	
	public boolean salvarArqDePessoas()throws Exception{
		try{
			iNet.enviarObject(this.pessoas, localizacao);
			return true;
		}catch(Exception e){
			
		}
		return false;
	}
	
	/**
	 * M�todo utilizado para adicionar pessoas a cole��o, passando 
	 * como par�metro um objeto do tipo Pessoa, e retornando true 
	 * em caso de �xito ou false em caso erro.
	 * @param p
	 * @return
	 * @throws Exception
	 */
	
	public boolean addPessoa(Pessoa p)throws Exception{
		if(!pessoas.contains(p)){
			pessoas.add(p);
			try {
				iNet.enviarObject(this.pessoas, localizacao);
			//	id.salvarEmArq(this.pessoas,localizacao);
				return true;

			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			/**
			 * 		Colocar um m�todo para salvar no aquivo passando a cale��o como paramentro
			 */
		}
		return false;
	}

	/**
	 * m�todo utilizado para listar pessoas da cole��o, retornando o objeto ArrayList 
	 * de todas as pessoas adicionadas na cole��o em caso de �xito ou uma mensagem de 
	 * erro em caso de erro.
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pessoa> listarPessoa()throws Exception{
		try{
		//	if(!pessoas.isEmpty()){
		//		this.pessoas = (ArrayList<Pessoa>) id.carregarArq(localizacao);
				return this.pessoas;
		//	}
		}catch(Exception e){
			System.err.println("erro ao listar pessoas");
		}
		return null;
	}

	/**
	 * m�todo utilizado para listar Clientes da cole��o, retornando um objeto ArrayList 
	 * de todos os clientes  adicionados na cole��o em caso de �xito ou uma mensagem de 
	 * erro em caso de erro.
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Cliente> listarClientes()throws Exception{
	
		try{
			ArrayList<Cliente> clientes=new ArrayList<Cliente>();

			for (Pessoa pessoa : this.pessoas) {
				if(pessoa instanceof Cliente){
					clientes.add((Cliente) pessoa);
				}
			}
			return clientes;
		}catch(Exception e){
			System.err.println("erro ao listar clientes");
		}
		return null;
	}
	
	/**
	 *  m�todo utilizado para listar Funcionarios da cole��o, retornando o um objeto ArrayList 
	 *  de todas os funcion�rios adicionados na cole��o em caso de �xito ou uma mensagem de 
	 *  erro em caso de erro.
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Funcionario> listarFuncionarios()throws Exception{
		
		try{
			ArrayList<Funcionario> func =new ArrayList<Funcionario>();

			for (Pessoa pessoa : this.pessoas) {

				if(pessoa instanceof Funcionario){
					func.add((Funcionario) pessoa);
				}
			}
			return func;
		}catch(Exception e){
			System.err.println("erro ao listar funcionarios");
		}
		return null;

	}
	/*
	public Pessoa pesquisarPessoaPeloCPF(String cpf)throws Exception {
		try{

			for (Pessoa p : this.pessoas){

				if( p.getCpf().equals(cpf)){
					return p;
				}
			}
		}catch(Exception e){
			System.err.println("Erro ao pesquisar pessoa");
		}
		return null;

	} 
*/
/*	public Pessoa pesquisarClientePeloCNH(String cnh)throws Exception {
		try{

			for (Pessoa p : this.pessoas){

				if(p instanceof Cliente){
					Cliente client = (Cliente) p;
					if( client.getCnh().equals(cnh)){
						return p;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Erro ao pesquisar Cliente pela cnh");
		}
		return null;

	} */
	
	/**
	 * m�todo utilizado para remover pessoas da cole��o, passando como 
	 * par�metro um tipo String relativo ao cpf da pessoa a ser 
	 * removidas, e retornando true em caso de �xito ou false em caso erro.
	 * @param cpf
	 * @return
	 * @throws Exception
	 */
	
	public boolean removerPessoa(String cpf) throws Exception{

		for (Pessoa pessoa : pessoas) {
			if(pessoa.getCpf().equals(cpf)){

					pessoas.remove(pessoa);

					try {
						iNet.enviarObject(this.pessoas, localizacao);
				//		id.salvarEmArq(this.pessoas,localizacao);
						return true;
					} catch (Exception e) {
						// TODO: handle exception
					}
			
			}
		}
		return false;

	}
	

}
