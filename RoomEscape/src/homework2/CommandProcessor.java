/* Name:		Clark Blumer
 * Date:		10.06.2014
 * Section: 	C  
 */
package homework2;
import java.util.ArrayList;


public class CommandProcessor {
	private ArrayList<String> commands;
	
	/**
	 * Constructor method
	 */
	public CommandProcessor() {
		setGameCommands();
	}
	
	/**
	 * Setter method that instantiates a new GameDataReader object 
	 * and sets commands attribute to that object
	 */
	private void setGameCommands() {
		GameDataReader gameCommands = new GameDataReader();
		commands = gameCommands.getGameCommands("GameData/Commands.txt");
		
	}
	
	/**
	 * Method checks to make sure the entered command is in the ArrayList of commands	
	 * @param command user entered command
	 * @return true if user entered command was in ArrayList, false if not
	 */
	public boolean validateCommand(String command) {
		for(int i = 0; i < commands.size(); i++) {
			/* sets everything to lower case.  if command@i is same as passed value
			 * return true */
			if(commands.get(i).toLowerCase().equals(command.toLowerCase()))
				return true;
		}
		return false;
	}
	
	/**getter method for the commands attribute
	 * 
	 * @return commands arraylist
	 */
	public ArrayList<String> getCommands() {
		return commands;
	}
}
