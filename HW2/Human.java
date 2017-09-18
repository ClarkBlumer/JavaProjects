package solution.cs3330.hw2;

import java.util.ArrayList;

public class Human {

	private String name;
	private Bag bag;
	private Health health;
	private CommandProcessor commandProcessor;
	
	public Human(String name,int hp,Bag emptyBag) {
		initBag(emptyBag);
		setName(name);
		createHealth(hp);
		initCommandProcessor();
	}

	private void setName(String name) {
		this.name = name;
	}
	
	private void createHealth(int hp) {
		this.health = new Health(hp);
	}
	
	private void initBag(Bag emptyBag) {
		this.bag = emptyBag;
		this.bag.addItem(new Item("Crowbar", 30, 5));
	}
	
	private void initCommandProcessor() {
		this.commandProcessor = new CommandProcessor();
	}

	public String getName() {
		return this.name;
	}

	public Health getHealth() {
		return this.health;
	}
	
	public Bag getBag() {
		return this.bag;
	}
	
	public boolean isLiving() {
		return this.health.getAlive();
	}
	
	public boolean pickup(Item item) {
		return this.bag.addItem(item);
	}

	public boolean drop(Item item) {
		return this.bag.dropItem(item);
	}

	public boolean attack(Beast beast, Item item) {
		return beast.injured(item);
	}

	public HumanResponse processCommand (String commands, Beast beast, Item item) {
		String[] commandsSplit = commands.split(" ");
		String response = "";
		boolean validAction = true;
	
		if(! commandProcessor.validateUserCommand(commandsSplit[0])) {
			return new HumanResponse("Invalid game command", false);
		}
		if (commandsSplit[0].equals("attack") && commandsSplit.length >= 4 && 
				commandsSplit[2].equals("with")) {
				Item weapon = this.bag.getItem(commandsSplit[3]);
				if (!this.attack(beast,weapon)) {
					response = "Not a valid weapon";
					validAction = false;
				}
		}
		else if (commandsSplit[0].equals("pickup")) {
			if (this.pickup(item)) {
				response = "Item added successfully";
			}
			else {					
				response = "Item not added successfully";
				validAction = false;
			}
		}
		else if (commandsSplit[0].equals("drop") && commandsSplit.length >= 2) {
			Item dontNeed = this.bag.getItem(commandsSplit[1]);
			if (this.drop(dontNeed)) {
				response = "Item successfully dropped";
			}
			else {					
				response = "Item not successfully added";
				validAction = false;
			}
		}
		else if (commandsSplit[0].equals("help")) {
			ArrayList<String> humanCommands = commandProcessor.getCommands();
			for (String c : humanCommands) {
				response += c + "\n";
			}
		}
		return new HumanResponse (response,validAction);
	}
}
