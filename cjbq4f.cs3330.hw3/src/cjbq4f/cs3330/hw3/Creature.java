/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.29.2014
 * Section: 	C  
 * Assignment:	Homework 3
 */

package cjbq4f.cs3330.hw3;

public interface Creature {
	/**
	 * 
	 * @param creature GameCreature object used as the target
	 * @param item Item object used as the weapon against a target
	 * @return return true if attack success, false if not
	 */
	boolean attack(GameCreature creature, Item item);
	/**
	 * 
	 * @param item Item object used to heal player's healthPoints 
	 * @return true if success, false if not
	 */
	boolean heal(Item item);
	
	/**
	 * 
	 * @param item Item object that is being added to creature inventory
	 * @return true if item was added, false if not
	 */
	boolean pickup(Item item);
	/**
	 * @param item Item object that is being removed from creature inventory
	 * @return true if item was removed, false if not
	 */
	boolean drop(Item item);
	/**
	 * Method used to drop all the items from a creature's inventory
	 */
	void dropAll();
	/**
	 * 
	 * @param item Item object used to determine damage done to creature healthPoints
	 * @return true if injured, false for not
	 */
	boolean injured(Item item);
}