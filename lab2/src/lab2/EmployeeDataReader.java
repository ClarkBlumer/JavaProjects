package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class EmployeeDataReader {

	String filePath;
	
	/**
	 * Sets the filePath attribute to the passed in path
	 * 
	 * @param filePath passed in file path
	 */
	public EmployeeDataReader(String filePath) {
		setFilePath(filePath);
	}
	
	/**
	 * Reads from the file stored in the attribute filePath. Reads a line from the file
	 * and then splits it based on csv standards. Then fills an array of type Employee[].
	 * 
	 * @return employArray filled with information from .csv file
	 */
	public Employee[] getEmployeeData() {
		String csvFile = getFilePath();
		File file = new File(csvFile);
		Employee[] employArray = new Employee[10];
		
		try {
			Scanner inputLine = new Scanner(file);
			int i = 0;
			while(inputLine.hasNext() && i < 10){
				String line = inputLine.nextLine();//Grabs an entire line
				String[] lineArray = line.split(",");
				
				//Creates a new Employee object called newEmployee with the
				//lineArray values from splitting the line.
				Employee newEmployee = new Employee(lineArray[0], Integer.parseInt(lineArray[1]), Double.parseDouble(lineArray[2]));
				employArray[i] = newEmployee;
				i++;
			}
			inputLine.close(); //Close scanner
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employArray;
	}
	
	/**
	 * Initializes the attribute name to the passed parameter name.
	 * 
	 * @param filePath passed in attribute which contains the file path
	 */
	private void setFilePath(String filePath) {
		this.filePath = filePath;		
	}
	
	/**
	 * Used when created the File object in getEmployeeData
	 * 
	 * @return the attribute filePath to this class. 
	 */
	private String getFilePath() {
		return this.filePath;
	}
	
	
	
}
