/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.29.2014
 * Section: 	C  
 * Assignment:	Homework 3
 */

package cjbq4f.cs3330.hw3;

import java.util.ArrayList;

public abstract class GameCreature implements Creature{
	private String name;
	protected Bag bag;
	protected Health health;
	private CommandProcessor commandProcessor;
	
	/**
	 * 
	 * @param name String valued passed from GameDataReader, from the CSV file
	 * @param hp int value passed from GameDataReader, from the CSV file
	 * @param emptyBag Bag value passed from GAmeDataReader, from the CSV file
	 */
	public GameCreature(String name, int hp, Bag emptyBag) {
		initCommandProcessor();
		initBag(emptyBag);
		setName(name);
		createHealth(hp);
	}
	
	/**
	 * Set method used to set the class attribute value for name
	 * 
	 * @param name String value used to set the class attribute name
	 */
	private void setName(String name) {this.name = name;}
	/**
	 * Get method used to access the value of the class attribute name
	 * 
	 * @return String value of the class attribute name
	 */
	public String getName() {return this.name;}
	
	/**
	 * Initialize the commandProcessor attribute with a new CommandProcessor object
	 */
	private void initCommandProcessor() {
		this.commandProcessor = new CommandProcessor();
	}
	
	/**
	 * Initializes the class attribute of bag to the contents of Bag emptyBag value
	 * 
	 * @param Bag value
	 */
	private void initBag(Bag emptyBag) {
		this.bag = emptyBag;
	}
	
	/**
	 * Initialize the class attribute health value with the passed in int hp value
	 * 
	 * @param hp Int value
	 */
	private void createHealth(int hp) {
		this.health = new Health(hp);
	}
	
	/**
	 * Method checks the entered commands to see if they match the commands from the Commands.txt file.
	 * If the entered command is one that matches one in the file, then execute a block of code based on 
	 * the command entered.
	 * 
	 * @param commands String value used to check if entered command is valid or not
	 * @param creature GameCreature object which can be the player or the beast
	 * @param item Item object used for healing/attacking
	 * @return a CreatureResponse object with a response and a boolean value of valid command or not
	 */
	public CreatureResponse processCommand(String commands, GameCreature creature, Item item) {
		String response = "";
		boolean validAction = true;
		String[] splitCommands = commands.split(" ");
		
		/* if entered command is not valid */
		if(!commandProcessor.validateCommand(splitCommands[0]))
			return new CreatureResponse("Invalid game command", false);
		/* if command was valid compare splitCommands[] array to commands */
		/* if entered command is "attack" */
		if (splitCommands[0].equalsIgnoreCase("attack") && splitCommands.length >= 4 && 
			splitCommands[2].equalsIgnoreCase("with")) {
			Item weapon = this.bag.getItem(splitCommands[3]);
			if (!this.attack(creature, weapon)) {
				response = "Not a valid weapon";
				validAction = false;
				}
			else {
				creature.injured(weapon);
			}
		}				
		/* if entered command is "pickup" */	
		else if(splitCommands[0].equalsIgnoreCase("pickup")) {
			/* if statement checks to see if pickup() succeeded or not */
			if(pickup(item)) {
				response = "Item added successfully";				
			}
			else {
				response = "Item not added successfully";
				validAction  = false;
			}
		}
		/* if entered command is "drop" */
		else if(splitCommands[0].equalsIgnoreCase("drop") && splitCommands.length == 2) {
			if(drop(bag.getItem(splitCommands[1]))){
				response = "Item successfully dropped";
			}
			else {
				response = "Item not successfully dropped";
				validAction = false;
			}
		}
		/* if entered command is "drop" with an index */
		else if(splitCommands[0].equalsIgnoreCase("drop") && splitCommands.length >= 3) {
			int index = Integer.parseInt(splitCommands[2]); // takes the last element in the splitCommands[] array entered and uses 
			Item itemToDrop = this.bag.getItem(index - 1); // it to discard the item chosen. index - 1 because the list is shown starting with 1
			this.bag.dropItem(itemToDrop);
		}
		
		/* if entered command is "heal" */
		else if (splitCommands[0].equalsIgnoreCase("heal") && splitCommands.length >= 3 && 
				splitCommands[1].equalsIgnoreCase("with")) {
				Item healerItem = this.bag.getItem(splitCommands[2]); // splitCommands[2] is the item entered
				if(!(healerItem instanceof Healer)) {
					response = "Not a valid heal item";
					validAction = false;
					}
				else if(healerItem.getName().equalsIgnoreCase(splitCommands[2])){
					/* updates health with the healer item's points value. 
					 * And then discards the item as in being used. */
					this.health.heal(healerItem.getPoints());
					this.bag.dropItem(healerItem);
					response = "Health item used";
				}
		}
		/* if entered command is "help" */
		else if(splitCommands[0].equalsIgnoreCase("help")) {
			ArrayList<String> help = commandProcessor.getCommands();
			for(int i = 0; i < help.size(); i++)
				response = help + "\n";
		}
		/* if entered command is "runaway" */
		else if(splitCommands[0].equalsIgnoreCase("runaway")) {
			/* calls dropAll() which removes all items from inventory. */
			dropAll();
			response = "Fled and dropped all items.";
		}
		return new CreatureResponse(response, validAction);		
	}
	
	/**
	 * Boolean method used to determine damage done to player and beast.
	 * Checks if the passed item is null or not. If not, update health by
	 * subtracting the item.getPoints() value from health.  Return false 
	 * if the item is null.
	 */
	public boolean injured(Item item) {
		if(item != null) {
			health.hit(item.getPoints());
			return true;
		}
		return false;
	}
	
	/**
	 * Boolean method which returns true or false based on healthPoints value
	 * 
	 * @return true if health >0, false if health <= 0 
	 */
	public boolean isLiving() {
		return health.getAlive();
	}
	
	/**
	 * Get method for the class attribute bag's value
	 * 
	 * @return Bag value of the class attribute bag
	 */
	public Bag getBag() {return this.bag;}
	/**
	 * Get method for the class attribute health's value
	 * 
	 * @return Health value of the class attribute health
	 */
	public Health getHealth() {return this.health;}
}
