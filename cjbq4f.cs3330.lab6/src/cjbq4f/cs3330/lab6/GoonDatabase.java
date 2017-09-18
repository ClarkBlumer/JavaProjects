/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.20.2014
 * Lab Code:	Royals * 
 */

package cjbq4f.cs3330.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GoonDatabase {
	private ArrayList<Goon> goonDB;
	
	/**
	 * Constructor for the GoonDatabase class. Calls the importFile method with
	 * the passed in parameter filePath which will fill an ArrayList of Goon objects.
	 * @param filePath location of the file to be read by importFile()
	 */
	public GoonDatabase(String filePath){
		importFile(filePath);
	}
	
	/**
	 * Performs a loop while the user enters queries, or q to exit the loop, 
	 * and outputs the results to screen.  Calls the searchDataBase() method to
	 * perform the actual search on the goonDB 
	 */
	public void searchMenu() {
		/* Declaring and initializing variables */
		ArrayList<Goon> searchDB = new ArrayList<Goon>(); //takes the ArrayList returned from searchDatabase method
		String query = "";
		String[] queryArray;
		Scanner inputQuery = new Scanner(System.in);
		/* Initial message and input */
		System.out.print("\nPlease enter your query (q to exit): ");
		query = inputQuery.nextLine();
		
		/* while query does not equal 'q' */
		while(!query.equals("q")) {
			queryArray = query.split("\\W"); // \\W matches any non-word character
			searchDB = searchDatabase(queryArray[0]); // passes the query entered to the search method
			if(searchDB.isEmpty()) //if no results were found, searchDB should be empty
				System.out.println("No results found...");
			else {
				System.out.println("Results:");
				for(int i = 0; i < searchDB.size(); i++) {
					System.out.println((i + 1) + " - " + searchDB.get(i).getName());
				}
			}
			
			/* Condition check for the while loop. Updates query with user input */
			System.out.print("\nPlease enter your query (q to exit): ");
			query = inputQuery.nextLine();
		}
		
		inputQuery.close();
		System.out.println("\nProgram Complete.");
		
	}
	
	/**
	 * 
	 * @param filePath
	 */
	protected void importFile(String filePath) {
		goonDB = new ArrayList<Goon>();
		File file = new File(filePath);
			
		try {
			Scanner inputLine = new Scanner(file);
			int i = 0;
			while(inputLine.hasNextLine()) {
				String line = inputLine.nextLine();
				String[] lineArray = line.split(",");
				/* Values from split()
				 * lineArray[0] = Type of Goon
				 * Used in all Goons/:
				 * lineArray[1] = Name of Goon
				 * lineArray[2] = DOB of Goon
				 * Used in subclasses of Goon (Talent, Overseer, Don):
				 * lineArray[3] = Talent/sector/name of mob
				 * Used only in subclass Don:
				 * lineArray[4] = net worth
				 */
				//if(lineArray.length <= 3){
					if(lineArray[0].equals("Talent"))
						goonDB.add(new Talent(lineArray[1], lineArray[2], lineArray[3]));
					if(lineArray[0].equals("Overseer"))
						goonDB.add(new Overseer(lineArray[1], lineArray[2], lineArray[3]));
				//}
				if(lineArray.length >= 4)
					if(lineArray[0].equals("Don"))
						goonDB.add(new Don(lineArray[1], lineArray[2], lineArray[3], Integer.parseInt(lineArray[4])));
			
			}
			inputLine.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Import Complete.");
	}
	
	/**
	 * 
	 * @param searchQuery
	 * @return
	 */
	protected ArrayList<Goon> searchDatabase(String searchQuery) {
		ArrayList<Goon> searchDB = new ArrayList<Goon>(); //ArrayList that will be filled with searched values from goonDB
		
		
		for(int i = 0; i < goonDB.size(); i++) {
			if(goonDB.get(i).getName().toLowerCase().contains(searchQuery.toLowerCase()) ) {
				searchDB.add(goonDB.get(i));
			}
			
			/* Was running out of time and couldn't get any other ways to work correctly */
			if(goonDB.get(i) instanceof Talent && searchQuery.toLowerCase().contains("Talent".toLowerCase())) 
				searchDB.add(goonDB.get(i));
			if(goonDB.get(i) instanceof Overseer && searchQuery.toLowerCase().contains("Overseer".toLowerCase()))
				searchDB.add(goonDB.get(i));
			if(goonDB.get(i) instanceof Don && searchQuery.toLowerCase().contains("Don".toLowerCase()))
				searchDB.add(goonDB.get(i));
		}
		return searchDB;
	}
}
