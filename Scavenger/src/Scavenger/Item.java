package Scavenger;

public class Item {
	private String name;	// Name of an Item object
	private int value;		// Value of an Item object
	private int weight;		// Weight of an Item object
	
	/**
	 * Constructor method which calls setter methods to set class attributes
	 * 
	 * @param name passed in String value
	 * @param value passed in int value
	 * @param weight passed in int
	 */
	public Item(String name, int value, int weight) {
		setName(name);
		setValue(value);
		setWeight(weight);
		
	}
	
	/**
	 * Setter method which sets the Class's attribute of name to passed in String name
	 * 
	 * @param name passed in String
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Setter method which sets the Class's attribute of value to passed in value of value
	 * 
	 * @param value
	 */
	private void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Setter method which sets the Class's attribute of weight to passed in value of weight
	 * 
	 * @param weight
	 */
	private void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * public method to get the Class's attribute of name
	 * 
	 * @return Class's attribute name 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * public method to get the Class's attribute of value
	 * 
	 * @return class's attribute value
	 */
	public int getValue() {
		return value;		
	}
	
	/**
	 * public method to get the Class's attribute of weight
	 * 
	 * @return class's attribute weight
	 */
	public int getWeight() {
		return weight;
	}
}
