/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.29.2014
 * Section: 	C  
 * Assignment:	Homework 3
 */

package cjbq4f.cs3330.hw3;

public class Weapon extends Item {
	int damagePoints;
	
	/**
	 * Weapon class constructor that passes the values of name, weight, and damagePoints
	 * to the superclass to set. Then calls setDamagePoints to set the attribute damagePoints
	 * value to the passed in damagePoints value.
	 * 
	 * @param level String value used to represent the Weapon's strength
	 * @param name String value used to identify the Weapon by a name
	 * @param weight int value used to represent the Weapon's weight
	 * @param damagePoints int value used to represent the Weapon's damage
	 */
	public Weapon(String level, String name, int weight, int damagePoints) {
		super(name, weight, level);
		setDamagePoints(damagePoints);
	}
	
	/**
	 * Set method used to set the class attribute damagePoints to the passed Int value
	 * 
	 * @param damagePoints Int value passed used for the class attribute damagePoints
	 */
	private void setDamagePoints(int damagePoints) {this.damagePoints = damagePoints;}
	/**
	 * Get method used to pass the class attribute damagePoints to other functions.
	 */
	public int getPoints() {
		return this.damagePoints;
	}
}
