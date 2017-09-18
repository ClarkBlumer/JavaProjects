/* Name:				Clark Blumer
 * Date:				9.29.2014
 * Section:				C
 * Submission Code:		Oliver
 */

package lab4;

public class Car {
	private String make, type, color;
	
	/**
	 * Constructor: sets attributes for Car class
	 * 
	 * @param make String of make of car
	 * @param type String of type of car
	 * @param color String of color of car
	 */
	public Car(String make, String type, String color) {
		setMake(make);
		setType(type);
		setColor(color);
	}

	private void setMake(String make) {
		this.make = make;
	}
	
	private void setType(String type) {
		this.type = type;
	}
	
	private void setColor(String color) {
		this.color = color;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getColor() {
		return this.color;
	}
}
