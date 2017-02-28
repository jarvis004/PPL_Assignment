/*! Girls class*/
public class Girls {
	String name;
	int attar;
	int expense;
	int intelligence;
	String boyf;
	String status;
	
/*! boolean type is_eligible function to check conditions */
	boolean is_eligible(int budget){
	if (this.expense <= budget) {
			return true;
		}
	else {
			return false;
		}
	}
	
}
