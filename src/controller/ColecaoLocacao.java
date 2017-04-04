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

	public boolean addLocacao(Locacao locacao)throws Exception{
		
		try{
			if (!locacoes.contains(locacao)){
				locacoes.add(locacao);
				iNet.enviarObject(this.locacoes, localizacao);
			//	id.salvarEmArq(this.locacoes, localizacao);
				return true;
			}
		}catch(Exception e){
			System.err.println("erro ao adicionar locacao");
		}
		return false;
		
	}

	public boolean removerLocacao(int id)throws Exception{

		try{
			for (Locacao locacao : locacoes) {
				if (locacao.getId()==id){
					locacoes.remove(id);
					this.iNet.enviarObject(this.locacoes, localizacao);
				//	this.id.salvarEmArq(this.locacoes, localizacao);
					return true;
				}
			}
			
		}catch(Exception e){
			System.err.println("erro ao remover locacao");
		}
		return false;

	}
	
	
	
	public ArrayList<Locacao> listarLocacoes(){
		
		return this.locacoes;
			
	}
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
