/**
 * This exception class object is thrown when an illegal allele is found
 */
package workshop.panel.hml;

/**
 * @author kazu
 * @version May 2 2017
 *
 */
public class IllegalAlleleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public IllegalAlleleException() {
		// TODO Auto-generated constructor stub
		System.err.println("Illegal allle is found!");
	}

	/**
	 * @param arg0
	 */
	public IllegalAlleleException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		System.err.println(message + ": Illegal allle!!!");
	}

	/**
	 * @param arg0
	 */
	public IllegalAlleleException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public IllegalAlleleException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
