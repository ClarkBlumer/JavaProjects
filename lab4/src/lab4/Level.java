/* Name:				Clark Blumer
 * Date:				9.29.2014
 * Section:				C
 * Submission Code:		Oliver
 */

package lab4;

import java.util.ArrayList;

public class Level {
	private ArrayList<Car> carsStored;
	private int numberOfParkingSpots;
	
	/**Constructor
	 * 
	 * @param numberOfParkingSpots passed value from Driver
	 */
	public Level(int numberOfParkingSpots) {
		setParkingSpots(numberOfParkingSpots);
	}
	
	/**
	 * 
	 * @param numberOfParkingSpots passed value from Driver to determine how many spots per Level
	 */
	private void setParkingSpots(int numberOfParkingSpots) {
		this.numberOfParkingSpots = numberOfParkingSpots;
		carsStored = new ArrayList<Car>();
	}
	
	/**
	 * Method to determine if the Level is full
	 * 
	 * @return true if carsStored size is greater than or equal to numberOfParkingSpots
	 */
	public boolean isFull() {
		if(carsStored.size() >= numberOfParkingSpots)
			return true;
		else
			return false;
	}
	
	/**
	 * Adds Car object to the arraylist carsStored
	 * 
	 * @param incomingCar passed value from ParkingStructure
	 */
	public void addCar(Car incomingCar) {
		carsStored.add(incomingCar);
	}
}
