/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		11.4.2014
 * Section:		C
 * Lab Code: 	I dont care
 */

package cjbq4f.cs3330.lab8;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputLine = "";
		ArrayList<Person> person = new ArrayList<Person>();
		
		/* Prompt the user for necessary variables and check input for errors */
		System.out.println("Enter person info or q to quit.");
		
		while(!inputLine.equalsIgnoreCase("q")) {
			/* Get name information */
			System.out.print("Please enter the name of this person: ");
			inputLine = input.nextLine();
			try{
				isName(inputLine); // Check for correct input from the user
			} catch(InvalidNameException e){
				System.out.println(e);
				continue;
			}
			/* if the try works, bypass the catch block and set
			 * name to the entered value from inputLine. */
			String name = inputLine;
			
			/* Get age information */
			System.out.print("Please enter an age for this person: ");
			inputLine = input.nextLine();
			try{
				/* Checks to make sure the value for age entered is
				 * an integer value and within 0 - 150 years. */
				isValidAge(inputLine);
			} catch(InvalidAgeException e) {
				System.out.println(e);
				continue;
			}
			/* if the try block works, bypass catch block and set
			 * age to the parsed integer value from inputLine */
			int age = Integer.parseInt(inputLine);
			
			/* Get balance information */
			System.out.print("Please enter a bank account balance for this person: ");
			inputLine = input.nextLine();
			try {
				/* Check to make sure a double value was entered for the balance */
				isBalance(inputLine);
			} catch(InvalidBalanceException e) {
				System.out.println(e);
				continue;
			}
			/* if the try block works, bypass the catch block and set
			 * balance to the parsed double value from inputLine */
			double balance = Double.parseDouble(inputLine);
			
			/* Create a new Person object for the person ArrayList with successful
			 * values from user */
			person.add(new Person(age, name, balance));
			
			/* Check for q to quit case */
			System.out.print("Please enter the name of the person: ");
			inputLine = input.nextLine();
		}
		input.close();
		
		for(int i = 0; i < person.size(); i++) {
			System.out.print(person.get(i).toString());
		}
	}

	/**
	 * Method checks for a valid age entry from the user. Age value must be a non-null integer
	 * and be between 0 and 150 years.
	 * 
	 * @param age passed String value which will be parsed and checked for an Integer value
	 * @throws InvalidAgeException 
	 */
	public static void isValidAge(String age) throws InvalidAgeException {
		if(age != null){
			/* try/catch block checks to make sure passed age String contains an integer */
			try {
				Integer.parseInt(age);
			} catch(NumberFormatException e) {
				throw new InvalidAgeException("You did not enter an integer age value.");
			}
			int ageInt = Integer.parseInt(age);
			if(ageInt <= 0) 
				throw new InvalidAgeException("Age cannot be 0 or negative.");
			if(ageInt >= 150)
				throw new InvalidAgeException("Age can not be equal to or more than 150.");
			
		}
		else
			//if age is null
			throw new InvalidAgeException("You did not enter an integer age value.");
	}
	
	/**
	 * Method checks for a valid balance entry from the user. Balance value must be 
	 * a double value and not null.
	 * 
	 * @param balance
	 * @throws InvalidBalanceException
	 */
	public static void isBalance(String balance) throws InvalidBalanceException {
		if(balance != null) {
			try{
				Double.parseDouble(balance);
			} catch(NumberFormatException e) {
				throw new InvalidBalanceException("You did not enter a double.");
			}
		}
		else
			//if balance is null
			throw new InvalidBalanceException("You did not enter a balance value.");
	}
	
	/**
	 * Method checks for valid name entries and throws exceptions if any are found.  Prevents 
	 * the program from halting based on bad entry values.
	 * 
	 * @param name passed String value
	 * @throws InvalidNameException handles runtime exceptions based on incorrectly entered
	 * values.
	 */
	public static void isName(String name) throws InvalidNameException {
		if(name != null) {
			/* Splits the String name based on spaces.  Used to allow for
			 * first and last name entries. */
			String[] nameArray;
			nameArray = name.split(" ");
			/* if length >= 2, contains first and last name */
			if(nameArray.length >= 2)
					if(!nameArray[0].matches("[a-zA-Z]+") || !nameArray[1].matches("[a-zA-Z]+"))
						throw new InvalidNameException("You have entered an invalid name.");
			/* if length < 2, contains just first name */
			if(nameArray.length < 2)
					if(!nameArray[0].matches("[a-zA-Z]+")) //Check for alphanumeric entries
						throw new InvalidNameException("You have entered an invalid name.");
		}
		else
			//if name is null
			throw new InvalidNameException("You did not enter a name.");
	}
}
