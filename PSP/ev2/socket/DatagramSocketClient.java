
import java.util.*;
import java.io.*;
import java.net.*;

public class DatagramSocketClient {
	InetAddress serverIP;
	int serverPort;
	DatagramSocket socket;

public void init(String host, int port) throws SocketException,
	UnknownHostException{
		serverIP = InetAddress.getByName(host);
		serverPort = port;
		socket = new DatagramSocket();
}
public void runClient() throws IOException{
	byte [] receivedData = new byte[1024];
	byte [] sendingData;
	//a l’inici
	sendingData = getFirstRequest();
	//el servidor atén el port indefinidament
	while(mustContinue(sendingData)){
		DatagramPacket packet = new DatagramPacket(sendingData,
		sendingData.length, serverIP, serverPort);
		//enviament de la resposta
		socket.send(packet);
		//creació del paquet per rebre les dades
		packet = new DatagramPacket(receivedData, 1024);
		//espera de les dades
		socket.receive(packet);
		//processament de les dades rebudes i obtenció de la resposta
		sendingData = getDataToRequest(packet.getData(), packet.getLength());
	}
}
private byte[] getDataToRequest(byte[] data, int length) {
	//procés diferent per cada aplicació
	return null;
 }
private byte[] getFirstRequest() {
	//procés diferent per cada aplicació
	return null;

 }
private boolean mustContinue(byte[] sendingData) {
	//procés diferent per cada aplicació
    return true;

  }
}
