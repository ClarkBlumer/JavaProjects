package homework2;
/* Name:		Clark Blumer
 * Date:		10.06.2014
 * Section: 	C  
 */
public class Beast {
	private String name;
	private Health health;
	
	/**
	 * 
	 * @param name
	 * @param hp
	 */
	public Beast(String name, int hp) {
		setName(name);
		createHealth(hp);
	}
	
	/**
	 * 
	 * @param item
	 * @return
	 */
	public boolean injured(Item item) {
		if(item != null) {
			/* call hit method on the health attribute with the parameter
			 * as the value returned from calling getValue method on the passed
			 * item parameter, return true.  if null, return false. */
			health.Hit(item.getValue());
			return true;
		}
		else
			return false;
	}
	
	/**************************************************************************/
	/*                     Setters and Getters for health                     */
	/**************************************************************************/
	/**
	 * 
	 * @param hp
	 */
	private void createHealth(int hp) {
		this.health = new Health(hp);
	}	
	
	/**
	 * 
	 * @return
	 */
	public int getHealth() {
		return health.getHealthPoints();
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isLiving() {
		return health.getAlive();
	}
	
	/**************************************************************************/
	/*                       Setters and Getters for name                     */
	/**************************************************************************/
	/**
	 * 
	 * @param name
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
}
