/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.29.2014
 * Section: 	C  
 * Assignment:	Homework 3
 */
package cjbq4f.cs3330.hw3;

public abstract class Item {

	private String name;	// Name of an Item object
	//private int value;		// Value of an Item object
	private int weight;		// Weight of an Item object
	private String level;
	
	/**
	 * Constructor method which calls setter methods to set class attributes
	 * 
	 * @param name passed in String value
	 * @param value passed in int value
	 * @param weight passed in int
	 */
	public Item(String name, int weight, String level) {
		setName(name);
		setLevel(level);
		setWeight(weight);
		
	}
	
	/**
	 * Setter method which sets the Class's attribute of name to passed in String name
	 * 
	 * @param name passed in String
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Setter method which sets the Class's attribute of level to passed in value of value
	 * 
	 * @param level
	 */
	private void setLevel(String level) {
		this.level = level;
	}
	
	/**
	 * Setter method which sets the Class's attribute of weight to passed in value of weight
	 * 
	 * @param weight
	 */
	private void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * public method to get the Class's attribute of name
	 * 
	 * @return Class's attribute name 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * public method to get the Class's attribute of value
	 * 
	 * @return class's attribute value
	 */
	public String getLevel() {
		return this.level;		
	}
	
	/**
	 * public method to get the Class's attribute of weight
	 * 
	 * @return class's attribute weight
	 */
	public int getWeight() {
		return this.weight;
	}
	
	public abstract int getPoints();
}
