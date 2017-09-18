/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.29.2014
 * Section: 	C  
 * Assignment:	Homework 3
 */

package cjbq4f.cs3330.hw3;

public class Healer extends Item {
	private int healPoints;
	
	/**
	 * Constructor method which calls the super to set name, weight, and level values
	 * and calls setHealPoints to set the class attribute healPoints value.
	 * 
	 * @param level String value used to represent an Healer item strength
	 * @param name String value used for the Healer item name
	 * @param weight Int value used for the weight of the Healer Item
	 * @param healPoints Int value used for the amount of health the item will return
	 */
	public Healer(String  level, String name, int weight, int healPoints) {
		super(name, weight, level);
		setHealPoints(healPoints);
	}
	
	/**
	 * Set method used to set the class attribute healPoints value.
	 * 
	 * @param healPoints Int value used to to set the class attribute of healPoints 
	 */
	private void setHealPoints(int healPoints) {this.healPoints = healPoints;}

	/**
	 * Get method used to pass the attribute healPoints value to other methods.
	 */
	@Override
	public int getPoints() {return this.healPoints;}

}
