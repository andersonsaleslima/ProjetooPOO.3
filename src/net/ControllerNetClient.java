package net;

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
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;


import  controller.*;

/**
 * Contém os métodos herdados da interface INetClient e 
 * suas implementações:
 * 
 * @author SHOW13
 *
 */

public class ControllerNetClient implements INetClient, Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean enviarObject(Object obj, String fileName) throws Exception{
		
		try{
//			ArrayList<String>  array = new ArrayList<String>();
			
			Socket sock = new Socket("127.0.0.1",6013);
			
			/**	
			 * 	Menu de Dados das opcao recebida:
			 *	0 - Cancelar;
			 *	1 - enviar arquivo para servidor;
			 *	2 - receber arquivo do servidor;
			 *
			 **/
			/*Primeira etapa: envio de opção escolhida para o servidor*/
			OutputStream out = sock.getOutputStream();
			out.write(1);
			out.flush();
			
			String op = new String("1");
			
			
			/**	
			 * 	Menu de Dados da segunda opcao recebida para carrgerarquivos:
			 *	0 - Cancelar;
			 *	1 - arquivo pessoas.obj;
			 *	2 - arquivo veiculos.obj;
			 *	3 - arquivo locacoes.obj
			 **/
			/*Segunda etapa: envio de opção escolhida para o servidor*/
			op = "0";
			
			/*Segunda etapa: resposta a segunda opcao do tipo de arquivo a enviar*/
			if(fileName.equals("pessoas.obj")){
				out.write(1);
				out.flush();
				op = "1";
			}
			if(fileName.equals("veiculos.obj")){
				out.write(2);
				out.flush();
				op = "2";
			}
			if(fileName.equals("locacoes.obj")){
				out.write(3);
				out.flush();
				op = "3";
			}
			if((!fileName.equals("pessoas.obj"))&&(!fileName.equals("veiculos.obj"))
				&&(!fileName.equals("locacoes.obj"))){
				out.write(0);
				out.flush();
				System.out.println("escreveu 0 no recebimento");
			}
			System.out.println(op+" opcao escolhida");
			
			
			/*Terceira Etapa: envio do objeto*/
			ObjectOutputStream outStream = new ObjectOutputStream(sock.getOutputStream());
			outStream.writeObject(obj);
			outStream.flush();
			
			sock.close();
			
		}catch(Exception e){
			System.err.println("erro ao enviar objeto para servidor");
		}
		return false;
	}

	@Override
	public Object receberObject(String arquivo)throws Exception{
		Object obj = new Object();
		
		try{
			Socket sock = new Socket("127.0.0.1",6013);
		
			/**	
			 * 	Menu de Dados das opcao recebida:
			 *	0 - Cancelar;
			 *	1 - enviar arquivo para servidor;
			 *	2 - receber arquivo do servidor;
			 *
			 **/
			/*Primeira etapa: envio de opção escolhida para o servidor*/
			OutputStream out = sock.getOutputStream(); 
			out.write(2);
			out.flush();
			
		//	PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
			String op = new String("2");
			
			/**	
			 * 	Menu de Dados da segunda opcao recebida para carrgerarquivos:
			 *	0 - Cancelar;
			 *	1 - arquivo pessoas.obj;
			 *	2 - arquivo veiculos.obj;
			 *	3 - arquivo locacoes.obj
			 **/
			/*Segunda etapa: envio de opção escolhida para o servidor*/
			op = "0";
			
			if(arquivo.equals("pessoas.obj")){
				out.write(1);
				out.flush();
				op = "1";
			}
			if(arquivo.equals("veiculos.obj")){
				out.write(2);
				out.flush();
				op = "2";
			}
			if(arquivo.equals("locacoes.obj")){
				out.write(3);
				out.flush();
				op = "3";
			}
			if((!arquivo.equals("pessoas.obj"))&&(!arquivo.equals("veiculos.obj"))&&(!arquivo.equals("locacoes.obj"))){
				out.write(0);
				out.flush();
				System.out.println("escreveu 0 no recebimento");
			}
			
			
			/*Terceira etapa: recebimento do objeto*/
			ObjectInputStream inStream = new ObjectInputStream(sock.getInputStream());
			obj = inStream.readObject();
			
			sock.close();
			return obj;
		}catch(Exception e){
			System.err.println("erro ao recebr objeto");
		}
		
		return obj;
	}

	
	/*Métodos adionais caso o erro persista*/
/*	
	public boolean enviarArqLocacoes(Object obj, String localizacao) throws Exception{
		
		Socket sock = new Socket("127.0.0.1",6013);
		
		OutputStream out = sock.getOutputStream();
		ObjectOutputStream objOut = new ObjectOutputStream(sock.getOutputStream());
		return true;
	}
	
	public boolean receberArqLocacoes(String localizacao) throws Exception{
		
		Socket sock = new Socket("127.0.0.1",6013);
		
		Object obj = new Object();
		
		InputStream in = sock.getInputStream();
		ObjectInputStream objIn = new ObjectInputStream(in);
		return true;
	}*/
	
}
