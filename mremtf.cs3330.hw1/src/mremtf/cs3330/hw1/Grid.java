package mremtf.cs3330.hw1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grid {
	
	private ArrayList<Server> servers;
	
	public Grid() {
		this.loadServers();
	}
	public int search(String name) {
		int index = 0;
		for (Server server : servers)
		{
			if (server.getName().equals(name)){
				return index;
			}
			++index;
		}
		return -1;
	}
	public int numberOfServers() {
		return servers.size();
	}
	public int attack(Tool tool, int server) {
		int score = 0;
		int update = 3;
		System.out.println("ICE ENCOUNTERED, ATTEMPTING BREAK IN.....");
		System.out.println("SERVER INFO: " + servers.get(server).toString());
		if (tool.getType().equals("DECRYPTOR") && servers.get(server).getType().equals("ENCRYPTED")) {
			if (tool.getStrength() > servers.get(server).getStrength()) {
				score = 25000;
			}
			else {
				score = -20;
			}
			this.servers.get(server).updateStrength(update);
			return score;
		}
		if (tool.getType().equals("BASHER") && servers.get(server).getType().equals("UNENCRYPTED")) {
			if (tool.getStrength() > servers.get(server).getStrength()) {
				score = 10000;
			}
			else{
			 score = -10;
			}
			this.servers.get(server).updateStrength(update);
			return score;
		}
		this.servers.get(server).updateStrength(update);
		return -30;

	}
	private void loadServers() {
		File serverDataFile = new File("servers.txt");
		Scanner dataScanner = null;
		try {
			dataScanner = new Scanner(serverDataFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error: Servers file not found.");
			System.exit(1);
		}
		this.servers = new ArrayList<Server>();
		String input;
		// Read in the tools
		while(dataScanner.hasNext()) {
			// Read in each line, splitting the csv on the comma
			input = dataScanner.nextLine();
			String[] data = input.split(",");
			servers.add(new Server(data[0],data[1],Integer.parseInt(data[2])));
		}
		dataScanner.close();
	}
}
