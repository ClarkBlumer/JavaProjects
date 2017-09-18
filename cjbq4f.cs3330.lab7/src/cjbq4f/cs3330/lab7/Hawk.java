/**	
 * 	Name:		Clark Blumer
 * 	Pawprint:	cjbq4f
 * 	Date:		10.27.2014
 * 	Section:	C
 * 	Lab Code:	derF
 */

package cjbq4f.cs3330.lab7;

public class Hawk extends Animal implements Flying {

	/**
	 * Hawk class constructor. Passes values to the superclass Animal to set 
	 * for the object.
	 * 
	 * @param type
	 */
	public Hawk(String type) {
		super(true, true, type);
	}
	
	/**
	 * Boolean method to determine whether the passed Animal object falls into
	 * the edible categories for Hawk class.  Returns true if food is an instance 
	 * of Snake or Bat
	 */
	public boolean eat(Animal food) {
		if(food instanceof Snake || food instanceof Bat)
			return true;
		else
			return false;
	}
	
	/**
	 * Method used to print a take off message for the Hawk object
	 */
	public void takeOff() {
		System.out.println("The hawk has taken off!");
	}
	
	/**
	 * Method used to print a landing message for the Hawk object
	 */
	public void land() {
		System.out.println("The hawk has landed on the ground");
	}
}
