/*
 * Name:			Clark Blumer
 * Date:			9.23.2014
 * Section:			C
 * Submission Code:	Poopsies
 * 
 */

package lab3;

public class Hero {
	private String name;
	private String weapon;
	private int attackPoints;

	/**
	 * Constructor method - sets the attribute values when Hero is created
	 * 
	 * @param name takes a passed in string
	 * @param weapon takes a passed in string
	 * @param attackPoints takes a passed in int
	 */
	public Hero(String name, String weapon, int attackPoints) {
		setName(name);
		setWeapon(weapon);
		setAttackPoints(attackPoints);
	}

	/**
	 * Setter method - sets the class attribute to the passed in String value
	 * 
	 * @param name passed in String name
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter method - sets the class attribute to the passed in String value
	 * 
	 * @param weapon passed in String weapon
	 */
	private void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	/**
	 * 
	 * @param attackPoints passed in int value to be set to the objects
	 * attackPoints attribute
	 */
	private void setAttackPoints(int attackPoints) {
		if(attackPoints > 0) //evaluates passed in parameter attackPoints
			this.attackPoints = attackPoints;//if passed in value is positive, set class variable to passed variable
		else //if passed in value is not greater than 0, default attackPoints to 10.
			this.attackPoints = 10;
	}

	/**
	 * Update method to update the AttackPoints values
	 * @param newAttackPoints a passed value that is the product of current AttackPoints * 2
	 */
	public void updateAttackPoints(int newAttackPoints) {
		/* Takes the passed in value newAttackPoints and passes that
		 * to the setAttackPoints method to update the value */
		setAttackPoints(newAttackPoints);
	}

	/**
	 * Getter method - public method used to get the value of the Class's attribute name
	 * 
	 * @return class attribute value for name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter method - public method used to get the value of the Class's attribute weapon
	 * 
	 * @return class attribute value for weapon
	 */
	public String getWeapon() {
		return this.weapon;
	}

	/**
	 * Getter method - public method used to get the value of the Class's attribute attackPoints.
	 * 
	 * @return class attribute value for attackPoints
	 */
	public int getAttackPoints() {
		return this.attackPoints;
	}

}
