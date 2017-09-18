package solution.cs3330.hw2;

public class Item {
	private String name;
	private int weight;
	private int value;
	
	public Item(String name, int value, int weight) {
		setName(name);
		setValue(value);
		setWeight(weight);
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	private void setWeight(int w) {
		if (w >= 0) {
			this.weight = w;
		}
		else {
			this.weight = 0;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getWeight() {
		return this.weight;
	}

	private void setValue(int value) {
		if (value >= 0) {
			this.value = value;
		}
		else {
			this.value = 0;
		}
	}

	public int getValue() {
		return this.value;
	}
}
