/**
 * 
 */
package com.viruksham.apps.tradefinapp.exceptions;

/**
 * @author bala
 *
 */
public class DataMismatchException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8525942472607065656L;

	private int excptionId = 1000;
	private String message;

	public DataMismatchException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return excptionId+": "+message;
	}
}
