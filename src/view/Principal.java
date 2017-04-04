package view;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;


import controller.*;


/**
 * Cotenterá a classe Principal, onde possuirá o método main. 
 * Metodos adicionais forão utilizados para interação com o usuário.
 * 
 * 
 * @author SHOW13
 *
 */

public class Principal implements Serializable{

	private static Icontroller ic= new Controller();
	/*private static ColecaoPessoa pessoa = new ColecaoPessoa();
	private static ColecaoVeiculo veiculo = new ColecaoVeiculo();*/
	private static ColecaoLocacao locacao = new ColecaoLocacao();

	public static void main(String[] args) throws Exception {

		int op = 0, i=0;
		Scanner sc = new Scanner(System.in);
		String str = new String();
		Endereco endereco = new Endereco();

		/*do{
			System.out.println("Menu ");
			System.out.println("0- Sair");
			System.out.println("1- Adicionar Pessoa");
			System.out.println("2- Listar Pessoal");
			System.out.println("3- Listar Clientes");

		}while(op!=0);*/

		if(!ic.init()){
			System.out.println("Arquivo não foi carregado");
		}

		do{/*
			System.out.println("Menu ");
			System.out.println("0- Sair");

			System.out.println("\nPessoa:");
			System.out.println("1- Adicionar Pessoa");
			System.out.println("2- Listar Pessoal");
			System.out.println("3- Listar Clientes");
			System.out.println("4- Listar Funcionarios");
			System.out.println("5- Pesquisar Pessoa");
			System.out.println("6- Remover Pessoa");

			System.out.println("\nVeiculo:");
			System.out.println("7- Adicionar Veiculo");
			System.out.println("8- Listar Veiculos");
			System.out.println("9- Listar Veiculos Disponiveis");
			System.out.println("10- Listar Automoveis");
			System.out.println("11- Listar Motocicletas");
			System.out.println("12- Procurar Veiculo");
			System.out.println("13- Remover Veiculo");

			System.out.println("\nLocacao:");
			System.out.println("14- Adiconar Locacao");
			System.out.println("15- Listar Locacoes");
			System.out.println("16- Procurar Locacao por ID");
			System.out.println("17- Procurar Locacao por Pessoa");
			System.out.println("18- Procurar Locacao por veiculo");
			System.out.println("19- Remover Locacao");
		 */
			System.out.println("___________________________________________________________________________________________________\n"
					+"|                                       Menu                                                      |");
			System.out.println("|\n| Pessoa:                        Veiculo:                        Locacao:                         |\n|                                                                                                 |\n|"
					+" 1- Adicionar Pessoa            7- Adicionar Veiculo             14- Adiconar Locacao            |\n|"                                   
					+" 2- Listar Pessoal              8- Listar Veiculos               15- Listar Locacoes             |\n|"
					+" 3- Listar Clientes             9- Listar Veiculos Disponiveis   16- Procurar Locacao por ID     |\n|"
					+" 4- Listar Funcionarios         10-Listar Automoveis             17- Procurar Locacao por Pessoa |\n|"
					+" 5- Pesquisar Pessoa            11-Listar Motocicletas           18- Procurar Locacao por veiculo|\n|"
					+" 6- Remover Pessoa              12-Procurar Veiculo              19- Remover Locacao             |\n"
					+"|                                13-Remover Veiculo                                               |\n"
					+"|                                                                                                 |\n|                                                                                                 |\n|"
					+"                              0- Sair                                                            |\n|"   
					+"                                                                                                 |\n|"
					+"_________________________________________________________________________________________________|");


			System.out.print("\nOpção: ");
			op = lerInteiro();

			switch(op){

			/*Pessoa*/
			case 1:
				if(adicionarPessoa()){
					System.out.println("pessoa adicionada com sucesso"); 
				}
				break;

			case 2:
				System.out.println(ic.listarPessoa().toString());
				break;

			case 3:
				System.out.println(ic.listarCliente().toString());
				break;

			case 4:
				System.out.println(ic.listarFuncionario().toString());
				break;

			case 5:
				System.out.print("digite o documento: ");
				str = lerDocumento();
				System.out.println(ic.pesquisarPessoaPeloCPF(str));
				break;

			case 6:
				System.out.print("digite o documento: ");
				str = lerDocumento();
				ic.removerPessoa(str);
				break;

				/*Veiculo*/
			case 7:
				if(adicionarVeiculo())
				{
					System.out.println("Veiculo adicionado com sucesso");
				}
				break;
			case 8:
				System.out.println(ic.listarVeiculos().toString());
				break;
			case 9:
				System.out.println(ic.listarVeiculosDisponiveis().toString());
				break;
			case 10:
				System.out.println(ic.listarAutomoveis().toString());
				break;
			case 11:
				System.out.println(ic.listarMotocicletas().toString());
				break;
			case 12:
				System.out.print("digite o numero da Placa: ");
				str = sc.nextLine();
				System.out.println(ic.pesquisarVeiculo(str));
				break;
			case 13:
				System.out.print("digite o numero da Placa: ");
				str = sc.nextLine();
				ic.removerVeiculo(str);
				break;
				/*Locacao*/
			case 14:
				if(adicionarLocacao())
				{
					System.out.println("Locacao adicionado com sucesso");
				}
				break;
			case 15:
				System.out.println(ic.listarLocacoes().toString());
				break;
			case 16:
				System.out.print("digite o id da locacao: ");
				i = lerInteiro();
				System.out.println(ic.pesquisarLocacao(i));
				break;
			case 17:
				System.out.print("digite o cpf do cliente: ");
				str = lerDocumento();
				//System.out.println(ic.pesquisarLocacao(ic.pesquisarPessoaPeloCPF(str)));
				break;
			case 18:
				System.out.print("digite o numero da  placa do veiculo: ");
				str = sc.nextLine();
				//	System.out.println(ic.pesquisarLocacao(ic.pesquisarVeiculo(str)));
				break;
			case 19:
				System.out.print("digite o id da locacao: ");
				i = lerInteiro();
				ic.removerLocacao(i);
				break;
			}
		}while(op!=0);
	}

