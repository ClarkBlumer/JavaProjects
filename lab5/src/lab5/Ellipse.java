/* Name:			Clark Blumer
 * Date:			10.06.2014
 * Section: 		C
 * Submission Code: English is hard 
 */

package lab5;

public class Ellipse extends Shape{
	private double majorAxis;
	private double minorAxis;
	
	/**Constructor that sends the color value up to the Super class Shape to set
	 * Sets minor/majorAxis values for Ellipse object
	 * 
	 * @param minorAxis userInput value for minorAxis of Ellipse object
	 * @param majorAxis userInput value for majorAxis of Ellipse object
	 * @param color	userInput value for color of the Ellipse object
	 */
	public Ellipse(double minorAxis, double majorAxis, String color) {
		super(color);
		setMinorAxis(minorAxis);
		setMajorAxis(majorAxis);
	}
	
	/**Calculates the area of an Ellipse using Math library PI and userInput passed values for
	 * the minor and major Axis.
	 * 
	 * @return double value of the area of an Ellipse
	 */
	public double calcArea() {
		return Math.PI * minorAxis * majorAxis;
	}
	
	/**
	 * Calculates the perimeter of an Ellipse using the Math library PI/pow values.
	 * 
	 * @return double value of the perimeter of an Ellipse
	 */
	public double calcPerimeter() {
		return (2 * Math.PI) * Math.sqrt((Math.pow(minorAxis, 2) + Math.pow(majorAxis, 2)) / 2); 
	}
	
	/**
	 * returns a String value for the returned values of the class methods
	 */
	public String toString() {
		return "Ellipse " + getColor() + " " + calcArea() + " " + calcPerimeter();
	}
	
	/**
	 * sets the class attribute to the userInput value
	 * 
	 * @param minorAxis userInput value for minorAxis
	 */
	private void setMinorAxis(double minorAxis) {
		this.minorAxis = minorAxis;
	}
	
	/**
	 * 
	 * @return public access to the class attribute value
	 */
	public double getMinorAxis() {
		return minorAxis;
	}
	
	
	private void setMajorAxis(double majorAxis) {
		this.majorAxis = majorAxis;
	}
	
	public double getMajorAxis() {
		return majorAxis;
	}
	
}
