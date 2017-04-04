package netServer;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import dao.*;

/**
 * Contém os métodos herdados da interface INetServer e suas implementações:
 * 
 * @author SHOW13
 *
 */

public class ControllerNetServer implements INetServer, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Idao id=new ControllerDao();
	
	@Override
	public void initServer()throws Exception{
		try{
			ServerSocket sock = new ServerSocket(6013);
			String op = new String();
			
			System.out.println("Servidor inicializado\n");
			while (true) {
				Socket client = sock.accept();
				// temos uma conexão
			
				/**	
				 * 	Menu de Dados das opcao recebida:
				 *	0 - Cancelar;
				 *	1 - salvar arquivo do cliente;
				 *	2 - enviar arquivo solicitado pelo cliente;
				 *
				 **/
				InputStream in = client.getInputStream();
			//	BufferedReader bin = new BufferedReader(new InputStreamReader(in));
				
				int i = in.read();
				System.out.println(i);
				
			//	op = bin.readLine();
			//	System.out.println(op);
				
				if((i==0)||(i!=1)&&(i!=2)){
					client.close();
				}
			//	if((!op.equals("0"))&&(!op.equals("1"))&&(!op.equals("2"))){
			//		client.close();
			//	}
				else{
				
					//				client.wait();
					switch(i){
						case 1:
							receberObeject(client);
							break;
						case 2:
							enviarObject(client);
							break;
						default:
							client.close();
							break;
					}
				}
				client.close();
				System.out.println("conexao fechada");
			}
		}catch(Exception e){
			System.err.println("erro no servidor");
		}
	}

	@Override
	public boolean receberObeject(Socket client) throws Exception {
		
		String op = new String();
		
		try{
		
			/**	
			 * 	Menu de Dados da segunda opcao recebida para carrgerarquivos:
			 *	0 - Cancelar;
			 *	1 - arquivo pessoas.obj;
			 *	2 - arquivo veiculos.obj;
			 *	3 - arquivo locacoes.obj
			 **/
			InputStream in = client.getInputStream();
			int i = in.read();
			System.out.println(i);

			
			if((i==0)||(i!=1)&&(i!=2)&&(i!=3)){
				client.close();
				return false;
			}
			else{
			
				/*recebimento do objeto do cliente*/
/*erro*/		ObjectInputStream inStream = new ObjectInputStream(client.getInputStream());
				Object obj =  inStream.readObject();


				if(obj!=null){
					switch(i){
						case 1:
								id.salvarEmArq(obj,"pessoas.obj");
								System.out.println("arquivo pessoas.obj salvo com sucesso no Server");
								System.out.println("arquivo salvo com sucesso no Server");

							break;
						case 2:
								id.salvarEmArq(obj,"veiculos.obj");

								System.out.println("arquivo veiculos.obj salvo com sucesso no Server");

								System.out.println("arquivo salvo com sucesso no Server");

							break;
						case 3:
								id.salvarEmArq(obj,"locacoes.obj");

								System.out.println("arquivo locacoes.obj salvo com sucesso no Server");
								System.out.println("arquivo salvo com sucesso no Server");
							break;
						default:
					//		client.close();
							return false;
					}
				//	client.close();
					return true;
				}else{
				//	client.close();
					return false;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Erro receber objeto do cliente");
		}
		
		return false;
	}

	@Override
	public boolean enviarObject(Socket client) throws Exception{

		String op = new String();
		
		try{
		
			/**	
			 * 	Menu de Dados da segunda opcao recebida para enviar aquivo:
			 *	0 - Cancelar;
			 *	1 - arquivo pessoas.obj;
			 *	2 - arquivo veiculos.obj;
			 *	3 - arquivo locacoes.obj
			 **/
		
			
			InputStream in = client.getInputStream();
			
			int i = in.read();
			System.out.println(i);
			
			
			if((i==0)||(i!=1)&&(i==2)&&(i==3)){
				client.close();
				return false;
			}
			else{
				ObjectOutputStream outStream = new ObjectOutputStream(client.getOutputStream());
				Object obj = new Object();
				switch(i){
					case 1:
						obj = id.carregarArq("pessoas.obj");

						System.out.println("pessoas.obj");

						System.out.println(obj);

						outStream.writeObject(obj);
						outStream.flush();
						break;
					case 2:
						obj = id.carregarArq("veiculos.obj");
						System.out.println("veiculos.obj");
						outStream.writeObject(obj);
						outStream.flush();
						break;
					case 3:
						obj = id.carregarArq("locacoes.obj");
						System.out.println("locacoes.obj");
						outStream.writeObject(obj);
						outStream.flush();
						break;
					default:
				//		outStream.flush();
				//		client.close();
						return false;
				}
			//	client.close();
				return true;
			}
		}catch(Exception e){
			System.err.println("erro ao enviar objeto para cliente");
		}
		return false;
	
	}
	
	/*Funções disponíveis caso continue o erro*/
	

/*	public boolean enviarArqLocacoes(Socket client) throws Exception{
		
		OutputStream out = client.getOutputStream();
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		
		Object obj = new Object();
		obj = id.carregarArq("locacoes.obj");
		
		objOut.writeObject(obj);
		objOut.writeObject(obj);
		return true;
	}*/
	
/*	public boolean receberArqLocacoes(Socket client) throws Exception{
		
		
		Object obj = new Object();
		
		InputStream in = client.getInputStream();
		ObjectInputStream objIn = new ObjectInputStream(in);
		
		obj = objIn.readObject();
		
		id.salvarEmArq(obj, "locacoes.obj");
		
		return true;
	}*/

	
}
