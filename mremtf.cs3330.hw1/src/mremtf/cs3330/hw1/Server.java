package mremtf.cs3330.hw1;

public class Server {
	private String name;
	private String type;
	private int strength;
	public Server (String name,String type,int strength) {
		this.setName(name);
		this.setType(type);
		this.setStrength(strength);
		
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
	public String getName() {
		return this.name;
	}
	public int getStrength() {
		return this.strength;
	}
	public String getType() {
		return this.type;
	}
	public String toString() {
		return this.type + " server with address of " + this.name + " with " + this.strength + " strength";
	}
	public void updateStrength(int added_strength) {
		this.setStrength(this.strength + added_strength);
	}
}
