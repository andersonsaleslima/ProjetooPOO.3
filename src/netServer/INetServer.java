package netServer;

import java.net.Socket;

/**
 * interface que contém os métodos para inicialização do servidor de 
 * arquivos, devendo-se ser implementado os métodos pela classe que 
 * implementar essa interface;
 * 
 * @author SHOW13
 *
 */

public interface INetServer {
	
	public void initServer()throws Exception;
	public boolean receberObeject(Socket client)throws Exception;
	public boolean enviarObject(Socket clint)throws Exception;

}
