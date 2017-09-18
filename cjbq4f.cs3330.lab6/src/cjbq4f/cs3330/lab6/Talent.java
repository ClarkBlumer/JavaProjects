/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.20.2014
 * Lab Code:	Royals * 
 */

package cjbq4f.cs3330.lab6;

public class Talent extends Goon {
	private String skill;
	
	/**
	 * Constructor method that sends String name,DOB to the superclass and calls the
	 * set method for the skill attribute
	 * @param name passed String value from the CSV file
	 * @param DOB passed String value from the CSV file
	 * @param skill passed String value from the CSV file
	 */
	public Talent(String name, String DOB, String skill) {
		super(name, DOB); // passes the values it does not deal with up to the superclass
		setSkill(skill);
	}
	
	/**
	 * Getter method that lets other classes/methods use this class' attribute skill
	 * @return class String skill attribute value
	 */
	public String getSkill() { return skill; }
	
	/**
	 * Setter method that sets the class attribute skill to the passed parameter skill
	 * @param skill passed String value from the CSV file
	 */
	protected void setSkill(String skill) { this.skill = skill; }
}
