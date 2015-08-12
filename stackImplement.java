
public class stackImplement implements stackADT{
	
	/**
	 * represent the default capacity of the array
	 */
	public final int DEFAULT_CAP = 7;
	
	/**
	 * int representing number of elements and the next position in array
	 */
	private int top;
	
	/**
	 * array of generic elements to represent the stack
	 */
	private double[] stack;
	
	/**
	 * Create an empty stack using default
	 */
	public stackImplement(){
		top = 0;
		stack = new double[DEFAULT_CAP];
	}
	
	/**
	 * create an empty stack using the specified cap.
	 */
	public stackImplement(int number){
		top = 0;
		stack = new double[number];
	}
	
	/**
	 * return top as size of stack
	 */
	public int size(){
		return top;
	}
	
	/**
	 * expand the capacity of the array
	 */
	public void expandCapacity(){
		double[] larger = new double [stack.length * 2];
		
		// set all elements to be now set in the new larger array
		for (int i = 0; i < stack.length; i ++){
			larger[i] = stack[i];
		}
		
		// set larger to become default
		stack = larger;
	}
	
	/**
	 * adds the element to the top of the stack
	 */
	public void push(double mark){
		if (size() == stack.length){
			expandCapacity();
		}
		
		stack[top] = mark;
		top++;
	}
	
	public void push(double mark, double weight){
		double grade = mark * weight;
		
		if (size() == stack.length){
			expandCapacity();
		}
		
		stack[top] = grade;
		top++;
	}
	
	/** 
	 * return true if the stack is empty
	 */
	public boolean isEmpty(){
		return (top == 0);
	}
	
	/**
	 * removes the element on the top of the stack and returning a reference
	 * throw an emptycollection exception if the stack is empty
	 */
	 public double pop() throws EmptyCollectionException{
		 if (isEmpty()){
		      throw new EmptyCollectionException("Stack");
		 }
		 
		 // decrement top
		 top--;
		 // store stack[top] element into result
		 double result = stack[top];
		 //set element to 0.0
		 stack[top] = 0.0;
		 
		 return result;
	 }
	 
	 /**
	  * returns a reference to the element at the top of the stack. Element is not removed from the stack
	  */
	 
	 public double peek(){
		 if (isEmpty()){
			 throw new EmptyCollectionException("Stack");
		 }
		 
		 return stack[top-1];
	 }
}
