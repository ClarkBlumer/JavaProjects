/* Name:			Clark Blumer
 * Date:			10.06.2014
 * Section: 		C
 * Submission Code: English is hard 
 */

package lab5;

public class Square extends Rectangle {
	
	/**
	 * Constructor that sends the passed in values up to the superclass in order to calcArea/calcPerimeter
	 * 
	 * @param size userInput passed value for length of a side
	 * @param color userInput passed value for color of square
	 */
	public Square(double size, String color) {
		super(size, size, color);
	}
	
	/**
	 * Uses super class methods to return a String of their values.
	 * Overrides Rectangle's toString() function to use values for the Square object.
	 */
	public String toString() {
		/* Uses super class methods to return a String of their values */
		return "Square " + getColor() + " " + calcArea() + " " + calcPerimeter();
	}
}
