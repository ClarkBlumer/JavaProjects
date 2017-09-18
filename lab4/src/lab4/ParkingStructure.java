/* Name:				Clark Blumer
 * Date:				9.29.2014
 * Section:				C
 * Submission Code:		Oliver
 */

package lab4;

import java.util.ArrayList;

public class ParkingStructure {
	private ArrayList<Level> levels;
	
	public ParkingStructure(int numberOfLevels) {
		setLevels(numberOfLevels);
	}
	
	/** 
	 * @param numberOfLevels passed in value for how many levels
	 * the parking structure will have.
	 */
	private void setLevels(int numberOfLevels) {
		/* allocates levels to an ArrayList of Levels */
		levels = new ArrayList<Level>();
		/* if entered numberOfLevels value is 0 or less, generate two levels */
		if(numberOfLevels <= 0) {
				levels.add(new Level(10));
				levels.add(new Level(10));
		}
		/* Else, generate levels per how many numberOfLevels entered */
		else {
			for(int i = 0; i < numberOfLevels; i++) {
				levels.add(new Level(10));
			}
		}
	
	}
	
	/**
	 * 
	 * @return true if structure is full, false if there are spots available
	 */
	public boolean isFull() {
		/* if structure is full, return true; else false */
		for(int i = 1; i < levels.size(); i++)
			/* Suppose to check each Level if its full and return true if it is */
			if(levels.get(i).isFull())
				return true;
			else
				return false;

		/* If it gets through the for loop without returning true, default to false */
		return false;
	}
	
	/**
	 * 
	 * @param incomingCar passed value of a Car object
	 * @return return index of added Car
	 */
	public int addCar(Car incomingCar) {
		
		for(int i = 1; i < levels.size(); i++) {
			if(!isFull()){
				levels.get(i).addCar(incomingCar);
				return i;
			}
		}
		return -1;
	}

}