	public static boolean adicionarPessoa() throws Exception{
		int op = 0;
		Scanner sc = new Scanner(System.in);
		String str = new String();
		Cliente client = new Cliente();
		Funcionario func = new Funcionario();


		do{
			System.out.println("Escolha o tipo de Pessoa");
			System.out.println("1 - Cliente");
			System.out.println("2 - Funcionario");
			System.out.print("opcao: ");
			op = lerInteiro();
		}while((op!=1)&&(op!=2));

		if(op==1){
			lerDadosPessoa(client);
			System.out.print("digite a cnh:");
			str = lerDocumento();
			client.setCnh(str);
			System.out.print("digite a categoria:");
			sc.nextLine();
			str = sc.nextLine();
			client.setCategoriaCnh(str);

			//	System.out.println(client);
			ic.addPessoa(client);
			//	System.out.println(client);
			return true;
		}
		if(op==2){
			lerDadosPessoa(func);
			System.out.print("digite o cargo:");
			str = sc.nextLine();
			func.setCargo(str);
			ic.addPessoa(func);
			return true;
		}

		return false;
	}

	public static boolean lerDadosPessoa(Pessoa p) throws Exception{
		String str;
		Scanner sc = new Scanner(System.in);
		Endereco endereco = new Endereco();
		String data = new String();

		System.out.print("digite o cpf da pessoa: ");
		str = lerDocumento();
		/*	if(ic.pesquisarPessoaPeloCPF(str)!= null)
		{
			System.out.println("pessoa já está cadastrado");
			return false;
		}*/
		p.setCpf(str);

		System.out.print("digite o nome da pessoa: ");
		str = lerNome();
		p.setNome(str);

		System.out.print("digite a data de Nascimento: ");

	//	str = lerData();
	//	p.setDataNascimento(getData());
	//	p.setDataNascimento(str);

		//str = lerData(sc);
		p.setDataNascimento(getData2());
		//	p.setDataNascimento(str);


		System.out.print("digite o login: ");
		str = sc.nextLine();
		p.setLogin(str);

		System.out.print("digite a senha: ");
		str = sc.nextLine();
		p.setSenha(str);

		System.out.print("digite o endereço da pessoa: ");

		System.out.print("Cep: ");
		str = sc.nextLine();
		endereco.setCep(str);
		System.out.print("rua: ");
		str = sc.nextLine();
		endereco.setRua(str);
		System.out.print("bairro: ");
		str = sc.nextLine();
		endereco.setBairro(str);
		System.out.print("Cidade: ");
		str = sc.nextLine();
		endereco.setCidade(str);
		System.out.print("digite o Estado: ");
		str = sc.nextLine();
		endereco.setEstado(str);

		p.setEndereco(endereco);
		return true;

	}

