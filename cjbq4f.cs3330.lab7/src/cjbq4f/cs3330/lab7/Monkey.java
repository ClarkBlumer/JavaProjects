/**	
 * 	Name:		Clark Blumer
 * 	Pawprint:	cjbq4f
 * 	Date:		10.27.2014
 * 	Section:	C
 * 	Lab Code:	derF
 */

package cjbq4f.cs3330.lab7;

public class Monkey extends Animal implements NonFlying {
	
	/**
	 * Monkey constructor method.  Passes values up to the superclass to set.
	 * 
	 * @param type String value that represents the Type (class) of Animal object.
	 */
	public Monkey(String type) {
		super(true, false, type);
	}
	
	/**
	 * Boolean method to determine whether the passed Animal object falls into
	 * the edible categories for Monkey class.  Returns true if food is an instance 
	 * of Snake
	 */
	public boolean eat(Animal food) {
		if(food instanceof Snake)
			return true;
		else
			return false;
	}
	
	/**
	 * Method to display a movement message for the Monkey class
	 */
	public void movement() {
		System.out.println("The monkey is running on the ground");
	}
}
