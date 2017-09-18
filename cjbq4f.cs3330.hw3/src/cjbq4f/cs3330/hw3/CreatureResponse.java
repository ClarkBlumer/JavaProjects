/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.29.2014
 * Section: 	C  
 * Assignment:	Homework 3
 */

package cjbq4f.cs3330.hw3;

public class CreatureResponse {
	private String response;
	private boolean validAction;
	
	/**
	 * Constructor method which calls the set methods for the 
	 * CreatureReponse class attributes to the passed in values
	 * 
	 * @param response
	 * @param validAction
	 */
	public CreatureResponse(String response, boolean validAction) {
		setResponse(response);
		setValidAction(validAction);
	}
	
	/**
	 * Setter method that sets validAction attribute to passed value
	 * @param validAction
	 */
	private void setValidAction(boolean validAction) {
		this.validAction = validAction;
	}
	
	/**
	 * setter method that sets response attribute to passed respone value
	 * @param response
	 */
	private void setResponse(String response) {
		this.response = response;
	}
	
	/**
	 * getter method that returns validAction attribute
	 * @return validAction attribute value
	 */
	public boolean getValidAction() {
		return validAction;
	}
	
	/**getter method that returns response attribute
	 * 
	 * @return response attribute value
	 */
	public String getResponse() {
		return response;
	}
}
