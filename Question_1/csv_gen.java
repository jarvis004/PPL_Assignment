import java.io.*;
import java.util.*;
/*! csv_gen class*/
public class csv_gen {
/*! csv function to generate csv files this function creates csv files and writes into it*/
	    void csv(){
		try{
			FileWriter boy_file = new FileWriter("boy.csv");
			FileWriter girl_file = new FileWriter("girl.csv");
			int j;
			Random boy_rand = new Random();
			Random girl_rand = new Random();
			for(j=0;j<=20;j++){
				boy_file.write("B"+j+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(1000)+","+"Single"+"\n");
			}
			for(j=0;j<=7;j++){
				girl_file.write("G"+j+","+girl_rand.nextInt(10)+","+girl_rand.nextInt(1000)+","+girl_rand.nextInt(10)+","+"Single"+"\n");
			}
			boy_file.close();
			girl_file.close();
			}catch(IOException e){		
		
			}
	
		}
}
