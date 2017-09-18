package mremtf.cs3330.hw1;

public class Tool {
	private String name;
	private String type;
	private int cost;
	private int strength;
	
	public Tool (String name,String type,int cost,int strength) {
		this.setName(name);
		this.setStrength(strength);
		this.setType(type);
		this.setCost(cost);
	}
	
	private void setName(String name) {
		this.name = name;
	}
	private void setType(String type) {
		this.type = type;
	}
	private void setStrength(int strength) {
		this.strength = strength;
	}
	private void setCost(int cost) {
		this.cost = cost;
	}
	public String getName() {
		return this.name;
	}
	
	public int getStrength() {
		return this.strength;
	}
	
	public String getType() {
		return this.type;
	}
	public void updateStrength(int strength) {
		this.setStrength(this.strength + strength);
	}
	public int getCost() {
		return this.cost;
	}
	@Override
	public String toString() {
		return this.type + " tool named " + this.name + " with " + this.strength + " strength and a cost of " + this.cost;
	}
}
