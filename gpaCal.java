/**
 * gpaCal calculate the gpa
 * @author jhou25
 *
 */
public class gpaCal {
	
	private stackImplement marks;


	public gpaCal(stackImplement marks){
		this.marks = marks;
	}
	
	// Calculates GPA 
	public double calcGpa(){
		
		// sets a few variables
		double result = 0.0;
		double percentage;
		double gpa = 0.0;
		double length = marks.size();
	    //1. Check if stack is empty
		//2. pop all grades then store into percentage
		//3. check if percentage falls in between a certain range
		//4. return the GPA
		
		for ( int i = 0; i < length; i ++){
			result =  result + marks.pop();
		}
		
		 percentage = result / length;
		 
		 if (percentage <= 100 && percentage >= 90){
			 return gpa = 4.0;
		 }
		 else if (percentage <= 89 && percentage >= 80){
			 return gpa = 3.49;
		 }
		 else if (percentage <= 79 && percentage >= 70){
			 return gpa = 2.49;
		 }
		 else if (percentage <= 69 && percentage >= 60){
			 return gpa = 1.49;
		 }
		 else if (percentage <= 59 && percentage >= 50){
			 return gpa = 0.99;
		 }
		 else {
			 return gpa = 0.0;
		 }
	}
	
	
	public static void main(String[] args) {
		
		// create new stack
		stackImplement implement = new stackImplement(5);
		implement.push(90.2);
		implement.push(23);
		implement.push(78.2);
		implement.push(89.3);
		implement.push(72.2);
		
		// create new gpa calc
		gpaCal calc = new gpaCal(implement);
		
		// print out GPA
		System.out.println(calc.calcGpa());
	}

}
