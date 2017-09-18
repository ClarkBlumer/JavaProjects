/**	
 * 	Name:		Clark Blumer
 * 	Pawprint:	cjbq4f
 * 	Date:		10.27.2014
 * 	Section:	C
 * 	Lab Code:	derF
 */

package cjbq4f.cs3330.lab7;

public class Bat extends Animal implements Flying {
	
	/**
	 * Bat constructor that sends values to the super class Animal to set
	 * 
	 * @param type String value that represents the Type (class) of Animal object.  
	 */
	public Bat(String type) {
		super(true, true, type);
	}
	
	/**
	 * Boolean method to determine whether the passed Animal object falls into
	 * the edible categories for Bat class.  Returns true if food is an instance 
	 * of Snake or Bat
	 */
	public boolean eat(Animal food) {
		if(food instanceof Snake || food instanceof Bat)
			return true;
		else
			return false;
	}
	
	/**
	 * Method to display a take off message for the Bat class
	 */
	public void takeOff() {
		System.out.println("The bat has taken off!");
	}
	
	/**
	 * Method to display a landing message for the Bat class
	 */
	public void land() {
		System.out.println("The bat has landed on the ground");
	}
}
