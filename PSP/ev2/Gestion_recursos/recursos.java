import java.util.*;
import java.io.*;
import java.net.*;


class recursos {
	
	
	public static void main(String[] args) {
		
		
		try {
			
			
		URL direccion = new URL("https://cadenaser00.epimg.net/ser/imagenes/2017/06/15/ciencia/1497514751_931130_1497515175_noticia_normal.gif");
		boolean comprobacion = isGifFormat(direccion);
		
		if (comprobacion) {
			System.out.println("Es gif");
		}else {
			
			System.out.println("No es gif");
		}

	   }catch (IOException ex){
		   System.out.println(ex);
	   }
	
	
  }
  
  public static boolean isGifFormat (URL url) {
		
		boolean ret = false;
		
		try {
			
			URLConnection con = url.openConnection();
			String headerType = con.getContentType();
			String guessType = con.guessContentTypeFromName(url.getFile());
			ret = headerType.endsWith("gif") || guessType.endsWith("gif");		
			
			
		}catch (IOException ex) {
			
			System.out.println(ex);
			
		}
	return ret;
    }
}


