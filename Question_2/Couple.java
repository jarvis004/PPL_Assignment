import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Couple {
	
	Boys boy;
	Girls girl;
	int affinity;
	double happiness=0;
	gift gift_gf[];

	Couple(Boys boy,Girls girl){
		this.boy = boy;
		this.girl = girl;
		this.affinity = 0;
		this.happiness = 0;
		}
	
	void calc_happiness(){
		float mix = 1;
		float max = 100;
		
		Random happi = new Random();
		float  h = happi.nextFloat()*(max-mix)+max; 
		this.happiness = h;
		
	}
	
	void calc_affinity(){
		int x = Math.abs(boy.budget - girl.expense);
		int y = Math.abs(boy.attractivness - girl.attar);
		int z = Math.abs(boy.intelligence - girl.intelligence);
	
		this.affinity = x+y+z;
	}
	void calc_gifts(gift gf[],int n) throws IOException{
			
			
			
			String df= new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(new Time(System.currentTimeMillis()));
			String output = "";			
			this.gift_gf = new gift[50];
			File out=new File("log.txt");
			String type = this.boy.boy_type;
			int gift_count = 0;
			int i;
			if(type.equals("Miser")){
				
					int sum = 0;
					
					for(i=0;i<n;i++){
						if(sum <this.girl.expense ){
							output = df + "-" + this.boy.name + " --------------> "+ this.girl.name +" "+gf[i].gift_name +"\n" ;
							System.out.println(output);
							try(BufferedWriter buffer=new BufferedWriter(new FileWriter(out,true))){
		                    	buffer.write(output);
		                    	
							}
							
							
							sum += gf[i].gift_price;
							this.gift_gf[gift_count++] =gf[i]; 
						}
						else
							break;
				}
					this.boy.budget = Math.max(this.boy.budget,sum);
					this.boy.happiness_boy = this.boy.budget-sum;
				
					this.girl.happiness(gift_gf,gift_count);
					
					
					
					}
					
			else if(type.equals("Generous")){
				
						int sum =0;
						int l;
					
						for(l=n-1;l>=0;l--){
							if(sum<this.boy.budget){
								
								output = df + "-" + this.boy.name + " --------------> "+ this.girl.name+" "+gf[l].gift_name  +"\n" ;
								System.out.println(output);
								try(BufferedWriter buffer=new BufferedWriter(new FileWriter(out,true))){
			                    	buffer.write(output);
			                    	
								}
								sum += gf[l].gift_price;
							}
							else
								break;
						}
						this.boy.budget = Math.max(this.boy.budget,sum);
						this.girl.happiness(gift_gf,gift_count);
						this.boy.happiness_boy = (int)this.girl.happiness_girl;
				
						
						
						
						

			}else if(type.equals("Geeky")){
				
						int sum=0;
					//	System.out.println("hi");
						for(i=0;i<n;i++){
							if(sum <this.girl.expense ){
								
								output =df + "-" + this.boy.name + " --------------> "+ this.girl.name+" "+gf[i].gift_name       +"\n" ;
								System.out.println(output);
								try(BufferedWriter buffer=new BufferedWriter(new FileWriter(out,true))){
			                    	buffer.write(output);
			                    	
								}
								sum += gf[i].gift_price;
								this.gift_gf[gift_count++] = gf[i]; 
							}
							else
								break;
					}
						boolean flag = false;
						this.boy.budget = Math.max(this.boy.budget,sum);
						for(i=0;i<n;i++){
							if ((gf[i].gift_type.equals("Luxury")) && (this.boy.budget- sum ) > gf[i].gift_price){
								for(gift p : gift_gf){
									if(gf[i] == p){
										flag = true;
									}
								}
								if(flag == true){
									continue;
								}
								else{
									sum += gf[i].gift_price;
									gift_gf[gift_count++] =gf[i];
									break;
								}
							}
						}
						
						this.boy.happiness_boy = this.girl.intelligence;
					
						this.girl.happiness(gift_gf,gift_count);
						
						
						
					}
					
			
			
		}
}
