/* Name:			Clark Blumer
 * Date:			10.06.2014
 * Section: 		C
 * Submission Code: English is hard 
 */

package lab5;

public class Shape {
	private String color;
	
	/**Superclass constructor. Handles the color value of all Shape objects
	 * while subclasses handle more specific methods.
	 * 
	 * @param color userInput value for color of input Shape
	 */
	public Shape(String color) {
		setColor(color);
	}
	
	private void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
}
