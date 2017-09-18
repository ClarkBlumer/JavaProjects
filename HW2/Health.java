package solution.cs3330.hw2;

public class Health {
	private int health_points;
	private boolean alive;
	
	public Health () {
		setHealth(100);
		setAlive(true);
	}
	
	public Health (int hp) {
		setHealth(hp);
		setAlive(true);
	}
	
	private void setHealth(int hp) {
		if (hp >= 1) {
			this.health_points = hp;
		}
		else {
			setAlive(false);
		}
	}
	
	private void setAlive(boolean a) {
		this.alive = a;
	}
	
	public int getHealthPoints() {
		return this.health_points;
	}
	public boolean getAlive() {
		return this.alive;
	}
	
	public void hit(int hitPoints) {
		setHealth(this.getHealthPoints() - hitPoints);
	}
}
