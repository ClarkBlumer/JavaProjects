package Scavenger;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GameDataReader {
	
	public GameDataReader() {
		
	}
	
	/**
	 * Method reads a CSV file and fills an Item[] array based on input from the CSV
	 * file using split() to split lines.
	 * 
	 * @return a filled Item[] array
	 */
	public Item[] getGameItems() {
		String csvFile = "GameData/gameItems.csv";
		File file = new File(csvFile);
		Item[] itemsArray = new Item[25];
		
		try {
			Scanner inputLine = new Scanner(file);
			int i = 0;
			while(inputLine.hasNext() && i < itemsArray.length){
				String line = inputLine.nextLine();//Grabs an entire line
				String[] lineArray = line.split(",");
				/*parsed values from line.split are:
					[0] item name (String)
					[1] item value (int)
					[2] item weight (int)
				*/
				
				//Creates a new Item object called newItem with the
				//lineArray values from splitting the line.
				Item newItem = new Item(lineArray[0], Integer.parseInt(lineArray[1]), Integer.parseInt(lineArray[2]));
				itemsArray[i] = newItem;
				i++;
			}
			inputLine.close(); //Close scanner
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemsArray;
	}
	
	
}
