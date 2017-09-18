package solution.cs3330.hw2;

public class Beast {
	private String name;
	protected Health health;
	
	public Beast(String name,int hp) {
		setName(name);
		createHealth(hp);
	}

	private void createHealth(int hp) {
		this.health = new Health(hp);
	}

	private void setName(String name) {
		if (name.equals(null) || name.isEmpty()){
			name = "Dangerous Bat";
		}
		else {
			this.name = name;
		}
		
	}
	
	public String getName() {
		return this.name;
	}

	public boolean injured(Item item) {
		if (item == null) return false;
		this.health.hit(item.getValue());
		return true;
	}

	public int getHealth () {
		return this.health.getHealthPoints();
	}
	
	public boolean isLiving() {
		return this.health.getAlive();
	}

}
