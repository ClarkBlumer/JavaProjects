/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.29.2014
 * Section: 	C  
 * Assignment:	Homework 3
 */
package cjbq4f.cs3330.hw3;
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
			/* if command@i is same as passed value
			 * return true */
			if(commands.get(i).equalsIgnoreCase(command))
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
