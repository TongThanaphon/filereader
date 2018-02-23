package filereader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TaskString implements Runnable{
	
	private int size = readFile("src/filereader/Alice.txt").length();
	
	public static String readFile(String filename){
		String data = "";
		InputStream in = null;
		
		try{
			in = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(in);
			
			int c;
			while(true){
				c = reader.read();
				if(c < 0) break;
				data = data + (char)c;
			}
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
		
		if(in != null)
			try{
				in.close();
			}catch(IOException ioe){}
		
		return data;
	}

	@Override
	public void run() {
		readFile("src/filereader/Alice.txt");
	}
	
	@Override
	public String toString() {
		return String.format("Reading %d chars using FileReader, append to String.", size);
	}
	
	

}