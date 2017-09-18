/* Name:			Clark Blumer
 * Date:			10.06.2014
 * Section: 		C
 * Submission Code: English is hard 
 */

package lab5;

public class Rectangle extends Shape {
	private double width;
	private double height;
	
	/**
	 * Constructor that passes the color variable up to the Shape superclass and sets
	 * width and height to user input values
	 * 
	 * @param width of rectangle
	 * @param height of rectangle
	 * @param color of rectangle
	 */
	public Rectangle(double width, double height, String color) {
		super(color);
		setWidth(width);
		setHeight(height);
	}
	
	/**
	 * Calculates the area of a rectangle
	 * 
	 * @return double value of width * height
	 */
	public double calcArea() {
		return width * height;
	}
	
	/**
	 * 
	 * @return double value of the perimeter of a rectangle
	 */
	public double calcPerimeter() {
		return (2 * width) + (2 * height);
	}
	
	/**
	 * returns a String value of the class method's values
	 */
	public String toString() {
		return "Rectangle " + getColor() + " " + calcArea() + " " + calcPerimeter(); 
	}
	
	/**
	 * Sets class attribute to the passed in value
	 * 
	 * @param width userInput passed value
	 */
	private void setWidth(double width) {
		this.width = width;
	}
	
	/**
	 * public access to the class' attribute value
	 * 
	 * @return attribute's value for width
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Sets class attribute to the passed in value
	 * 
	 * @param height userInput passed value
	 */
	private void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * public access to the class' attribute value
	 * 
	 * @return attribute's value for height
	 */
	public double getHeight() {
		return height;
	}
}
