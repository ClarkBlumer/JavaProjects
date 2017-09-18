/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.20.2014
 * Lab Code:	Royals * 
 */

package cjbq4f.cs3330.lab6;

public class Overseer extends Goon {
	private String sector;
	
	/**
	 * Constructor that passes the String values of name and DOB to the superclass and
	 * sets the sector attribute to the passed sector value
	 * @param name passed in value from the CSV file
	 * @param DOB passed in value from the CSV file
	 * @param sector passed in value from the CSV file
	 */
	public Overseer(String name, String DOB, String sector) {
		super(name, DOB);
		setSector(sector);
	}
	
	/**
	 * Getter method that lets other classes/methods use class attribute value
	 * @return String sector value from the class attribute
	 */
	public String getSector() { return sector; }
	
	/**
	 * Setter method that sets the class attribute sector to the passed in parameter sector
	 * @param sector passed value from the constructor to use in the class attribute
	 */
	protected void setSector(String sector) { this.sector = sector; }
}
