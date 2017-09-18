package solution.cs3330.hw2;

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
		
		while (roomsBeat < maxRooms) {
			/*
			 * Create room bad guys and items
			 */
			System.out.println("Entering Room " + (roomsBeat + 1));
			System.out.println(" ");
			initCurrentRoomBeasts();
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
					System.out.println("You have discoverd the item " + foundItem.getName());
					while (noBattle(foundItem)); 
					
				}
				else {
					foundEnemy = findEnemy();
					System.out.println("You have encounterd a(n) " + foundEnemy.getName());
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
	 * Allows the current player to engage in combat with the incoming beast. The player uses 
	 * item from his bag to kill the enemy. 
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
			HumanResponse response = currentPlayer.processCommand(attackString, battlingBeast,null);
			if (!response.getValidAction()) {
				System.out.println(response.getResponse());
			}
			if (currentPlayer.isLiving() && !battlingBeast.isLiving()) {
				System.out.println(battlingBeast.getName() + " is killed");
				System.out.println(" ");
				return true;
			}
			else {
				System.out.println(battlingBeast.getName() + " HP: " + battlingBeast.getHealth());
			}
		}
		return false;
	}
	
	private static void displayBagContents () {
		System.out.println("Contents of Bag:");
		System.out.println("Name      HitPoints    Weight");
		System.out.println(" ");
		Bag playerBag = currentPlayer.getBag();
		for (Item i : playerBag.getItems()) {
			System.out.printf("%-10s%6d%10d\n", i.getName(),i.getValue(),i.getWeight());
		}
		System.out.println(" ");
	}
	
	/**
	 * Allows the player to run the following game commands "pickup" on the found item, view the player bag contents,
	 * "drop" an item from there bag, show the game commands using "help", "ignore" current item, and "quit" the game.
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
		HumanResponse response = currentPlayer.processCommand(input, null,foundItem);
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
	
	private static Item findItem() {
		int itemIdx = randomGenerator.nextInt(gameItems.size());
		int move_iterations = randomGenerator.nextInt(3) + 1;
		
		int i = 0;
		do{
			System.out.println("Searching area...");
			
		} while(i++ < move_iterations);
		
		return gameItems.get(itemIdx);
	}

	private static Beast findEnemy() {
		int beastIdx = randomGenerator.nextInt(currentRoomBeasts.size());
		int move_iterations = randomGenerator.nextInt(3) + 1;
		
		int i = 0;
		do{
			System.out.println("Searching area...");
			
		} while(i++ < move_iterations);
		
		Beast foundBeast = currentRoomBeasts.get(beastIdx);
		while (!foundBeast.isLiving()){
			beastIdx = randomGenerator.nextInt(currentRoomBeasts.size());
			foundBeast = currentRoomBeasts.get(beastIdx);
		} 
		
		return currentRoomBeasts.get(beastIdx);
	}

	private static void initCurrentRoomBeasts () {
		currentRoomBeasts = new ArrayList<Beast>();
		for (Beast b : gameBeasts) {
			currentRoomBeasts.add(b); 
		}
	}
	
	private static void initGameData() {
		userInput = new Scanner(System.in);
		randomGenerator = new Random(1337);
		GameDataReader gameDataReader = new GameDataReader();
		gameItems = gameDataReader.getGameItems("GameData/GameItems.csv");
		gameBeasts = gameDataReader.getGameBeasts("GameData/GameBeasts.csv");
		
	}
}
