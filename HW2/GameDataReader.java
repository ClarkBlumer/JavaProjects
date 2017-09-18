package solution.cs3330.hw2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class GameDataReader {


	public ArrayList<String> getGameCommands(String filePath) {
		BufferedReader reader = null;
		ArrayList<String> commands = new ArrayList<String>();
		try {
		    File file = new File(filePath);
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    while ((line = reader.readLine()) != null) {
		    	if (line.isEmpty()) continue; 
		    	commands.add(line);
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		return commands;
	}

	public ArrayList<Item> getGameItems(String filePath) {
		BufferedReader reader = null;
		ArrayList<Item> items = new ArrayList<Item>();
		try {
		    File file = new File(filePath);
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    String[] splitString = null;
		    while ((line = reader.readLine()) != null) {
		    	splitString = line.split(",");
		    	items.add(new Item(splitString[0],
		    			Integer.parseInt(splitString[1]), Integer.parseInt(splitString[2])));
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}

		return items;
	}

	public ArrayList<Beast> getGameBeasts(String filePath) {
		BufferedReader reader = null;
		ArrayList<Beast> beasts = new ArrayList<Beast>();
		try {
		    File file = new File(filePath);
		    reader = new BufferedReader(new FileReader(file));

		    String line;
		    String[] splitString = null;
		    while ((line = reader.readLine()) != null) {
		    	splitString = line.split(",");
		    	beasts.add(new Beast(splitString[0],
		    			Integer.parseInt(splitString[1])));
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}

		return beasts;
	}

}
