
import java.util.*;
import java.io.*;
import java.net.*;

class reader {
	
	
	
	public static void main(String[] args) {
		
		
		try {
			
			
		URL direccion = new URL("https://www.rfc-editor.org/rfc/rfc8832.txt");
		
		printContent(direccion);

	   }catch (IOException ex){
		   System.out.println(ex);
	   }
	
	
  }
	
	
private static void printContent(URL url){

	InputStream in;
	char[] cbuf = new char[512];

	int caractersLlegits;
	
	if(!isText(url)){
	return;
	}
	
	try {
		in = url.openStream();
		InputStreamReader inr = new InputStreamReader(in);
		caractersLlegits = inr.read(cbuf);
		
	while(caractersLlegits != - 1){
		
		String str = String.copyValueOf(cbuf, 0, caractersLlegits);
		System.out.print(str);
		caractersLlegits = inr.read(cbuf);
		
		Thread.sleep(1000);
  }
	System.out.println();
 } catch (Exception ex) {
	
	System.out.println(ex);
	}
  }
  
  public static boolean isText (URL url) {
		
		boolean ret = false;
		
		try {
			
			URLConnection con = url.openConnection();
			String headerType = con.getContentType();
			String guessType = con.guessContentTypeFromName(url.getFile());
			ret = headerType.endsWith("text/plain") || guessType.endsWith("text/plain");		
			
			
		}catch (IOException ex) {
			
			System.out.println(ex);
			
		}
	return ret;
    }
}
