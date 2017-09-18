/* Name:		Clark Blumer
 * Pawprint:	cjbq4f
 * Date:		10.20.2014
 * Lab Code:	Royals * 
 */

package cjbq4f.cs3330.lab6;

public class DatabaseDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "Data/Goons.csv";
		GoonDatabase goonDB = new GoonDatabase(filePath); //instantiates a new GoonDataBase object and passes the file path to the constructor
		goonDB.searchMenu(); //calls the searchMenu() method in GoonDataBase
	}

}
