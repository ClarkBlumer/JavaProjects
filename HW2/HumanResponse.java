package solution.cs3330.hw2;

public class HumanResponse {
	private String response;
	private boolean validAction;
	
	public HumanResponse (String response, boolean validAction) {
		setResponse(response);
		setValidAction(validAction);
	}

	public boolean getValidAction() {
		return this.validAction;
	}

	public void setValidAction(boolean validAction) {
		this.validAction = validAction;
	}

	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
