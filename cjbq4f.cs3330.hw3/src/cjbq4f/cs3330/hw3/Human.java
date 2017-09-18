/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.29.2014
 * Section: 	C  
 * Assignment: 	Homework 3
 */

package cjbq4f.cs3330.hw3;

public class Human extends GameCreature {

	/**
	 * Subclass Human Constructor method which passes the name, hp, and emptyBag values to
	 * the superclass GameCreature to set.
	 * 
	 * @param name String value used to set the name of the Human object
	 * @param hp int value used to set the healthPoints value of the Human object
	 * @param emptyBag Bag value used to set the initial bag/inventory of the human object
	 */
	public Human(String name, int hp, Bag emptyBag) {
		super(name, hp, emptyBag);
	}

	/**
	 * Method overrides the Creature Interface attack() method. AUTO generated the
	 * @Override so not sure if needed.
	 * Checks to make sure the passed item is an instanceof WEapon and returns true
	 * if it, or false if not.
	 */
	@Override
	public boolean attack(GameCreature creature, Item item) {
		if(item instanceof Weapon)
			return true;
		return false;
	}

	/**
	 * Method checks of the passed item is an instanceof Healer and then
	 * updates the health attribute with the item's point value if true
	 * or returns false if not.
	 */
	@Override
	public boolean heal(Item item) {
		if(item instanceof Healer) {
			this.health.setHealth(health.getHealthPoints() + item.getPoints()); 
			this.bag.dropItem(item);
		}
		return false;
	}

	/**
	 * Method attemps the pickup the passed item and returns
	 * true if successful or false for not
	 */
	@Override
	public boolean pickup(Item item) {
		if(this.bag.addItem(item))
			return true;
		return false;
	}

	/**
	 * Method attempts to drop the passed item and returns
	 * true of successful or false for not
	 */
	@Override
	public boolean drop(Item item) {
		if(this.bag.dropItem(item))
			return true;
		return false;
	}

	/**
	 * Method drops all the items in the player's bag.
	 */
	@Override
	public void dropAll() {
		this.bag.dropItems();		
	}
	
	
}
