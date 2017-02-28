import java.io.*;
public class MyLogger {
	
	 static void logfile(String str){
		 
		
		try(FileWriter log = new FileWriter("log.txt")){
			log.write(str);			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}