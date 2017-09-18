package cjbq4f.cs3330.lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class LabOneDriver {

	private static Scanner input;
	private static BufferedReader reader = null;
	
	/**
	 * Count the number of occurrences for prefix, suffix, and substring 
	 * given a user input string compared against the strings stored in the file names.txt 
	 * 
	 * @param args Nothing is used from the args for this program
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		input = new Scanner(System.in);
		String[] names = initArrayOfStrings("names.txt",10);
		displayArrayOfStrings(names);
		displaySortedArrayOfStrings(names);
		
		System.out.print("Enter a string to do comparison with: ");
		String search = input.nextLine();
		final int oldSchoolSubStrCnt = oldSchoolSubstringOccurrences(names,search);
		System.out.println("Manual substring search, found: " + oldSchoolSubStrCnt);
	
		final int oldSchoolPrefixCnt = oldSchoolPrefixOccurrences(names,search);
		System.out.println("Manual prefix search, found: " + oldSchoolPrefixCnt);
		
		System.out.println("Number of suffix found:" + countSuffixOccurrences(names,search));
		
		if (countPrefixOccurrences(names,search) != oldSchoolPrefixCnt) {
			System.out.println("You have an incorrect solution!");
		}
		
		if (countSubstringOccurrences(names,search) != oldSchoolSubStrCnt) {
			System.out.println("You have an incorrect solution!");
		}
		
		input.close();
	}
	
	
	/**
	 * Initializes the an array of Strings from a file located at the names.txt
	 * 
	 * @param filePath The location of the names used for the program
	 * @param num The number of records the program wants to read
	 * @return an array of strings that is populated
	 * @throws FileNotFoundException 
	 */
	public static String[] initArrayOfStrings(String filePath, int num) {
		String[] arrayOfStrings = new String[num];
		try {
			File file = new File(filePath);
			reader = new BufferedReader(new FileReader(file));
			
			for(int i = 0; i < num; i++)
				arrayOfStrings[i] = reader.readLine();
		}//end try
		catch(IOException e){
			e.printStackTrace();
		} finally {
			try {
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		}
		return arrayOfStrings;
		
	}
	
	
	/**
	 * Displays the contents of the passed array of strings. If the array is
	 * empty will not display contents. 
	 * 
	 * @param arrayOfStrings That is populated with strings
	 */
	public static void displayArrayOfStrings(String[] arrayOfStrings) {
		for(int i = 0; i < arrayOfStrings.length; i++)
			System.out.println(arrayOfStrings[i]);
	}
	
	
	/**
	 * Displays the contents of the passed array of strings in ascending order.
	 * 
	 * @param arrayOfStrings passed in array of strings(names) from the file
	 */	
	public static void displaySortedArrayOfStrings(String[] arrayOfStrings) {
		Arrays.sort(arrayOfStrings);
		for(int i = 0; i < arrayOfStrings.length; i++){
			System.out.println(arrayOfStrings[i]);
		}
	}
	
	
	/**
	 * Counts the number string in the array that starts with the prefix using
	 * the C way traversing an array.
	 * @param arrayOfStrings takes the passed in array of strings
	 * @param prefix takes in the passed in string prefix to compare with the arrayOfStrings strings
	 * @return the number of strings found with the prefix
	 */	
	public static int oldSchoolPrefixOccurrences(String[] arrayOfStrings, String prefix) {
		int numPrefix = 0;
		int tValue = 0;
		for(int i = 0; i < arrayOfStrings.length; i++){
			for(int j = 1; j < prefix.length(); j++){
				if(arrayOfStrings[i].charAt(j-1) == prefix.charAt(j-1))
					tValue++;
			}
			if(tValue == prefix.length()){
				numPrefix++;
				tValue = 0;
			}
		}
		
		return numPrefix;
	}
	
	
	/**
	 * Counts the number of strings in the array that contain the substring using 
	 * the C way traversing an array. Counts the number of strings in the array
	 * that starts with the prefix.
	 * 
	 * @param arrayOfStrings passed in array of strings(names)
	 * @param substring the substring to search for through the arrayOfStrings
	 * @return number of strings found that contained the substring
	 */
	public static int oldSchoolSubstringOccurrences(String[] arrayOfStrings, String substring) {
		int numSubstring = 0;
		/*int tValue = 0;
		for(int i = 0; i < arrayOfStrings.length; i++){
			for(int j = 1; j < substring.length(); j++){
				if(arrayOfStrings[i].charAt(j-1) == substring.charAt(j-1))
					tValue++;
				if(tValue == substring.length()){
					numSubstring++;
					tValue = 0;
				}
			}
		}*/
		return numSubstring;			
	}
	
	
	/**
	 * Counts the number of strings in the array that start with the prefix.
	 * 
	 * @param arrayOfStrings Passed in array of strings to compare with prefix.
	 * @param prefix Passed in prefix string to compare with arrayOfStrings.
	 * @return Count the number of times the prefix is found.
	 */
	public static int countPrefixOccurrences(String[] arrayOfStrings, String prefix) {
		int numberOfPrefix = 0;
		for(int i = 0; i < arrayOfStrings.length; i++){
			if(arrayOfStrings[i].startsWith(prefix))
				numberOfPrefix++;
		}
		return numberOfPrefix;
	}
	
	
	/**
	 * Counts the number of strings in the array that end with the suffix.
	 * 
	 * @param arrayOfStrings Passed in array of strings to compare with suffix.
	 * @param suffix Passed in suffix string to compare with arrayOfStrings
	 * @return Count the number of times the suffix is found.
	 */
	public static int countSuffixOccurrences(String[] arrayOfStrings, String suffix) {
		int numberOfSuffix = 0;
		for(int i = 0; i < arrayOfStrings.length; i++){
			if(arrayOfStrings[i].endsWith(suffix))
				numberOfSuffix++;
		}
		return numberOfSuffix;
	}
	
	
	/**
	 * Counts the number of strings in the array that contain the substring.
	 * 
	 * @param arrayOfStrings Passed in array of strings to compare with substring.
	 * @param substring Passed in string substring to compare with arrayOfStrings.
	 * @return Count the number of times the substring is found.
	 */
	public static int countSubstringOccurrences (String[] arrayOfStrings, String substring) {
		int numberOfSubs = 0;
		for(int i = 0; i < arrayOfStrings.length; i++){
			if(arrayOfStrings[i].contains(substring))
				numberOfSubs++;
		}
		return numberOfSubs;
	}
}

