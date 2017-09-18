package homework2;

import java.util.ArrayList;

/* Name:		Clark Blumer
 * Date:		10.06.2014
 * Section: 	C  
 */
public class Human {
	private String name;
	private Bag bag;
	private Health health;
	private CommandProcessor commandProcessor;
	
	/**Constructor method that initializes all the attributes
	 * using setter and init methods
	 * 
	 * @param name player name
	 * @param hp health
	 * @param emptyBag
	 */
	public Human(String name, int hp, Bag emptyBag) {
		setName(name);
		createHealth(hp);
		initBag(emptyBag);
		initCommandProcessor();
	}
	
	/**
	 * init method for commandProcessor attribute.
	 * Instantiates a new CommandProcessor object
	 */
	private void initCommandProcessor() {
		this.commandProcessor = new CommandProcessor();
	}
	
	/**
	 * init method for bag attribute
	 * Initializes an empty bag and then fills with a new Item object
	 * @param emptyBag
	 */
	private void initBag(Bag emptyBag) {
		this.bag = emptyBag;
		bag.addItem(new Item("Crowbar", 30, 5));
	}
	
	/**
	 * setter method for health attribute.
	 * Sets it to passed in value hp by calling the Health object constructor
	 * @param hp
	 */
	private void createHealth(int hp) {
		this.health = new Health(hp);
	}
	
	/**
	 * Processes the commands from the user and determines what to do based on
	 * the entered command.
	 * 
	 * @param commands passed string value
	 * @param beast passed Beast object
	 * @param item pass Item object
	 * @return a HumanResponse object that lets the user know if command was processed correctly or not
	 */
	public HumanResponse processCommand(String commands, Beast beast, Item item) {
		String response = "";
		boolean validAction = true;
		String[] splitCommands = commands.split(" ");
		
		/* if entered command is not valid */
		if(!commandProcessor.validateCommand(splitCommands[0]))
			return new HumanResponse("Invalid game command", false);
		/* if command was valid compare splitCommands[] array to commands */
		/* if entered command is "attack" */
		if (splitCommands[0].equals("attack") && splitCommands.length >= 4 && 
			splitCommands[2].equals("with")) {
			Item weapon = this.bag.getItem(splitCommands[3]);
			if (!this.attack(beast,weapon)) {
				response = "Not a valid weapon";
				validAction = false;
				}
		}				
		/* if entered command is "pickup" */	
		else if(splitCommands[0].equals("pickup")) {
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
		else if(splitCommands[0].equals("drop") && splitCommands.length >= 2) {
			if(drop(bag.getItem(splitCommands[1]))){
				response = "Item successfully dropped";
			}
			else {
				response = "Item not successfully dropped";
				validAction = false;
			}
		}
		/* if entered command is "help" */
		else if(splitCommands[0].equals("help")) {
			ArrayList<String> help = commandProcessor.getCommands();
			for(int i = 0; i < help.size(); i++)
				response = help + "\n";
		}
		return new HumanResponse(response, validAction);
		
	}
	
	/**
	 * Attempts to pick up the passed Item object
	 * @param item passed Item object
	 * @return true if addItem worked and false for not
	 */
	public boolean pickup(Item item) {
		return bag.addItem(item);		
	}
	
	/**Attempts to drop passed Item object
	 * 
	 * @param item
	 * @return true if dropItem worked and false for not
	 */
	public boolean drop(Item item) {
		return bag.dropItem(item);
	}
	
	/**
	 * Attempts to injure the beast by passing the Item to the injured method
	 * in Beast
	 * @param beast
	 * @param item
	 * @return true if it was injured, false for not
	 */
	public boolean attack(Beast beast, Item item) {
		return beast.injured(item);
	}
	
	/**
	 * Calls the getAlive() method on health attribute
	 * @return true if alive, false for not
	 */
	public boolean isLiving() {
		return health.getAlive();
	}
	
	/**Gets the contents of the bag
	 * 
	 * @return the bag object
	 */
	public Bag getBag() {
		return bag;
	}
	
	/**setter method to set the name attribute to passed in name
	 * 
	 * @param name
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/**getter method to get the class' name attribute
	 * 
	 * @return attribute name value
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * getter method to get the health attribute
	 * @return health attribute value
	 */
	public Health getHealth() {
		return health;
	}
	
}
