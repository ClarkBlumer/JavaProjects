/**	
 * 	Name:		Clark Blumer
 * 	Pawprint:	cjbq4f
 * 	Date:		10.27.2014
 * 	Section:	C
 * 	Lab Code:	derF
 */

package cjbq4f.cs3330.lab7;

public abstract class Animal {
	protected boolean legs;
	protected boolean wings;
	protected String type;
	
	/**
	 * Constructor method that sets the class attribute values to passed
	 * in values from subclasses or Animal.
	 * 
	 * @param legs Boolean value of true or false if Animal has legs or not
	 * @param wings Boolean value of true or false if Animal has wings or not
	 * @param type String value that represents the subclasses of Animal.
	 */
	public Animal(boolean legs, boolean wings, String type) {
		setLegs(legs);
		setWings(wings);
		setType(type);
	}
	
	/**
	 * Override superclass method of toString() with a custom output version
	 * used with the Animal objects.
	 */
	@Override 
	public String toString() {
		return getType() + " has wings";
	}
	

	/* Set and Get methods */
	/**
	 * Sets the boolean class attribute legs to true or false
	 * 
	 * @param legs Boolean value used to set legs to true or false
	 */
	protected void setLegs(boolean legs) {this.legs = legs;}
	
	/**
	 * Sets the boolean class attribute wings to true or false.
	 * 
	 * @param wings Boolean value used to set wings to true or false
	 */
	protected void setWings(boolean wings) {this.wings = wings;}
	
	/**
	 * Sets the class attribute to the passed String value.
	 * 
	 * @param type String value that represents the subclass of Animal
	 */
	protected void setType(String type) {this.type = type;}
	
	/**
	 * Get method used to get the value of the class attribute legs.
	 * 
	 * @return True if legs is true, false if legs is false.
	 */
	public boolean getLegs() {return legs;}
	
	/**
	 * Get method that is used to get the value of the class attribute wings.
	 * 
	 * @return True value if wings is true, false if not. Wings is set through the constructor
	 * based on a passed value of true or false.
	 */
	public boolean getWings() {return wings;}
	
	/** Get method that is used to get the value of the class attribute type.
	 * 
	 * @return String value associated with class attribute type.
	 */
	public String getType() {return type;}
	
	/* Abstract method */
	/**
	 * Abstract function that is required for any subclass to have a 
	 * concrete version of the method to be included in Animal. 
	 * eat() determines which other Animal each subclass can eat.
	 * 
	 * @param food Animal object passed from animals ArrayList
	 * @return True if food is in edible category, false if not
	 */
	public abstract boolean eat(Animal food);
	
}
