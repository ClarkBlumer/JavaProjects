/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.29.2014
 * Section: 	C  
 * Assignment:	Homework 3
 */
package cjbq4f.cs3330.hw3;

public class Health {
	private int healthPoints;
	private boolean alive;
	
	/**
	 * Constructor that calls setter methods to set class attributes
	 */
	public Health() {
		setHealth(100);
		setAlive(true);
	}
	/**
	 * Overloaded constructor that takes an int value used to set a class attribute
	 * @param hp passed value to set class attribute
	 */
	public Health(int hp) { 
			setHealth(hp);
			setAlive(true);		
	}
	
	/**
	 * Setter method
	 * @param hp
	 */
	void setHealth(int hp){
		if(hp >= 1)
			this.healthPoints = hp;
		else
			setAlive(false);
	}
	/**
	 * setter method
	 * @param alive
	 */
	void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	/**
	 * Getter method
	 * @return
	 */
	public int getHealthPoints() {
		return healthPoints;
	}
	
	/**
	 * Updates healthPoints attribute with a new value based on the passed hitPoints
	 * @param hitPoints item's value used to determine how much health to take away
	 */
	public void hit(int hitPoints) {
		setHealth(this.getHealthPoints() - hitPoints);
	}
	
	/**
	 * Getter method for the alive attribute
	 * @return true if alive, false for not
	 */
	public boolean getAlive() {
		return alive;
	}

	/**
	 * Method updates healthPoints attribute with the passed in int value 
	 * @param healPoints int value to add to healthPoints
	 */
	public void heal(int healPoints) {
		this.healthPoints += healPoints;
	}
}
