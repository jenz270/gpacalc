
public class EmptyCollectionException extends RuntimeException{
	
	/**
	 * set up the exception with an appropriate message
	 */
	public EmptyCollectionException(String collection){
		super("The" + collection + " is empty.");
	}
}
