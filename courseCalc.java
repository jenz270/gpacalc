/**
 * courseCalc calculates the course average
 * @author jhou25
 *
 */

public class courseCalc{
	//Instance variables
	private stackImplement stack; 
	
	//Constructor
	public courseCalc(stackImplement implement){
		stack = implement;
	}
	
	/**
	 * Get the Average 
	 * @return
	 */
	public double getAverage(){
		double total = 0.0;
		int length = stack.size();
		
		for(int x = 0; x < length; x ++){
			total = total + stack.pop();
		}
		
        return total;
	}


	public static void main(String[] args) {
		
		//Let user enter a number, number of evaluation methods
       stackImplement stack = new stackImplement(5);
        
        // let user add mark and weight
        stack.push(60.3, 0.2);
        stack.push(79.3, 0.2);
        stack.push(89.2, 0.2);
        stack.push(84.7, 0.2);
        stack.push(92.5, 0.2);
        
        //get the mark
        courseCalc calc = new courseCalc(stack);
        
        //display the mark
        System.out.println("Your average is: " + calc.getAverage() + "%");
        
	}

}
