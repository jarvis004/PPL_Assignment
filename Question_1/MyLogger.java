import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/*! MyLogger class*/
public class MyLogger{
/*!logger function to log in to text file */
static void logger(String[] s, int cnt){  
	    try {  
    	Logger logger = Logger.getLogger("My log"); 
    	FileHandler fh = new FileHandler("log.txt",true);          
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter); 
        logger.setUseParentHandlers(true);
        int k=0;
        for(k=0;k<cnt;k++){
        	logger.info(s[k]);
        	}
         } 
	catch (SecurityException e) {  
       	e.printStackTrace();  
    	}catch (IOException e) {  
        e.printStackTrace();  
    	}  
    }
}
