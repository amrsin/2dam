
import java.util.*;
import java.io.*;
import java.net.InetAddress;

class ej_inetAddress {
	
	
	
public static void main(String[] args) {
	
		
		try {
			
		InetAddress[] addresses = new InetAddress[4];
		addresses[0] = InetAddress.getLoopbackAddress();
		addresses[1] = InetAddress.getByName("iesserpis.org");
		addresses[2] = InetAddress.getByName("192.168.4.18");
	    addresses[3] = InetAddress.getByName("224.243.12.3");

		
			
		for(InetAddress adress: addresses){
			
			System.out.println("Nombre: " + adress.getHostName());
			System.out.println("IP: " + adress.getHostName());
			
			
			if(adress.isLoopbackAddress()){
				
				System.out.println("Esta dirección es una dirección loopback");
			}else if (adress.isSiteLocalAddress()){
				
				System.out.println("Esta dirección es un dirección local");
		    }else if (adress.isMulticastAddress()) {
				
			     System.out.println("Esta dirección es un dirección multicast");

				
			}else{
				
		       System.out.println("Esta dirección es un dirección privada");
			}
			System.out.println("");
	    }
	}
		catch(Exception e) {
	}
			
  }
}
