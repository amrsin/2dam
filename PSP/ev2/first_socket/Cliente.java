
import java.util.*;
import java.io.*;
import java.net.*;

class Cliente {
	
	public static void main(String[] args) {
		
		try {
			
		//bytes del missatge a enviar
		byte[] missatge = "Salutacions".getBytes();
		//adreça IP del destí
		InetAddress adrecaDesti = InetAddress.getByName("localhost");
		//port destí
		int portDesti = 5555;
		//creació del paquet a enviar
		DatagramPacket packet = new DatagramPacket(missatge, missatge.length, adrecaDesti, portDesti);
		//creació d’un socket temporal amb el qual realitzar l’enviament
		DatagramSocket socket = new DatagramSocket();
		//Enviament del missatge
		socket.send(packet);
		
		
		}catch(Exception ex) {
			
		  System.out.print(ex);		
	}	 
  }
}
	


