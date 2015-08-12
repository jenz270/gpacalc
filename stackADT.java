/**
 * Defines the interface to a stack data structure
 * @author jhou25
 *
 */
public interface stackADT
{
	/**
	 * Adds one element to the top of this stack
	 * @param element
	 */
	public void push(double element);
	
	/**
	 * Removes and returns the top element from this stack
	 * @return
	 */
	public double pop();
	
	/**
	 * Returns without removing the top element of this stack
	 */
	public double peek();
	
	/**
	 * Returns true if this stack contains no elements
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the number of elements in this stack
	 */
	public int size();
	
	/**
	 * Returns a string representation of this stack
	 * 
	 */
	public String toString();
}
