public class Girls {
	String name;
	int attar;
	int expense;
	int intelligence;
	String status;
	String girl_type;
	String boyf;
	double happiness_girl;
	

	boolean is_eligible(int budget){
	if (this.expense <= budget) {
			return true;
		}
	else {
			return false;
		}
	}
	
void happiness(gift gf[],int n){
		
		String type = this.girl_type;
		int i;
		if(type.equals("Choosy")){
								int sum = 0;
								for(i=0;i<n;i++){
										sum += gf[i].gift_price;
										if(gf[i].gift_type.equals("Luxury")){
												sum += 2*(gf[i].gift_value);
											//	System.out.println(sum);
										}
								}
								if(sum > this.expense){
									this.happiness_girl = Math.log(sum - this.expense);
								}
								else{
									this.happiness_girl = 0;
								}
								
		}else if(type.equals("Normal")){
					
								int sum = 0;
								for(i=0;i<n;i++){
										sum = sum +gf[i].gift_price+gf[i].gift_value;
								}
								if(sum > this.expense){
									this.happiness_girl = sum - this.expense;
								}
								else{
									this.happiness_girl = 0;
								}
			
								
		}else if(type.equals("Desperate")){
								int	sum = 0;
								for(i=0;i<n;i++){
										sum +=gf[i].gift_price;
								}
								if(sum > this.expense){
									this.happiness_girl = Math.exp(sum - this.expense);
								}
								else{
									this.happiness_girl = 0;
								}
		
							
			}
	}
	
}


