package homework2;
/* Name:		Clark Blumer
 * Date:		10.06.2014
 * Section: 	C  
 */
public class HumanResponse {
	private String response;
	private boolean validAction;
	
	public HumanResponse(String response, boolean validAction) {
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
