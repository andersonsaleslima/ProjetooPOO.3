package controller;

import java.io.Serializable;
import java.util.ArrayList;
import dao.ControllerDao;
import dao.Idao;
import net.*;

/**
 * Classe ColecaoLocacao, contém os métodos para criar e 
 * manipular uma coleção de classes do tipo Locacao.
 * 
 * @author SHOW13
 *
 */

public class ColecaoLocacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Locacao> locacoes;
	private INetClient iNet = new ControllerNetClient();
	private Idao id=new ControllerDao();
	private static String localizacao = new String("locacoes.obj");

	public ColecaoLocacao() {

		this.locacoes = new ArrayList<Locacao>();
		/*if(id.verificarArquivo(localizacao)){
			carregarArqDeLocacoes();
		}*/
	}
	
	/**
	 * método utilizado para acessar servidor de arquivos e carregar as 
	 * informações contidas no arquivo "locacoes.obj" para o sistema. 
	 * Retorna boolean, em caso sucesso true, e em caso de falha exibe 
	 * mensagem e retorna false.
	 * @return
	 * @throws Exception
	 */
	public boolean carregarArqDeLocacoes()throws Exception{
		
		try{
			Object obj = (Object) iNet.receberObject(localizacao);
			if(obj!=null){
				this.locacoes = (ArrayList<Locacao>) obj;
				System.out.println(this.locacoes.toString());
				return true;
			}else{
				return false;
			}
			
			/*if(id.verificarArquivo(localizacao)){
				this.locacoes = (ArrayList<Locacao>) id.carregarArq(localizacao);
			//	System.out.println(this.pessoas.toString());
				if(this.locacoes!=null){
					return true;
				}	
			}*/
		}catch(Exception e){
	//		System.err.println("erro ao carregar arquivo");
		}
		return false;
	}
	
	/**
	 * método utilizado para salvar a coleção de veículos no arquivo 
	 * "locacoes.obj" contido no servidor. 
	 * @return
	 * @throws Exception
	 */
	public boolean salvarArqDeLocacoes()throws Exception{
		try{
			iNet.enviarObject(this.locacoes, localizacao);
			return true;
		}catch(Exception e){
			
		}
		return false;
	}

	/**
	 * método utilizado para adicionar locacoes a coleção, passando como parâmetro 
	 * um objeto do tipo Veiculo, e retornando true em caso de êxito ou false 
	 * em caso erro.
	 * @param locacao
	 * @return
	 * @throws Exception
	 */
	public boolean addLocacao(Locacao locacao)throws Exception{
		
		try{
			if (!locacoes.contains(locacao)){
				int i = locacoes.size();
				i++;
				locacao.setId(i);
				locacoes.add(locacao);
			//	iNet.enviarObject(this.locacoes, localizacao);
			//	id.salvarEmArq(this.locacoes, localizacao);
				return true;
			}
		}catch(Exception e){
			System.err.println("erro ao adicionar locacao");
		}
		return false;
		
	}
	
	/**
	 * método utilizado para remover locações da coleção, passando como parâmetro um tipo int 
	 * relativo ao número do identificador(id) da locação a ser removida, e retornando true 
	 * em caso de êxito ou false em caso erro.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean removerLocacao(int id)throws Exception{

		try{
			for (Locacao locacao : this.locacoes) {
				if (locacao.getId()==id){
					locacoes.remove(locacao);
				//	this.iNet.enviarObject(this.locacoes, localizacao);
				//	this.id.salvarEmArq(this.locacoes, localizacao);
					return true;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("erro ao remover locacao - ColecacaoLocacao");
		}
		return false;

	}
	
	
	/**
	 * método utilizado para listar locações da coleção, retornando o objeto ArrayList
	 * de todas os locações adicionadas na coleção em caso de êxito ou uma mensagem 
	 * de erro em caso de erro.
	 * @return
	 */
	public ArrayList<Locacao> listarLocacoes(){
		
		return this.locacoes;
			
	}
	/*
	public boolean devolverLocacao(){
		return true;
	}*/
/*	
 * Verificar necessidade
 * 
 * 
	public Locacao editarLocacao(int id){
		
		for (Locacao locacao : locacoes) {
			if (locacao.getId()==id){
				return locacao;
			}

		}
		return null;
		
		
	}
	*/
	
}
