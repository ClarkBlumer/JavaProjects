/* Name:			Clark Blumer
 * Date:			10.06.2014
 * Section: 		C
 * Submission Code: English is hard 
 */

package lab5;

public class Circle extends Ellipse {
	
	/**
	 * 
	 * @param radius userInput passed value for radius of a Circle object
	 * @param color userInput passed value for color of a Circle object
	 */
	public Circle(double radius, String color) {
		super(radius, radius, color);
	}
	
	/**
	 * Overrides Ellipse toString() method in order to use the values of the Circle object
	 */
	public String toString() {
		return "Circle " + getColor() + " " + calcArea() + " " + calcPerimeter();
	}
}
