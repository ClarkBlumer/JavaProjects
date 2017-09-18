/*
 * Name:			Clark Blumer
 * Date:			9.23.2014
 * Section:			C
 * Submission Code:	Poopsies
 * 
 */

package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HeroFileReader {
	private String filePath;

	/**
	 * 
	 * @param filePath takes the passed in String file path
	 */
	public HeroFileReader(String filePath) {
		setFilePath(filePath);
	}

	/**
	 * Setter method - sets attribute filePath to passed in filePath
	 * 
	 * @param filePath String file path
	 */
	private void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Getter method - public method to get the filePath value of the Class
	 * 
	 * @return attribute filePath value
	 */
	public String getFilePath() {
		return this.filePath;
	}

	/**
	 * Read from a csv file and splits the line Strings by ","
	 * split Strings are then put into a temporary array and passed to
	 * Hero constructor to create initialized Hero objects which fill the
	 * Hero[] array.
	 * 
	 * @return a filled Hero[] array
	 */
	public Hero[] getHeroes() {
		String csvFile = getFilePath();
		File file = new File(csvFile);
		Hero[] heroArray = new Hero[5];
		
		try {
			Scanner inputLine = new Scanner(file);
			int i = 0;
			
			/* while the file has data AND i is less than the array length (5 originally)
			 * String line reads full lines from the file. If that line is blank, read the next line. */
			while(inputLine.hasNext() && i < heroArray.length){
				String line = inputLine.nextLine();//Grabs an entire line
				if(!(line.length() > 0)) {
					line = inputLine.nextLine();
				}
				
				/* lineArray gets the values from the split method */
				String[] lineArray = line.split(",");
				/*parsed values from line.split are:
					[0] hero name (String)
					[1] hero weapon (String)
					[2] hero attackpoints (int)
				*/
				
				//Creates a new Hero object called newHero with the
				//lineArray values from splitting the line.
				Hero newHero = new Hero(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]));
				heroArray[i] = newHero;
				i++;
			}
			inputLine.close(); //Close scanner
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return heroArray;
	}
}
