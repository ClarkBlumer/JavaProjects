/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.20.2014
 * Lab Code:	Royals * 
 */

package cjbq4f.cs3330.lab6;

public class Goon {
	private String name;
	private String DOB;
	
	/**
	 * Constructor method that sets the class attributes to passed in values name and DOB
	 * @param name passed Sting value read from the CSV file
	 * @param DOB passed String value read from the CSV file
	 */
	public Goon(String name, String DOB) {
		setName(name);
		setDOB(DOB);
	}
	
	/**
	 * Getter method that lets other classes/methods use name attribute value
	 * @return String attribute name value
	 */
	public String getName() { return name; }
	
	/**
	 * Setter method that sets the class attribute to the passed name parameter
	 * @param name passed value from the constructor
	 */
	protected void setName(String name) { this.name = name; }
	
	/**
	 * Getter method that lets other classes/methods use the DOB attribute
	 * @return String attribute of DOB's value
	 */
	public String getDOB() { return DOB; }
	
	/**
	 * Setter method that sets the class attribute DOB to the passed DOB parameter
	 * @param DOB passed value from the constructor
	 */
	protected void setDOB(String DOB) { this.DOB = DOB; }
}
