package Scavenger;

public class Command {
	private String commandName;
	
	public Command(String commandName) {
		setCommandName(commandName);
	}
	
	private void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	
	public String getCommandName() {
		return commandName;
	}
}
