/*
 * Name:			Clark Blumer
 * Date:			9.23.2014
 * Section:			C
 * Submission Code:	Poopsies
 * 
 */

package lab3;

import java.io.FileNotFoundException;
import java.util.Random;

public class LabThreeDriver {
	
	private static int heroHits;
	private static int villainHits;

	public static void main(String[] args) throws FileNotFoundException {
			HeroFileReader heroFileReader = new HeroFileReader("DataFiles/Heroes.csv");
			Hero[] heroes = heroFileReader.getHeroes();
			LabThreeDriver.displayHeroes(heroes);
			Hero villain = LabThreeDriver.createVillain();
			System.out.println("\nVillain: " + villain.getName());
			System.out.println("");
			LabThreeDriver.battle(heroes,villain,10);
			LabThreeDriver.displayFightResults();
			LabThreeDriver.heroTraining(heroes);
			LabThreeDriver.heroHits = 0;
			LabThreeDriver.villainHits = 0;
			LabThreeDriver.battle(heroes,villain,10);
			LabThreeDriver.displayFightResults();
	}
		
	/**
	 * Simulates battle between Heroes and Villain based on their attackPoints
	 * attribute values.  
	 * 
	 * @param heroes passed in Hero[] array of Hero objects
	 * @param villain passed in Hero object
	 * @param battleRounds int value used in loop to determine how many rounds go
	 */
	public static void battle(Hero[] heroes, Hero villain, int battleRounds) {
		Random rand = new Random();
		for(int i = 0; i < battleRounds; i++) {
			// random value between 0 - heroes array length used to pick a random Hero
			int heroNumber = rand.nextInt(heroes.length);
			
			/* random value between 0 and randomly selected Hero's attackPoints 
			 * Example if Captain America was selected, heroAttackPts would be a random
			 * value between 0 - 19 because his attackPoint attribute is 20 */
			int heroAttackPts = rand.nextInt(heroes[heroNumber].getAttackPoints());
			
			if(heroAttackPts > villain.getAttackPoints()) {
				heroHits++;
				System.out.println(heroes[heroNumber].getName() + " got a successful hit with their " + heroes[heroNumber].getWeapon() + "!");
			}
			else if(villain.getAttackPoints() > heroAttackPts) {
				villainHits++;
				System.out.println("Villain " + villain.getName() + " got a successful hit with their " + villain.getWeapon() + "!");
			}
			
		}
	}
	
	/**
	 * Updates the attackPoints attribute of Hero objects
	 * 
	 * @param heroes passed Hero[] array, which is filled with Hero objects
	 */
	public static void heroTraining(Hero[] heroes) {
		for(int i = 0; i < heroes.length; i++) {
			/* current Hero object at i index gets updated AttackPoints based
			 * on current attack points, pulled from getAttackPoints() and then multiplied
			 * by 2 */
			heroes[i].updateAttackPoints(heroes[i].getAttackPoints() * 2);
		}
	}
	
	/**
	 * Creates a Hero object
	 * 
	 * @return an instantiated Hero object called villain.
	 */
	public static Hero createVillain() {
		Hero villain = new Hero("Loki", "Staff", 20);
		return villain;
	}
	
	/**
	 * Displays the name values of the Hero objects in the Hero[] array to the console.
	 * 
	 * @param heroes passed in Hero[] array of Hero objects
	 */
	public static void displayHeroes(Hero[] heroes) {
		for(int i = 0; i < heroes.length; i++) {
			System.out.println("Hero: " + heroes[i].getName());
		}
	}
	
	/**
	 * Displays the counts of heroHits and villainHits after battle() changed their values
	 */
	public static void displayFightResults() {
		System.out.println("\nBattle Stats");
		System.out.println("Hero hits on Villain " + heroHits);
		System.out.println("Villain hits on Heroes " + villainHits);
		System.out.println();
	}

}
