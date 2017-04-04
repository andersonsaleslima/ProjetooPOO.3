package netServer;

/**
 * Classe principal que conterá o método main para inicialização do servidor.
 * 
 * 
 * @author SHOW13
 *
 */

public class TesteNetServer {

	private static INetServer iNet = new ControllerNetServer();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		iNet.initServer();

	}

}
