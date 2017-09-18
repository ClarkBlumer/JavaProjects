package mremtf.cs3330.hw1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ToolKit {
	private ArrayList<Tool> tools;
	
	public ToolKit () {
		this.loadTools();
	}
	public void displayTools() {
		int row = 1;
		for (Tool tool : tools)
		{
			System.out.println(row +") "+ tool.toString());
			++row;
		}
	}
	public Tool getTool(int tool_index) {
		return tools.get(tool_index);
	}
	
	public int getNumberOfTools() {
		return tools.size();
	}
	public void updateTool(int tool_index,int strength) {
		this.tools.get(tool_index).updateStrength(strength);
	}
	private void loadTools() {
		File toolDataFile = new File("tools.txt");
		Scanner dataScanner = null;
		try {
			dataScanner = new Scanner(toolDataFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error: Tools file not found.");
			System.exit(1);
		}
		this.tools = new ArrayList<Tool>();
		String input;
		// Read in the tools
		while(dataScanner.hasNext()) {
			// Read in each line, splitting the csv on the comma
			input = dataScanner.nextLine();
			String[] data = input.split(",");
			tools.add(new Tool(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3])));
		}
		dataScanner.close();
	}
}
