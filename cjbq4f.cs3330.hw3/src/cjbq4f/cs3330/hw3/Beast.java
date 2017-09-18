/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.29.2014
 * Section: 	C  
 * Assignment:	Homework 3
 */

package cjbq4f.cs3330.hw3;

public class Beast extends GameCreature{
	private String level;
	
	/**
	 * 
	 * @param name
	 * @param hp
	 */
	public Beast(String level, String name, int hp, Bag emptyBag) {
		super(name, hp, emptyBag);
		setLevel(level);
	}
	
	/**
	 * Set method used to set the Beast object's attribute level to the passed in value from the CSV file
	 * 
	 * @param level String value of monster relative strength
	 */
	private void setLevel(String level) {this.level = level;}
	/**
	 * Get method used to get the Beast object's attribute level value
	 * 
	 * @return class attribute level's value
	 */
	public String getLevel() {return this.level;}

	/**
	 * Method checks to see if the passed in item is an instanceof Weapon class
	 * returns true if it is, or false if not.  Overrides the superclass version of attack()
	 */
	@Override
	public boolean attack(GameCreature creature, Item item) {
		if(item instanceof Weapon)
			return true;
		return false;
	}


	/**
	 * Method used to try and heal with passed in item.
	 * Checks to see if item is an instanceof Healer class and then updates
	 * the health.getHealthPoints with the item.getPoints() value.
	 * Drops the item after use.
	 * 
	 * Returns true if item is instanceof Healer
	 * Returns false if not an instanceof Healer
	 */
	@Override
	public boolean heal(Item item) {
		// TODO Auto-generated method stub
		if(item instanceof Healer) {
			health.setHealth(health.getHealthPoints() + item.getPoints()); 
			bag.dropItem(item);
			return true;
		}
		return false;
	}


	/**
	 * Method attempts to pickup the passed Item object.
	 * Returns true if successful
	 * Returns false if unsuccessful
	 */
	@Override
	public boolean pickup(Item item) {
		// TODO Auto-generated method stub
		if(bag.addItem(item))
			return true;
		return false;
	}


	/**
	 * Method attempts to drop the passed Item object.
	 * REturns true if successful
	 * Returns false if unsuccessful
	 */
	@Override
	public boolean drop(Item item) {
		// TODO Auto-generated method stub
		if(bag.dropItem(item))
			return true;
		return false;
	}


	/**
	 * Method drops all items in the currentPlayer's bag when the
	 * command "runaway" is entered as a command.
	 */
	@Override
	public void dropAll() {
		// TODO Auto-generated method stub
		bag.dropItems();	
	}
}
