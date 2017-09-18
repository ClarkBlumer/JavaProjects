/**	
 * 	Name:		Clark Blumer
 * 	Pawprint:	cjbq4f
 * 	Date:		10.27.2014
 * 	Section:	C
 * 	Lab Code:	derF
 */

package cjbq4f.cs3330.lab7;

public class Snake extends Animal implements NonFlying {

	/**
	 * Snake constructor method. Passes values up to the super class to set
	 * for the Snake object.
	 * 
	 * @param type String value used to associate the Object
	 */
	public Snake(String type) {
		super(false, false, type);
	}
	
	/**
	 * Boolean method to determine whether the passed Animal object falls into
	 * the edible categories for Snake class.  Returns false due to the assignment
	 * requirement: snakes cannot eat any Animal
	 */
	public boolean eat(Animal food) {
		return false;
	}
	
	/**
	 * Method used to print a movement message for Snake objects.
	 */
	public void movement() {
		System.out.println("The snake slithers on the ground");
	}
}
