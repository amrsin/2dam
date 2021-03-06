import java.util.*;
import java.io.*;
import java.net.*;

public class DatagramSocketClient {
	InetAddress serverIP;
	int serverPort;
	DatagramSocket socket;

	public void init(String host, int port) throws SocketException, UnknownHostException {
		serverIP = InetAddress.getByName(host);
		serverPort = port;
		socket = new DatagramSocket();
	}

	public void runClient() throws IOException {
		byte[] receivedData = new byte[1024];
		byte[] sendingData = null;
		String msg = "noticias";
		DatagramPacket packet = null;
	
		// a lâ€™inici
		// el servidor atÃ©n el port indefinidament
		while (mustContinue(msg)) {
			
		    sendingData = msg.getBytes();;
			packet = new DatagramPacket(sendingData, sendingData.length, serverIP, serverPort);
			// enviament de la resposta
			socket.send(packet);
			// creaciÃ³ del paquet per rebre les dades
			packet = new DatagramPacket(receivedData, 1024);
			// espera de les dades
			socket.receive(packet);
			// processament de les dades rebudes i obtenciÃ³ de la resposta
			sendingData = packet.getData();
			String str = new String(packet.getData());
			System.out.println(str);
		}	
	}
	

	private boolean mustContinue(String data_traducido) {
		
		boolean c = true;


		if(data_traducido.equals("Adios")) {
			
			c = false;
		}
		
		
		return c;

	}
	
	public static String traducir(byte[] data, int length) {

		String data_traducido = new String(data, 0, length);

		return data_traducido;

	}
	
	public static void main(String[] args) {
		
		DatagramSocketClient dc = new DatagramSocketClient();
		
		
		try {
		dc.init("localhost",5555);
		dc.runClient(); 
		
			}catch(IOException ex)	{
		
		System.out.print(ex);
		
	}
  }
}

	
