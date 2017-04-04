package dao;

import java.io.*;
import java.util.ArrayList;

import controller.Pessoa;

/**
 * Contém os métodos herdados da interface Idao e suas implementações:
 * 
 * @author SHOW13
 *
 */

public class ControllerDao implements Idao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean salvarEmArq(Object obj, String localizacao) throws Exception{
		
			 
	           try {
	             FileOutputStream saveFile = new FileOutputStream(localizacao);
	             ObjectOutputStream stream = new ObjectOutputStream(saveFile);
	             
	         //  salva o objeto
	             stream.writeObject(obj);
	         //  System.out.println(list+"\ncontrollerDao- salvar\n");
	         //  System.out.println(stream+"\nobject de salvar arquivo\n");
	             
	             stream.close();
	           } catch (Exception exc) {
	             exc.printStackTrace();
	           }
	    
		return false;
	}

	@Override
	public Object carregarArq(String localizacao)throws Exception{

		Object obj = new Object();
		//ArrayList<Pessoa> list = new ArrayList<Pessoa>();
		
            try{
            	File file = new File(localizacao);
            	
            	if(file.exists()){
            		
            	//	if(file.is)
            		
            		FileInputStream restFile = new FileInputStream(file);
            		ObjectInputStream stream = new ObjectInputStream(restFile);
            		// recupera o objeto
            	
            		System.out.println(localizacao);

            		obj = (Object) stream.readObject();

            		System.out.println(obj+"qualquer coidsa");
            	//	else{
            	//		return obj;
            	//	}
            	//	list = (Object) stream.readObject();
            	//	System.out.println(list+"\ncontrollerdao - carregar arquivo\n");

            		stream.close();
            		return obj;
            	}
            /*	else{
            		FileOutputStream saveFile = new FileOutputStream(localizacao,true);
   	             	ObjectOutputStream outStream = new ObjectOutputStream(saveFile);
   	             	outStream.writeObject(null);
   	             	outStream.close();
   	             	return obj;
            	}*/
            	return null;
            	
            }catch (Exception e) {
            	e.printStackTrace();
            	System.err.println("erro carregar arquivo - Controller Dao");
            }
            return null;
     
	}
	
	public boolean verificarArquivo(String localizacao)throws Exception{
		File file = new File(localizacao);
		
		if(file.exists()){
			return true;
		}
	//	FileOutputStream saveFile = new FileOutputStream(localizacao,true);
    //    ObjectOutputStream outStream = new ObjectOutputStream(saveFile);
    //   outStream.close();
		return false;
	}
	
}
