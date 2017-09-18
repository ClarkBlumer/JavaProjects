package Scavenger;
/**
 * 
 */

import java.util.Random;
/*
 * Name:
 * Date:
 * Section:
 * Submission Code: 
 * 
 */


import java.util.Scanner;

public class Scavenger {
	
	private static Scanner userInput; 			// The object used for collecting and parsing user input from the keyboard
	private static Item[] playerItems; 			// An array of type Item used to hold the collected items from the gameItems
	private static Item[] gameItems; 			// An array of type item that holds all the possible items the game has available
	private static Command[] gameCommands; 		// An array of type Command that holds the game commands
	private static int currentPlayerItemsIdx; 	// An integer used to keep track of the current empty index in the playerItems array
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initGameDataAndArray();
		System.out.print("Enter a name: ");
		String name = userInput.nextLine();
		
		System.out.println("Welcome to the Scavenger Game " + name);
		System.out.println("");
		
		while(currentPlayerItemsIdx < playerItems.length) {
			Item foundItem = scavengeArea();
			
			System.out.println("Item found: " + foundItem.getName());
			String[] splitStrings = null;
			
			do {
				System.out.print("Command: ");
				String input = userInput.nextLine();
				
				splitStrings = input.split(" ");
				while(!validCommand(splitStrings)) {
					System.out.print("Invalid Try Again, Command: ");
					input = userInput.nextLine();
					
					splitStrings = input.split(" ");
				}
			}while(!runCommand(splitStrings[0], foundItem));
		}
		
		displayPlayerItems();
		PlayerItemsStats();

	}

	/**
	 *	Initializes all the private attributes in the program.
	 */
	public static void initGameDataAndArray() {
		userInput = new Scanner(System.in);
		playerItems = new Item[10];
		
		// Sets every item in playerItems[] name to 'empty', value to zero, and weight to 0;
		for(int i = 0; i < playerItems.length; ++i) {
			playerItems[i] = new Item("empty", 0, 0);
		}
		
		GameDataReader gameItemsArray = new GameDataReader();
		gameItems = gameItemsArray.getGameItems();
		currentPlayerItemsIdx = 0;
		
		// sets gameCommands to a Command[] array and initializes with Command objects
		gameCommands = new Command[]{new Command("help"), new Command("pickup"), 
				new Command("drop"), new Command("view"), new Command("quit")};
		
	}
	
	/**
	 * method used to return a random itemm in the gameItems array based on random index
	 * 
	 * @return an item in the gameItems array at index randItem
	 */
	private static Item scavengeArea() {
		Random rand = new Random();
		int randSearchNumber = rand.nextInt(4) + 1; // Search 1 - 4 times for item
		int randItem = rand.nextInt(gameItems.length);
		
		for(int i = 0; i < randSearchNumber; i++) {
			System.out.println("Scavenging the area for an item...");
			
		}
		return gameItems[randItem];
	}
	
	/**
	 * Method used to determine which method to call based on user input
	 * 
	 * @param commandName passed in String value from the console
	 * @param item randomly picked item 
	 * @return true if interacting with item, false if not.
	 */
	public static boolean runCommand(String commandName, Item item) {
		
		/* takes passed in commandName, switches to lower case and then checks against
		*  cases in the switch to determine which methods to call */
		switch(commandName.toLowerCase()) {
			case "help":
				displayGameCommands();
				return false;
			case "pickup":
				addItemToPlayerItems(item);
				System.out.println("\nItem successfully added.\n");
				return true;
			case "quit":
				System.out.println("\nGame terminated\n");
				System.exit(0);
			case "drop":
				System.out.println("\nItem not added\n");
				return true;
			case "view":
				displayPlayerItems();
				return false;
			default:
				break;
		}
		return false;
		
	}
	
	/**
	 * Displays the values of playerItems
	 */
	public static void displayPlayerItems() {
		//if currentIdx is 0, means nothing is in the bag
		if(currentPlayerItemsIdx == 0)
			System.out.println("Bag is empty");
		else		
			//if index isnt 0, display items in playerItems via getName, getValue
			for(int i = 0; i < playerItems.length; i++) {
				System.out.println(playerItems[i].getName() + " " + playerItems[i].getValue());
			}
	}
	
	/**
	 * Displays game commands
	 */
	public static void displayGameCommands() {
		for(int i = 0; i < gameCommands.length; i++) {
			System.out.println(gameCommands[i].getCommandName());
		}
	}
	
	/**
	 * 
	 * @param splitStrings array of values from the input
	 * @return true if splitStrings[0] matches a gameCommand, false if not
	 */
	public static boolean validCommand(String[] splitStrings) {
		/* Loop checks the value at splitStrings[0] to every index of gameCommands name value */
		for(int i = 0; i < gameCommands.length; i++) {
			if(splitStrings[0].equals(gameCommands[i].getCommandName()))
				return true;
		}
		return false;
	}
	
	/**
	 * Method used to determine if the user can add an Item object to the playerItems array
	 * 
	 * @param item passed in Item object
	 * @return false if no room in bag, true if bag has space
	 */
	public static boolean addItemToPlayerItems(Item item) {
		if(currentPlayerItemsIdx >= playerItems.length)
			return false;
		else {
			//adds passed in item to the currentIdx of playerItem array and increments currentIdx by 1
			playerItems[currentPlayerItemsIdx] = item;
			currentPlayerItemsIdx++;
			return true;
		}
	}
	
	/**
	 * Method used to determine total value of items, lightest item, and heaviest item
	 * in playerItems array and displays values to console.
	 */
	public static void PlayerItemsStats(){
		int sumValue = 0;
		int sumWeight = 0;
		int minWeight = 500; // set to above heaviest item so minWeight is changed to an Item's weight value
		int maxWeight = 0;
		
		/* Sum of item values */
		for(int i = 0; i < playerItems.length; i++) {
			sumValue += playerItems[i].getValue();
		}
		
		/* Sum of item weights */
		for(int e = 0; e < playerItems.length; e++) {
			sumWeight += playerItems[e].getWeight();
		}
		
		/* minimum weight item */
		for(int j = 0; j < playerItems.length; j++) {
			if(minWeight > playerItems[j].getWeight())
				minWeight = playerItems[j].getWeight();
		}
	
		/* Maximum value item */
		for(int k = 0; k < playerItems.length - 1; k++) {
			if(maxWeight < playerItems[k].getWeight())
				maxWeight = playerItems[k].getWeight();
		}
		
		/* Print to screen values */
		System.out.println("Player Item Stats: Total Weight is " + sumWeight + 
						   " Total Value is " + sumValue + 
						   ". Min weight found is " + minWeight + 
						   ". Max weight found is " + maxWeight + ".");
	}
		
}
