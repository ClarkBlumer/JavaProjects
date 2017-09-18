/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.20.2014
 * Lab Code:	Royals * 
 */

package cjbq4f.cs3330.lab6;

public class Don extends Goon {
	private String mobName;
	private int netWorth;
	
	/**
	 * Constructor for the Don subclass of Goon. Passes String name,DOB up to the superclass
	 * and then sets the Don class attributes to the passed in parameters mob,networth.
	 * @param name passed in String value from CSV file
	 * @param DOB passed in String value from CSV file
	 * @param mob passed in String value from CSV file
	 * @param networth passed in Integer value from CSV file
	 */
	public Don(String name, String DOB, String mob, int networth) {
		super(name, DOB);
		setMobName(mob);
		setNetWorth(networth);
	}
	
	/**
	 * Getter method that lets other classes/methods to use Don() netWorth attribute value
	 * @return int netWorth attribute's value
	 */
	public int getNetWorth() { return netWorth; }
	
	/**
	 * Setter method that sets the class attribute netWorth to the passed parameter networth's value
	 * @param networth passed value from the CSV file
	 */
	protected void setNetWorth(int networth) { this.netWorth = networth; }
	
	/**
	 * Getter method that lets other classes/methods use the class' mobName attribute value
	 * @return String value for the class attribute mobName
	 */
	public String getMobName() { return mobName; }
	
	/**
	 * Setter method that sets the class attribute mobName to the passed parameter mob value
	 * @param mob passed value from the CSV file that contains the mobName
	 */
	protected void setMobName(String mob) { this.mobName = mob; }
}
