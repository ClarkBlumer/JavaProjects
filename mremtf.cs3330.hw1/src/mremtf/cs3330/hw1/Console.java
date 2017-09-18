package mremtf.cs3330.hw1;

import java.util.Scanner;
import java.util.Random;

public class Console {
	
	private static final Scanner input = new Scanner(System.in);
	private Player player;
	private ToolKit toolkit;
	private Grid grid;
	
	public Console (Player player) {
		this.setPlayer(player);
		this.init();
	}
	private void setPlayer(Player player) {
		this.player = player;
	}
	public void init() {
		this.toolkit = new ToolKit();
		this.grid    = new Grid();
	}
	public boolean use() {
		
		//Scanner input = new Scanner(System.in);
		Random randomGenerator = new Random();
		String option = null;
		String address = null;
		int server_idx = 0;
		while(this.player.getHealth() > 0) {
			this.displayRunOptions();
			option = input.nextLine();
			if (option.toUpperCase().equals("YES")) {
				System.out.print("Enter the address to server: ");
				address = input.nextLine();
				server_idx = grid.search(address);
				if (server_idx >= 0) {
					this.runOnTheGrid(server_idx);
				}
				else {
					System.out.println("Server not found!");
				}
			}
			else {
				System.out.println("Pulling a random job");
				server_idx = randomGenerator.nextInt(grid.numberOfServers());
				this.runOnTheGrid(server_idx);
			}
			System.out.println("");
			if (this.player.getHealth() > 0) {
				System.out.println(player.toString());
				if (this.player.getMoney() > 0) {
					this.displayUpdateOptions();
					option = input.nextLine();
					if (option.toUpperCase().equals("YES") ) {
						this.updateToolKit();				
					}
				}
			}
		}
		System.out.println(player.toString() + "has FLATLINED");
		return false;
		
	}
	private void updateToolKit() {
		this.toolkit.displayTools();
		System.out.print("Pick your ice breaker: ");
		int tool_choice = Integer.parseInt(input.nextLine());
		--tool_choice;
		while (tool_choice < 0 || tool_choice > this.toolkit.getNumberOfTools() - 1) {
			System.out.print("Enter your choice again? ");
			tool_choice = Integer.parseInt(input.nextLine());
			--tool_choice;
		}
		System.out.println(" ");
		System.out.print("How much strength to add (each 1 additional cost 10,000 yen)? ");
		int tool_strength = Integer.parseInt(input.nextLine());
		int deduction = tool_strength * -10000;
		boolean can_update = (this.player.getMoney() + deduction) >= 0;
		if(can_update) {
			this.player.updateMoney(deduction);
			this.toolkit.updateTool(tool_choice,tool_strength);
		}
		else {
			System.out.println("Not enough funds");
		}
		System.out.println("");
	}
	private void runOnTheGrid (int target_server) {
		this.toolkit.displayTools();
		System.out.print("Pick your ice breaker: ");
		int tool_choice = Integer.parseInt(input.nextLine());
		--tool_choice;
		while (tool_choice < 0 || tool_choice > this.toolkit.getNumberOfTools() - 1) {
			System.out.print("Not a valid tool, enter your choice again: ");
			tool_choice = Integer.parseInt(input.nextLine());
			--tool_choice;
		}
		System.out.println(" ");
		Tool tool = this.toolkit.getTool(tool_choice);
		while (player.getMoney() - tool.getCost() < 0) {
			System.out.print("Not enough funds, try again: ");
			tool_choice = Integer.parseInt(input.nextLine());
			tool = this.toolkit.getTool(tool_choice);
		}
		int deduction = tool.getCost() * -1;
		this.player.updateMoney(deduction);
		int result = grid.attack(tool,target_server);
		if (result > 0) {
			System.out.println("RUN SUCCESSFUL");
			this.player.updateMoney(result);
		}
		else {
			System.out.println("RUN FAILURE");
			this.player.updateHealth(result);
		}
		System.out.println(" ");
	}
	private void displayRunOptions() {
		System.out.print("Do you have a particular target server IP address to probe the grid? (yes/no): ");
	}
	private void displayUpdateOptions() {
		System.out.print("Would you like to update your a tool in the toolkit? (yes/no): ");
	}
}
