/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.29.2014
 * Section: 	C  
 * Assignment:	Homework 3
 */
package cjbq4f.cs3330.hw3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class RoomEscape {
	private static Scanner userInput;
	private static ArrayList<Item> gameItems;
	private static ArrayList<Beast> gameBeasts;
	private static ArrayList<Beast> currentRoomBeasts;
	private static Human currentPlayer;
	private static Random randomGenerator;
	
	public static void main(String[] args) {
		initGameData();
    	System.out.print("Enter Character Name: ");
    	String name = userInput.nextLine();
    	System.out.print("Enter number of levels: ");
    	int maxRooms = Integer.parseInt(userInput.nextLine());
        
    	currentPlayer = new Human(name,100, new Bag());
    	int roomsBeat = 0;
    	
    	/* Check to make sure the ArrayLists were filling */
    	/*for(int i = 0; i < gameItems.size(); i++) {
    		System.out.println(gameItems.get(i).getName() + " " + gameItems.get(i).getValue() + " " + gameItems.get(i).getWeight());
    	}
    	for(int i = 0; i < gameBeasts.size(); i++) {
    		System.out.println(gameBeasts.get(i).getName() + " " + gameBeasts.get(i).getHealth() );    		
    	}*/
    	    	 
        
    	while (roomsBeat < maxRooms) {
    		/*
             * Create room bad guys and items
             */
            System.out.println("Entering Room " + (roomsBeat + 1));
            System.out.println(" ");
            initCurrentGameRoom();
            int creaturesDestroyed = 0;
                
            while (currentPlayer.isLiving() && creaturesDestroyed < 2) {
            	int encounterProb = randomGenerator.nextInt(100);
                Item foundItem = null;
                Beast foundEnemy = null;
                /*
                 * 60 percent chance of being a Beast.
                 */
                 if (encounterProb <= 40) {
                	 foundItem = findItem();
                     System.out.println("You have discovered the item " + foundItem.getLevel() + " " + foundItem.getName());
                     while (noBattle(foundItem)); 
                                
                 }
                 else {
                	 foundEnemy = findEnemy();
                     System.out.println("You have encountered a(n) " + foundEnemy.getLevel() + " " + foundEnemy.getName());
                     if (battle (foundEnemy)) {
                             creaturesDestroyed++;
                     }
                     else {
                    	 System.out.println("You are dead!");
                         return;
                     }
                  }
             }
             roomsBeat++;
        }
        System.out.println("You have beat RoomEscape!");
	}
	
	/**
	 * Initializes class attributes and instantiates new Objects
	 */
	private static void initGameData() {
		userInput = new Scanner(System.in);
		randomGenerator = new Random(1337);
		GameDataReader dataReader = new GameDataReader();
		gameItems = dataReader.getGameItems("GameData/GameItems.csv");
		gameBeasts = dataReader.getGameBeasts("GameData/GameCreatures.csv");
	}
	
	private static void initCurrentGameRoom() {
		currentRoomBeasts = new ArrayList<Beast>();
		for(int i = 0; i < gameBeasts.size(); i++) {
			currentRoomBeasts.add(new Beast(gameBeasts.get(i).getLevel(), 
								  			gameBeasts.get(i).getName(), 
								  			gameBeasts.get(i).health.getHealthPoints(), 
								  			gameBeasts.get(i).getBag()));
		}
	}
	
	private static Item findItem() {
		int randItem = randomGenerator.nextInt(gameItems.size());
		int randSearchNumber = randomGenerator.nextInt(3) + 1; // Search 1 - 4 times for item

		for(int i = 0; i <= randSearchNumber; i++) {
			System.out.println("Searching area...");
			
		}
		return gameItems.get(randItem);		
	}
	
	private static Beast findEnemy() {
		int randBeast = randomGenerator.nextInt(gameBeasts.size());
		return currentRoomBeasts.get(randBeast);
	}
	
    /**
     * Allows the current player to engage in combat with the incoming beast. The player uses 
     * items from his bag to kill the enemy. 
     * 
     * @param battlingBeast The found beast the player has encountered
     * @return Whether the currentPlayer is dead being false or alive being true.
     */
    private static boolean battle (Beast battlingBeast) {
            
            while (currentPlayer.isLiving()) {
                    displayBagContents();
                    String attackString = "attack " + battlingBeast.getName() + " with ";
                    System.out.print(attackString);
                    String input = userInput.nextLine();
                    System.out.println(" ");
                    
                    attackString += input;
                    CreatureResponse response = currentPlayer.processCommand(attackString, battlingBeast,null);
                    if (!response.getValidAction()) {
                            System.out.println(response.getResponse());
                    }
                    if (currentPlayer.isLiving() && !battlingBeast.isLiving()) {
                            System.out.println(battlingBeast.getName() + " is killed");
                            System.out.println(" ");
                            return true;
                    }
                    else {
                            System.out.println(battlingBeast.getName() + " HP: " + battlingBeast.getHealth().getHealthPoints());
                            /* Monster fights back! */
                            System.out.println(battlingBeast.getLevel() + " " + battlingBeast.getName() + " attacked you with " + battlingBeast.bag.getItem(1).getLevel() + " " + battlingBeast.bag.getItem(1).getName());
                            currentPlayer.injured(battlingBeast.bag.getItem(1));
                    }
            }
            return false;
    }
    
    /**
     * Displays the contents of the bag to player
     *
     */
    private static void displayBagContents () {
    	System.out.println("\nPlayer Health: " + currentPlayer.getHealth().getHealthPoints());
            System.out.println("Contents of Bag:");
            System.out.println("# Type      Name                  Points   Weight");
            Bag playerBag = currentPlayer.getBag();
            int j = 1;
            String type = "";
            for (Item i : playerBag.getItems()) {
            	if(i instanceof Weapon)
            		type = "WEAPON";
            	else
            		type = "HEALER";
                System.out.printf("%d %-10s%-10s%-10s%6d%9d\n", j++, type, i.getLevel(), i.getName(), i.getPoints(), i.getWeight());
            }
            System.out.println(" ");
    }
    
    /**
     * Allows the player to run the following game commands "pickup" on the found item, “view” the player bag contents,
     * "drop" an item from their bag, show the game commands using "help", current item, and the enter key allow you to skip past an item (the string is empty).
     *  
     * 
     * @param foundItem An instantiated Item that the player has found
     */
    
    private static boolean noBattle (Item foundItem) {
            displayBagContents();
            System.out.print("Command: ");
            String input = userInput.nextLine();
            if (input.isEmpty()) {
                    return false;
            }
            CreatureResponse response = currentPlayer.processCommand(input, null,foundItem);
            while (!response.getValidAction()) {
                    System.out.print(response.getResponse() + ", Try Again: ");
                    input = userInput.nextLine();
                    response = currentPlayer.processCommand(input, null,foundItem);                
                    if (input.isEmpty()) {
                            return false;
                    }
            }        
            System.out.println(response.getResponse());
            return true;
    
    }
}

