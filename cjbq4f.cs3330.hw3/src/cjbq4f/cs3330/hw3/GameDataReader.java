/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.29.2014
 * Section: 	C  
 * Assignment:	Homework 3
 */
package cjbq4f.cs3330.hw3;

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
				String[] lineArray = line.split("[\n ]");
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
				String[] lineArray = line.split("[ ,]");
				/* 	parsed values from line.split are:
					lineArray[0] = Item name 
					lineArray[1] = Item value
					lineArray[2] = Item weight */	
					
				/* adds new Item object to gameItems ArrayList by passing in
				 * parsed values to the Item constructor through either Weapon
				 * or Healer subclasses of Item */
				
				/* if Item is Weapon item */
				if(lineArray[0].equalsIgnoreCase("weapon"))
					gameItems.add(new Weapon(lineArray[1], 		//String level 
							lineArray[2], 						//String name
							Integer.parseInt(lineArray[3]), 	//Int weight
							Integer.parseInt(lineArray[4])));	//Int damagePoints
				/* if Item is Healer item */
				else if(lineArray[0].equalsIgnoreCase("healer"))
					gameItems.add(new Healer(lineArray[1], 		//String level 
							lineArray[2], 						//String name
							Integer.parseInt(lineArray[3]), 	//Int weight
							Integer.parseInt(lineArray[4])));	//Int healPoints
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
		Bag beastBag = new Bag();
		
		try {
			inputLine = new Scanner(file);
			while(inputLine.hasNextLine()) {
				String line = inputLine.nextLine();
				String[] lineArray = line.split("[ ,]");
				/* parsed values from line.split are:
				 * lineArray[0] = Beast level
				 * lineArray[1] = Beast name
				 * lineArray[2] = Beast hp
				 * lineArray[3] = Weapon level
				 * lineArray[4] = Weapon name
				 * lineArray[5] = Weapon weight
				 * lineArray[6] = Weapon damagePoints */
				beastBag.addItem(new Weapon(lineArray[3], 
									 lineArray[4], 
									 Integer.parseInt(lineArray[5]), 
									 Integer.parseInt(lineArray[6])));
				gameBeasts.add(new Beast(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]), 
							   	   beastBag));
			}
				
		inputLine.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gameBeasts;
	}
}
