package net;

import java.util.*;

/**
 * Interface que contém os métodos para conexão com o servidor de 
 * arquivos, devendo-se ser implementado os métodos pela classe que 
 * implementar essa interface;
 * 
 * @author SHOW13
 *
 */

public interface INetClient {
	
	public boolean enviarObject(Object obj, String fileName)throws Exception;
	public Object receberObject(String arquivo) throws Exception;

}
