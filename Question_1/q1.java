import java.io.*;
/*!class q1  */
public class q1{
/*! main class */
	public static void main(String args[]){
		int i,j;
		i=0;
		j=0;
		Boys b[] = new Boys[1000];
		csv_gen csv_files = new csv_gen();
		csv_files.csv();  
		String csvFile = "boy.csv";
		String line = "";
		String csvSplit = ",";
		BufferedReader buff = null;
		try{
			buff = new BufferedReader(new FileReader(csvFile));
			while((line = buff.readLine() )!= null){
				String[] boys_table = line.split(csvSplit);
			//	System.out.println(boy[0] + boy[1] + boy[2] + boy [3]);
				b[i] = new Boys();
			    b[i].name = boys_table[0];
				b[i].intelligence = Integer.parseInt(boys_table[1]);
				b[i].attractivness = Integer.parseInt(boys_table[2]);
				b[i].min_attr_req = Integer.parseInt(boys_table[3]);
				b[i].budget = Integer.parseInt(boys_table[4]);
				b[i].girlf="";
				b[i].status = boys_table[5];
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
			//	System.out.println(boy[0] + boy[1] + boy[2] + boy [3]);
				g[j] = new Girls();
			    g[j].name = girls_table[0];
				g[j].attar = Integer.parseInt(girls_table[1]);
				g[j].expense = Integer.parseInt(girls_table[2]);
				g[j].intelligence = Integer.parseInt(girls_table[3]);
				g[j].status = girls_table[4];
				g[j].boyf="";
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
		
		int k,l;
		String s[] = new String[100];
		int cnt = 0;
		for(k=0;k<i;k++){
			for(l=0;l<j;l++){
				if(b[k].is_eligible(g[l].expense,g[l].attar) && g[l].is_eligible(b[k].budget) && g[l].status.equals("Single")  && b[k].status.equals("Single") ){
					b[k].girlf = g[l].name;
					g[l].boyf = b[k].name;
					b[k].status = "Is_Committed";
					g[l].status = "Is_Committed";
					if(b[k].status.equals("Is_Committed")){
					s[cnt] = "Boy: "+ b[k].name +" is committed with "+"Girl: "+ b[k].girlf  ;
					}
					
					cnt++;
									
				}
				
			}
		}
		/*! calling logger function in MyLogger class to log the data stored in Array s */
		MyLogger.logger(s,cnt);	
	}
}
