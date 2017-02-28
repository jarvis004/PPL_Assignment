import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Random;
public class q2{
	
	public static void main(String args[]) throws IOException{
		int i,j;
		i=0;
		j=0;
		int m=0;
		Boys b[] = new Boys[1000];
		csv_gen csv_files = new csv_gen();
		csv_files.csv();  
		String csvFile = "boy.csv";
		File out=new File("log.txt");
		String line = "";
		String csvSplit = ",";
		BufferedReader buff = null;
		try{
			buff = new BufferedReader(new FileReader(csvFile));
			while((line = buff.readLine() )!= null){
				String[] boys_table = line.split(csvSplit);
			
				b[i] = new Boys();
			    b[i].name = boys_table[0];
				b[i].intelligence = Integer.parseInt(boys_table[1]);
				b[i].attractivness = Integer.parseInt(boys_table[2]);
				b[i].min_attr_req = Integer.parseInt(boys_table[3]);
				b[i].budget = Integer.parseInt(boys_table[4]);
				b[i].status = boys_table[5];
				b[i].boy_type= boys_table[6];
				b[i].girlf="";
				b[i].happiness_boy = 0;
				i++;
			}
		}
		
		catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		Girls g[] = new Girls[1000];
		csvFile = "girl.csv";
		line = "";
		csvSplit = ",";
		buff = null;
		
		
		try{
			buff = new BufferedReader(new FileReader(csvFile));
			while((line = buff.readLine() )!= null){
				String[] girls_table = line.split(csvSplit);
			
				g[j] = new Girls();
			    g[j].name = girls_table[0];
				g[j].attar = Integer.parseInt(girls_table[1]);
				g[j].expense = Integer.parseInt(girls_table[2]);
				g[j].intelligence = Integer.parseInt(girls_table[3]);
				g[j].status = girls_table[4];
				g[j].girl_type = girls_table[5];
				g[j].boyf = "";
				g[j].happiness_girl= 0;
				
				j++;
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
				if(buff != null){
					try{
						buff.close();
					}catch(IOException e){
					e.printStackTrace();
					}
				}
		}
		
		
		gift gf[] = new gift[1000];
		csvFile = "gift.csv";
		line = "";
		csvSplit = ",";
		buff = null;
		
		
		try{
			buff = new BufferedReader(new FileReader(csvFile));
			while((line = buff.readLine() )!= null){
				String[] gifts_table = line.split(csvSplit);
			//	System.out.println(boy[0] + boy[1] + boy[2] + boy [3]);
				gf[m] = new gift();
			    gf[m].gift_name = gifts_table[0];
				gf[m].gift_price = Integer.parseInt(gifts_table[1]);
				
				gf[m].gift_value = Integer.parseInt(gifts_table[2]);
				gf[m].gift_type = gifts_table[3];
				
				m++;
				
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
				if(buff != null){
					try{
						buff.close();
					}catch(IOException e){
					e.printStackTrace();
					}
				}
		}

   //   Arrays.sort( gft);
		
		
		gift tem;
		int m1,n;
		for(m1=0;m1<m;m1++){
			for(n=m1+1;n<m;n++){
				if(gf[m1].gift_price > gf[n].gift_price){
					tem= gf[m1];
					gf[m1]=gf[n];
					gf[n]=tem;
				}
			}
		}
		

		
		int count = 0;
		int c,d;
		Couple gbcouple[] = new Couple[100];
		for(c=0;c<i;c++){
			for(d=0;d<j;d++){
				if(b[c].is_eligible(g[d].expense,g[d].attar) && b[c].status.equals("Single") && g[d].status.equals("Single")){
					b[c].girlf = g[d].name;
					g[d].boyf = b[c].name;
					b[c].status = "Is_committed";
					g[d].status = "Is_committed";
					count++;
					String df= new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(new Time(System.currentTimeMillis()));
                    String output =  df+" "+"Boy : "+b[c].name + " is Committed with " +"Girl : "+g[d].name + "\n" ;
                    System.out.println(output);
                    try(BufferedWriter buffer=new BufferedWriter(new FileWriter(out,true))){
                    	buffer.write(output);
                    	
					}
                    gbcouple[count-1] = new Couple(b[c],g[d]);
                    
				}
			}
		
			
      
		

		}
	
		for(n=0;n<count;n++){
			gbcouple[n].calc_happiness();
			gbcouple[n].calc_affinity();
			gbcouple[n].calc_gifts(gf,m);
}
		Couple cu;
		int x,y;
		for(x=0;x<count;x++){
			for(y=x+1;y<count;y++){
				if(gbcouple[x].happiness < gbcouple[y].happiness){
					cu= gbcouple[x];
					gbcouple[x]=gbcouple[y];
					gbcouple[y]=cu;
				}
			}
		}
		Random happi = new Random();
		int h = happi.nextInt(count) +1;
		System.out.println("Best " +h+ " happiest Couples :"+"\n");
		for(x=0;x<h;x++){
		System.out.println(gbcouple[x].boy.name+" and "+gbcouple[x].girl.name+"\n");
		
		String happy = "happiness : "+ gbcouple[x].boy.name+" and "+gbcouple[x].girl.name+" & happiness is "+gbcouple[x].happiness +"\n";
		try(BufferedWriter buffer=new BufferedWriter(new FileWriter(out,true))){
        	buffer.write(happy);
        	
		}}
		for(x=0;x<count;x++){
			for(y=x+1;y<count;y++){
				if(gbcouple[x].affinity < gbcouple[y].affinity){
					cu= gbcouple[x];
					gbcouple[x]=gbcouple[y];
					gbcouple[y]=cu;
				}
			}
		}
		System.out.println("Best " +h+ " Compaitable Couples :"+"\n");
		
		for(x=0;x<h;x++){
			System.out.println(gbcouple[x].boy.name+" and "+gbcouple[x].girl.name+"\n");
		
		String Comp = "compaitable : "+ gbcouple[x].boy.name+" and "+gbcouple[x].girl.name+" & compatibality is "+gbcouple[x].affinity +"\n";
		try(BufferedWriter buffer=new BufferedWriter(new FileWriter(out,true))){
        	buffer.write(Comp);
		}
		}
	}
}




