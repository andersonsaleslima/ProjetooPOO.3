package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implementa os métodos da interface IController;
 * 
 * @author SHOW13
 *
 */

public class Controller implements Icontroller, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ColecaoPessoa cp=new ColecaoPessoa();
	private	ColecaoLocacao cl=new ColecaoLocacao();
	private	ColecaoVeiculo cv=new ColecaoVeiculo();

	/******************Pessoa
	 * @throws Exception ***************

	 **/
	
	public boolean init() throws Exception{
		try{
			if((cp.carregarArqDePessoas())&& (cv.carregarArqDeVeiculos()) && (cl.carregarArqDeLocacoes())){
				return true;
			}
		}catch(Exception e){
			System.err.println("erro ao inicializar carregamento de arquivos");
		}
		return false;
		
	}
	
	public boolean salvarAlteracoes() throws Exception{
		try{
			if((cp.salvarArqDePessoas())&& (cv.salvarArqDeVeiculos())&&(cl.salvarArqDeLocacoes())){
				return true;
			}
		}catch (Exception e){
			System.err.println("erro ao salvar arquivos");
		}
		return false;
		
	}
	
	@Override
	public boolean addPessoa(Pessoa p) throws Exception {

		cp.addPessoa(p);
		return true;
	}

	@Override
	public ArrayList<Pessoa> listarPessoa() throws Exception{

		return cp.listarPessoa();
	}

	@Override
	public ArrayList<Cliente> listarCliente() throws Exception{

		return cp.listarClientes();

	}

	@Override
	public ArrayList<Funcionario> listarFuncionario() throws Exception{
		// TODO Auto-generated method stub
		return cp.listarFuncionarios();
	}

	@Override
	public Pessoa pesquisarPessoaPeloCPF(String cpf) throws Exception{
		try{

			for (Pessoa p : cp.listarPessoa()){

				if( p.getCpf().equals(cpf)){
					return p;
				}
			}
		}catch(Exception e){
			System.err.println("Erro ao pesquisar pessoa");
		}
		return null;


	}

	@Override
	public boolean removerPessoa(String cpf) throws Exception{

		cp.removerPessoa(cpf);

		return true;
	}

	/********************Veiculo***************************/
	@Override
	public boolean addVeiculo(Veiculo v) throws Exception{

		cv.addVeiculo(v);

		return true;

	}

	@Override
	public ArrayList<Veiculo> listarVeiculos() throws Exception{



		return cv.listarVeiculos();
	}

	@Override
	public ArrayList<Veiculo> listarVeiculosDisponiveis() throws Exception{


		return cv.listarVeiculosDisponiveis();
	}

	@Override
	public ArrayList<Automovel> listarAutomoveis() throws Exception{

		return cv.listarAutomoveis();
	}

	@Override
	public ArrayList<Motocicleta> listarMotocicletas() throws Exception{
		// TODO Auto-generated method stub
		return cv.listarMotocicleta();
	}

	@Override
	public Veiculo pesquisarVeiculo(String placa) throws Exception{

		try{

			for (Veiculo v : cv.listarVeiculos()){

				if( v.getPlaca().getNumerosEletras().equals(placa)){
					return v;
				}
			}
		}catch(Exception e){
			System.err.println("erro ao pesquisar veiculos");
		}
		return null;
	}

	@Override
	public boolean removerVeiculo(String placa) throws Exception{

		cv.removerVeiculo(placa);
		return true;
	}

	/************************Locacao*********************/
	@Override
	public boolean realizarLocacao(Locacao l) throws Exception{

		cl.addLocacao(l);

		return true;
	}

	@Override
	public ArrayList<Locacao> listarLocacoes() throws Exception{
		return cl.listarLocacoes();
	}

	@Override
	public Locacao pesquisarLocPorPessoa(String cpf) throws Exception{
		try{
			for (Locacao loc : cl.listarLocacoes()) {
				if(loc.getPessoa().getCpf().equals(cpf)){
					return loc;
				}

			}
		}catch(Exception e){
			System.err.println("erro ao pesquisar locacao");
		}

		return null;
	}

	@Override
	public Locacao pesquisarLocPorVeiculo(String placa) throws Exception{
		try{
			for (Locacao loc : cl.listarLocacoes()) {
				if(loc.getVeiculo().getPlaca().equals(placa)){
					return loc;
				}

			}
		}catch(Exception e){
			System.err.println("erro ao pesquisar locacao");
		}
		return null;
	}

	@Override
	public Locacao pesquisarLocacao(int id)throws Exception{
		try{
			for (Locacao locacao : cl.listarLocacoes()) {
				if (locacao.getId()==id){
					return locacao;
				}
			}
		}catch(Exception e){
			System.err.println("erro ao pesquisar locacao");
		}
		return null;
	}

	@Override
	public boolean removerLocacao(int id) throws Exception{
		try{
			Locacao locacao = pesquisarLocacao(id);
			pesquisarVeiculo(locacao.getVeiculo().getPlaca().getNumerosEletras()).setDisponibilidade(true);
			cl.removerLocacao(id);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("erro ao remover locacao - Controller");
		}
		return false;
	}



}
