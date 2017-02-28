import java.io.*;
import java.util.*;
public class csv_gen {
	    void csv(){
		try{
			FileWriter boy_file = new FileWriter("boy.csv");
			FileWriter girl_file = new FileWriter("girl.csv");
			FileWriter gift_file = new FileWriter("gift.csv");
			int j;
			Random boy_rand = new Random();
			Random girl_rand = new Random();
			Random gift_rand = new Random();
			String boy_type[]= {"Miser","Generous","Geeky"};
			String girl_type[]= {"Choosey","Normal","Desprate"};
			String gift_type[] = {"Essential","Luxury","Utility"};
			
			for(j=0;j<=20;j++){
				boy_file.write("B"+j+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(10)+","+boy_rand.nextInt(1000)+","+"Single"+","+boy_type[boy_rand.nextInt(3)]+"\n");
			}
			for(j=0;j<=8;j++){
				girl_file.write("G"+j+","+girl_rand.nextInt(10)+","+girl_rand.nextInt(1000)+","+girl_rand.nextInt(10)+","+"Single"+","+girl_type[girl_rand.nextInt(3)]+"\n");
			}
			for(j=0;j<=50;j++){
				gift_file.write("Gift"+j +","+ gift_rand.nextInt(1000)+","+gift_rand.nextInt(10)+","+gift_type[gift_rand.nextInt(3)]+ "\n");
			}
			
			boy_file.close();
			girl_file.close();
			gift_file.close();
		}catch(IOException e){		
		
		}
	
		
}

		
	    
}