	public static boolean adicionarVeiculo() throws Exception{
		int op = 0, i = 0;
		Scanner sc = new Scanner(System.in);
		String str = new String();
		Automovel automovel= new Automovel();
		Motocicleta motocicleta = new Motocicleta();


		do{
			System.out.println("Escolha o tipo de Veiculo");
			System.out.println("1 - Automovel");
			System.out.println("2 - Motocicleta");
			System.out.print("opcao: ");
			op = sc.nextInt();
		}while((op!=1)&&(op!=2));

		if(op==1){
			lerDadosVeiculo(automovel);
			System.out.println("digite a quantidade de portas:");
			i = lerInteiro();
			automovel.setQtdDePortas(i);
			ic.addVeiculo(automovel);
			return true;
		}
		if(op==2){
			lerDadosVeiculo(motocicleta);
			System.out.println("digite o estilo:");
			str = sc.nextLine();
			motocicleta.setEstilo(str);
			ic.addVeiculo(motocicleta);
			return true;
		}

		return false;
	}

	public static boolean lerDadosVeiculo(Veiculo v) throws Exception{
		String str;
		Scanner sc = new Scanner(System.in);
		Placa placa = new Placa();
		String data = new String();
		double d = 0;

		/*	if(ic.pesquisarVeiculo(str)!=null)
		{
			System.out.println("veiculo já existe");
			return false;
		}*/

		System.out.print("digite a placa: ");

		System.out.print("Numero: ");
		str = sc.nextLine();
		placa.setNumerosEletras(str);
		System.out.print("Cidade: ");
		str = sc.nextLine();
		placa.setCidade(str);
		System.out.print("Estado: ");
		str = sc.nextLine();
		placa.setEstado(str);

		v.setPlaca(placa);

		System.out.print("digite a marca: ");
		str = sc.nextLine();
		v.setMarca(str);

		System.out.print("digite o Modelo: ");
		str = sc.nextLine();
		v.setModelo(str);

		System.out.print("digite o preco por hora ");
		d = lerDouble();
		v.setDisponibilidade(true);
		v.setPrecoPorHra(d);


		return true;

	}

	public static boolean adicionarLocacao() throws Exception{
		String str;
		Scanner sc = new Scanner(System.in);
		Placa placa = new Placa();

	//	String data = new String();
	//	LocalDate dataDev,dataRet;

		//String data = new String();
		LocalDateTime dataDev,dataRet;

		Locacao locacao = new Locacao();
		double d = 0;


		System.out.print("Digite a data de devolucao: ");
	//	data = lerData();
		dataDev=getData();
		locacao.setDataDevolucao(dataDev);
		
	   System.out.print("Digite a data de Retidada: ");
	   dataRet=getData();
	   locacao.setDataRetirada(dataRet);
		System.out.println("Digite a data de devolucao: ");
		//data = lerData(sc);
		//dataDev=getData();
		locacao.setDataDevolucao(getData());

	/*	System.out.println("Digite a data de Retidada: ");
		dataRet=getData();
		locacao.setDataRetirada(dataRet);
		//	locacao.setDataRetirada(data);*/

		System.out.print("digite o cpf do cliente: ");
		str = lerDocumento();
		if(ic.pesquisarPessoaPeloCPF(str) instanceof Cliente){
			locacao.setPessoa(ic.pesquisarPessoaPeloCPF(str));
		}else{
			return false;
		}

		/**
		 * Verifica se um veículo está disponível para locação
		 */
		boolean v=true;
		while(v){
			System.out.print("digite o numero da placa do veiculo: ");
			str = sc.nextLine();

			if(!ic.pesquisarVeiculo(str).isDisponibilidade()){
				System.out.println(ic.pesquisarVeiculo(str).toString()+ "Não está Disponível!\n");
				return true;


			}else{
				locacao.setVeiculo(ic.pesquisarVeiculo(str));
				ic.pesquisarVeiculo(str).setDisponibilidade(false);
				ic.realizarLocacao(locacao);
				System.out.println(locacao.toString());
				v=false;
			}
		}

		return true;
	}

	public static int lerInteiro(){
		Scanner sc = new Scanner(System.in);

		if( !sc.hasNextInt())
		{
			sc.next();
			System.out.printf("\nvoce deve digitar um numero: ");
			return lerInteiro();
		}
		return sc.nextInt();
	}

