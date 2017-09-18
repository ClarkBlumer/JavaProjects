/* Name:		Clark Blumer
 * Date:		10.06.2014
 * Section: 	C  
 */
package homework2;
import java.util.ArrayList;

public class Bag {
	private ArrayList<Item> items;
	private int weight;
	
	/**
	 * Constructor method. Calls on setter method
	 */
	public Bag() {
		initBag();		
	}
	/**
	 * Initializes Item object weight values to 0 in the bag
	 */
	private void initBag() {
		items = new ArrayList<Item>();
		for(int i = 0; i < getSize(); i++)
			weight = 0;
	}
	/**Attempts to add an Item object to the ArrayList as long as the total
	 * weight value of all Items is <= 20
	 * 
	 * @param item Item trying to be added
	 * @return true if Item was added, false for not
	 */
	public boolean addItem(Item item) {
		if((weight + item.getWeight()) <= 20) {
			items.add(item);
			weight += item.getWeight();
			return true;
		}			
		else
			return false;
	}
	
	/**Attempts to drop an Item object from the Bag
	 * 
	 * @param item Item object to be discarded
	 * @return true if the Item was dropped, false for not
	 */
	public boolean dropItem(Item item) {
		if(items.remove(item)) {
			/* if item was dropped, minus its weight from total weight */
			weight -= item.getWeight();
			return true;
		}
		else
			return false;
	}
	/**Getter method
	 * 
	 * @return Item ArrayList
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	
	/**Getter method
	 * 
	 * @return the size of the items ArrayList
	 */
	public int getSize() {
		return items.size();
	}
	
	/** Checks to see if the passed name matches the name value of an Item object
	 * if it does, return that object. If it does not, return null
	 * 
	 * @param name passed name value of an item
	 * @return
	 */
	public Item getItem(String name) {
		for(int i = 0; i < getSize(); i++){
			if(name.toLowerCase().equals(items.get(i).getName().toLowerCase()))
					return items.get(i);				
		}
		return null;
	}
}
