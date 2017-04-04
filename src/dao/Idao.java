package dao;

import java.io.*;
import java.util.ArrayList;

import controller.Pessoa;

/**
 * Interface que contém os métodos para salvamento dos arquivos, 
 * devendo-se ser implementado os métodos na classe que implementar 
 * essa interface.
 * 
 * @author SHOW13
 *
 */

public interface Idao {
	
	public boolean salvarEmArq(Object obj, String str) throws Exception;
	public Object carregarArq(String str)throws Exception;
	public boolean verificarArquivo(String str)throws Exception;
	

}
