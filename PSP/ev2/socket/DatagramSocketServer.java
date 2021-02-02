

import java.util.*;
import java.io.*;
import java.net.*;

public class DatagramSocketServer {
	DatagramSocket socket;

	public void init(int port) throws SocketException {
		socket = new DatagramSocket(port);
	}

	public void runServer() throws IOException {

		byte[] receivingData = new byte[1024];
		byte[] sendingData;
		InetAddress clientIP;
		int clientPort;
		// el servidor atÃ©n el port indefinidament
		while (true) {
			// creaciÃ³ del paquet per rebre les dades
			DatagramPacket packet = new DatagramPacket(receivingData, 1024);
			// espera de les dades
			socket.receive(packet);

			String data_traducido = traducir(packet.getData(), packet.getLength());
			// processament de les dades rebudes i obtenciÃ³ de la resposta
			String msg = processData(data_traducido);
			sendingData = msg.getBytes();
			// obtenciÃ³ de lâ€™adreÃ§a del client
			clientIP = packet.getAddress();
			// obtenciÃ³ del port del client
			clientPort = packet.getPort();
			// creaciÃ³ del paquet per enviar la rezsposta
			packet = new DatagramPacket(sendingData, sendingData.length,

					clientIP, clientPort);

			// enviament de la resposta
			socket.send(packet);
		}
	}

	private String processData(String data_traducido) {
		// procÃ©s diferent per cada aplicaciÃ³

		String data = "";
		switch (data_traducido) {

		case "noticias":

			data = "Esto es una noticia de prueba";
			break;

		case "hora":

			break;

		default:

			break;

		}
		return data;

	}

	public static String traducir(byte[] data, int length) {

		String data_traducido = new String(data, 0, length);

		return data_traducido;

	}
}