/* Name:			Clark Blumer
 * Date:			10.06.2014
 * Section: 		C
 * Submission Code: English is hard 
 */

package lab5;

import java.util.ArrayList;
import java.util.Scanner;

public class LabFiveDriver {
	private static ArrayList<Shape> shapes;
	private static Scanner userInput;
	
	public static void main(String[] args) {
		userInput = new Scanner(System.in);
		System.out.print("Enter number of shapes to create: ");
		int size = Integer.parseInt(userInput.nextLine());
		initShapes(size);
		displayShapes();
		System.out.print("\nEnter a shape color to remove: ");
		String shapeColor = userInput.nextLine();
		removeShape(shapeColor);
		displayShapes();
		userInput.close();
	}
	
	/**
	 * Initialization method. Instantiates new ArrayList object and new Scanner object.
	 * Also fills ArrayList with userInput values
	 * 
	 * @param numberOfShapes size of shapes ArrayList will be
	 */
	public static void initShapes(int numberOfShapes) {
		/* Instantiate a new ArrayList<Shape> object to shapes */
		shapes = new ArrayList<Shape>();
		
		/* userInput has to match shape name, and parameters */
		userInput = new Scanner(System.in);
		
		/* Check to make sure userInput matches a shape */
		int j = 0; // index to compare against numberOfShapes
		while(j < numberOfShapes){
			System.out.print("Enter a shape: ");
			String line = userInput.nextLine();
			String lineArray[] = line.split(" ");
			
			/* switch statement to match userInput cases. Creates Shape objects based on userInput. 
			 * default case signals an error in the input and j-- to remove that index of userInput from
			 * the j index count. lineArray[0] must be a shape string */
			switch(lineArray[0].toLowerCase()) {
				case "ellipse":
					/* if userInput does not have enough values */
					if(lineArray.length < 4) {
						System.out.println("Invalid shape! Try again.");
						j--;
						break;
					}
					/* if userInput has negative values */
					/*if(Double.parseDouble(lineArray[1]) < 0 || Double.parseDouble(lineArray[2]) < 0) {
						System.out.println("Invalid shape! Try again.");
						j--;
						break;
					}*/
					else {
						shapes.add(new Ellipse(Double.parseDouble(lineArray[1]), Double.parseDouble(lineArray[2]), lineArray[3]));
						break;
					}
				case "circle":
					if(lineArray.length < 3) {
						System.out.println("Invalid shape! Try again.");
						j--;
						break;
					}
					/* if userInput has negative values */
					if(Double.parseDouble(lineArray[1]) < 0) {
						System.out.println("Invalid shape! Try again.");
						j--;
						break;
					}
					shapes.add(new Circle(Double.parseDouble(lineArray[1]), lineArray[2]));
					break;
				case "square":
					if(lineArray.length < 3) {
						System.out.println("Invalid shape! Try again.");
						j--;
						break;
					}
					/* if userInput has negative values */
					if(Double.parseDouble(lineArray[1]) < 0) {
						System.out.println("Invalid shape! Try again.");
						j--;
						break;
					}
					shapes.add(new Square(Double.parseDouble(lineArray[1]), lineArray[2]));
					break;
				case "rectangle":
					if(lineArray.length < 4) {
						System.out.println("Invalid shape! Try again.");
						j--;
						break;
					}
					/* if userInput has negative values */
					if(Double.parseDouble(lineArray[1]) < 0 || Double.parseDouble(lineArray[2]) < 0) {
						System.out.println("Invalid shape! Try again.");
						j--;
						break;
					}
					else {
						shapes.add(new Rectangle(Double.parseDouble(lineArray[1]), Double.parseDouble(lineArray[2]), lineArray[3]));
						break;
					}
				default:
					System.out.println("Invalid shape! Try again.");
					j--;
					break;
			}
			j++;
		}
	}
	
	/**
	 * Displays the toString() method for shape at i index. toString() formats the method values
	 * into a string to print out to screen.
	 */
	public static void displayShapes() {
		for(int i = 0; i < shapes.size(); i++) {
			System.out.println(shapes.get(i).toString());
		}
	}
	
	/**
	 * Method removes the first Shape object with passed shapeColor value.
	 * 
	 * @param shapeColor userInput color to compare against shapes color at i index.
	 */
	public static void removeShape(String shapeColor) {
		for(int i = 0; i < shapes.size(); i++){
			/* if shape at i index color equals shapeColor, remove that shape from ArrayList
			 * and return after first value is removed. */
			if(shapes.get(i).getColor().equals(shapeColor)) {
				shapes.remove(i);
				return;
			}
		}
	}
}