	public static double lerDouble(){
		Scanner sc = new Scanner(System.in);

		if( !sc.hasNextDouble())
		{
			sc.next();
			System.out.printf("\nvoce deve digitar um Real: ");
			return lerDouble();
		}
		return sc.nextDouble();
	}

	public static String lerDocumento(){
		Scanner sc = new Scanner(System.in);

		if( !sc.hasNextInt())
		{
			sc.next();
			System.out.printf("\nvoce deve digitar um numero: ");
			return lerDocumento();
		}
		return sc.nextLine();
	}

	public static String lerNome(){
		Scanner sc = new Scanner(System.in);
		if( sc.hasNextDouble()  ||  sc.hasNextInt() )
		{
			sc.next();
			System.out.printf("\nvoce deve digitar um nome: ");
			return lerNome();
		}
		return sc.nextLine();
	}

	public static String lerData()throws ParseException{
		Scanner sc = new Scanner(System.in);
		String leitor, res;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			leitor = sc.nextLine();
			if(sdf.parse(leitor)==null);
		}catch(Exception e){
			System.out.println("voce deve digitar a data no formato solicitado(dd/MM/yyyy): ");
			return lerData();
		}
		return leitor;
	}
	
	public static String lerDataEHora()throws ParseException{
		Scanner sc = new Scanner(System.in);
		String leitor, res;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		leitor = sc.nextLine();
		try{
			if(sdf.parse(leitor)==null);
		}catch(Exception e){
			System.out.println("voce deve digitar a data no formato solicitado(dd/MM/yyyy HH:mm:ss): ");
			return lerData();
		}
		return leitor;
	}

	/*  public static String lerData(Scanner in){
		System.out.print("Digite no formato (dd/mm/aaaa) ");
		String r = "";
		do{
			r = in.nextLine();

			if(r.length()!=10){
				System.out.print("Formato inválido digite: dd/mm/aaaa");
			}
		}while(r.length()!=10);
		return r;

	}*/

//	static LocalDate getData()throws Exception{

	public static LocalDateTime getData(){


		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = null;
		LocalDate sData = null;

		int ano=lerAno();
		int mes=lerMes();
		int dia=lerDia();
		int hora=lerHora();
	
		LocalDateTime sData2=LocalDateTime.of(ano,mes,dia,hora,0);
	//	LocalDateTime sData3=LocalDateTime.of(sData, sData2);
		
		return sData2;
	}
	
	public static LocalDate getData2(){

			DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			Scanner sc = null;
			LocalDate sData = null;
			try {
				sData = LocalDate.parse( lerData() , fmt2 );
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 

			return sData;
	}
	
	
	public static int lerMes(){
		int mes = 0;


		do {
			System.out.println("Digite o Mes");
			mes=lerInteiro();
			
		} while ((mes<0)||(mes>12));

		return mes;
	}
	
	public static int lerAno(){
		int ano = 0;
		do {
			System.out.print("Digite o Ano");
			ano=lerInteiro();

		} while ((ano<2016)||(ano>2100));

		return ano;

	}

	public static int lerDia(){
		int dia = 0;

		do {
			System.out.print("Digite o Dia");
			dia=lerInteiro();

		} while ((dia<1)||(dia>31));

		return dia;
	}

	public static int lerHora(){
		int hora = 0;

		do {
			System.out.print("Digite a Hora");
			hora=lerInteiro();

		} while ((hora<0)||(hora>23));

		return hora;
	}



	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1L;
	private static Icontroller ic= new Controller();

	public static void main(String[] args) {

		Cliente      c=new Cliente();
		Cliente     c1=new Cliente();
		Funcionario  f=new Funcionario();

		/*comentario
		c.setCnh("123");
		c.setNome("Fabiano");
		c.setCpf("000");

		f.setCargo("gerente");
		f.setMatricula("321");
		f.setCpf("001");


		c1.setCnh("111");
		c1.setNome("Roberto");
		c1.setCpf("011");


		ic.addPessoa(f);
		ic.addPessoa(c);
		ic.addPessoa(c1);

		System.out.println(ic.listarPessoa().toString());

		for (Cliente cli : ic.listarCliente()) {

			if(cli.getCnh().equals("111")){
				System.out.println(cli.toString());
			}

		}
		System.out.println("Removendo..");
		ic.removerPessoa("123");
		ic.removerPessoa("000");
		System.out.println(ic.listarPessoa().toString());


		/*

		ic.listarCliente("123");
		ic.listarCliente("111");
		ic.listarCliente("123");

	}*/

}
