/* Name:				Clark Blumer
 * Date:				9.29.2014
 * Section:				C
 * Submission Code:		Oliver
 */

package lab4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LabFourDriver {
	private static Scanner userInput;
	private static Random randomGenerator;
	private static ArrayList<String> carMakes;
	private static ArrayList<String> carTypes;
	private static ArrayList<String> carColors;

	public static void main(String[] args) {
		initAttributes();
		
		System.out.print("Enter number of parking structure levels: ");
		String input = userInput.nextLine();
		System.out.println(" ");
		
		ParkingStructure parkingStructure = new ParkingStructure(Integer.parseInt(input));
		
		while (!parkingStructure.isFull()) {
			Car incomingCar = createCar();
			System.out.println(incomingCar.getMake()
					+ " " + incomingCar.getType() + " " + incomingCar.getColor());
			int storageLevel = parkingStructure.addCar(incomingCar);
			System.out.println("Car Stored at level " + storageLevel);
			System.out.println(" ");
		}
	}
	
	/**
	 * Initializes the attributes: randomGenerator, userInput,
	 * carMakes, carTypes, carColors.
	 */
	private static void initAttributes() {
		randomGenerator = new Random(1337);
		userInput = new Scanner(System.in);
		
		/* carMakes array list */
		carMakes = new ArrayList<String>();
		carMakes.add("Ford");
		carMakes.add("Toyota");
		carMakes.add("Dodge");
		carMakes.add("Honda");
		
		/* carTypes array list */
		carTypes = new ArrayList<String>();
		carTypes.add("Sedan");		
		carTypes.add("Truck");
		carTypes.add("Van");
		carTypes.add("Hatchback");
		
		/* carColors array list */
		carColors = new ArrayList<String>();
		carColors.add("Blue");
		carColors.add("Green");
		carColors.add("Red");
		carColors.add("Purple");
		carColors.add("Orange");
		carColors.add("Yellow");		
	}

	/**
	 * 
	 * @return Car object with randomly created attributes
	 */
	private static Car createCar() {
		/* creates Car objects randomly */
		Car newCar = new Car(carMakes.get(randomGenerator.nextInt(carMakes.size())), 
				carTypes.get(randomGenerator.nextInt(carTypes.size())), 
				carColors.get(randomGenerator.nextInt(carColors.size())) );
		return newCar;
	}
}
