package homework2;
/* Name:		Clark Blumer
 * Date:		10.06.2014
 * Section: 	C  
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameDataReader {

	/**
	 * Reads a text file and fills an ArrayList of type String with the String
	 * values from the file
	 * @param filePath file path of the file to be read
	 * @return the filled ArrayList
	 */
	public ArrayList<String> getGameCommands(String filePath) {
		ArrayList<String> gameCommands = new ArrayList<String>();
		File file = new File(filePath);
			
		try {
			Scanner inputLine = new Scanner(file);
			while(inputLine.hasNextLine()) {
				String line = inputLine.nextLine();
				String[] lineArray = line.split("\n");
				gameCommands.add(lineArray[0]);
			}
			inputLine.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gameCommands;
	}
		
	/**
	 * Reads a CSV file containing String, Int, Int and fills an ArrayList
	 * of type Item with values from the CSV file
	 * @param filePath file path of the CSV file to be read
	 * @return filled Item ArrayList
	 */
	public ArrayList<Item> getGameItems(String filePath) {
		ArrayList<Item> gameItems = new ArrayList<Item>();
		File file = new File(filePath);			
		Scanner inputLine;
			
		try {
			inputLine = new Scanner(file);
			while(inputLine.hasNextLine()) {
				String line = inputLine.nextLine();
				String[] lineArray = line.split(",");
				/* 	parsed values from line.split are:
					lineArray[0] = Item name 
					lineArray[1] = Item value
					lineArray[2] = Item weight */	
					
				/* adds new Item object to gameItems ArrayList by passing in
				 * parsed values to the Item constructor */
				gameItems.add(new Item(lineArray[0], 
							  Integer.parseInt(lineArray[1]), 
							  Integer.parseInt(lineArray[2])));
			}//end while
		inputLine.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return gameItems;
	}
		
	/**Reads from a CSV file to fill an ArrayList of type Beast
	 * 
	 * @param filePath file path where the CSV file can be found
	 * @return filled Beast ArrayList
	 */
	public ArrayList<Beast> getGameBeasts(String filePath) {
		ArrayList<Beast> gameBeasts = new ArrayList<Beast>();
		File file = new File(filePath);
		Scanner inputLine;
		
		try {
			inputLine = new Scanner(file);
			while(inputLine.hasNextLine()) {
				String line = inputLine.nextLine();
				String[] lineArray = line.split(",");
				/* parsed values from line.split are:
				 * lineArray[0] = Beast name
				 * lineArray[1] = Beast HP */
				gameBeasts.add(new Beast(lineArray[0], 
							   Integer.parseInt(lineArray[1])));
			}
				
		inputLine.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gameBeasts;
	}
}
