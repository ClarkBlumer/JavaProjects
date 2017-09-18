/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		11.4.2014
 * Section:		C
 * Lab Code: 	I dont care
 */

package cjbq4f.cs3330.lab8;

public class Person {
	private String name;
	private int age;
	private double bankAccountBalance;
	
	/**
	 * Constructor method that calls on setters to set the class attributes
	 * to passed parameters.
	 * 
	 * @param age Integer value that's used to store Person's age
	 * @param name String value used to store Person's name
	 * @param balance Double value used to store Person's bankAccountBalance
	 */
	public Person(int age, String name, double balance) {
			setAge(age);
			setName(name);
			setBalance(balance);
	}
	
	/**
	 * Set method used to set the class attribute age.
	 * @param age Integer value that's used to set class attribute
	 */
	private void setAge(int age) {this.age = age;}
	/**
	 * Set method used to set the class attribute name.
	 * @param name String value used to set class attribute name
	 */
	private void setName(String name) {this.name = name;}
	/**
	 * Set method used to set the class attribute bankAccountBalance
	 * @param balance Double value used to set class attribute bankAccountBalance
	 */
	private void setBalance(double balance) {this.bankAccountBalance = balance;}
	
	
	/**
	 * Get method used to get the value of class attribute age
	 * @return Integer value of the class attribute age
	 */
	protected int getAge() {return this.age;}
	/**
	 * Get method used to get the value of the class attribute bankAccountBalance
	 * @return Double value of the class attribute bankAccountBalance
	 */
	protected double getBalance() {return this.bankAccountBalance;}
	/**
	 * Get method used to get the value of the class attribute name
	 * @return String value of the class attribute name
	 */
	protected String getName() {return this.name;}
	
	/**
	 * toString method that overrides Object's toString. Used to format output
	 * to the screen based on the values of the class attributes.
	 */
	@Override
	public String toString() {
		return  "Name: " + getName() + "\n" + 
				"Bank Balance: $" + getBalance() + "\n" +
				"Age: " + getAge() + "\n\n";
	}
	
	
}
