
import java.util.*;
import java.io.*;
import java.net.InetAddress;

class ej_inetAddress {
	
	
	
public static void main(String[] args) {
	
		
		try {
		InetAddress[] addresses = new InetAddress[2];
		addresses[0] = InetAddress.getLoopbackAddress();
		addresses[1] = InetAddress.getByName("ioc.xtec.cat");
		addresses[2] = InetAddress.getByName("ioc.xtec.cat");
		addresses[1] = InetAddress.getByName("224.0.0.15");
		
			
		for(InetAddress adress: addresses){
			
			if(adress.isLoopbackAddress()){
				
				System.out.println(adress.getHostName()+"té una adreça loopback");
			}else{
				
				System.out.println(adress.getHostName() + " no té una adreça loopback");
		}
	}
	}
		catch(Exception e) {
	}
			
  }
}
