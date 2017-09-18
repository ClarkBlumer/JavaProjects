/**	
 * 	Name:		Clark Blumer
 * 	Pawprint:	cjbq4f
 * 	Date:		10.27.2014
 * 	Section:	C
 * 	Lab Code:	derF
 */

package cjbq4f.cs3330.lab7;

import java.util.ArrayList;

public class LabSevenDriver {

	public static void main(String[] args) {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Hawk("Hawk"));
		animals.add(new Bat("Bat"));
		animals.add(new Snake("Snake"));
		animals.add(new Monkey("Monkey"));
		
		findWhoCanEatWho(animals);
		findWhoCanFly(animals);
		findWhoCantFly(animals);

	}
	
	/**
	 * 
	 * @param animals
	 */
	private static void findWhoCanFly(ArrayList<Animal> animals) {
		System.out.println("\nAnimals that can fly");
		
		for(int i = 0; i < animals.size(); i++)	{
			/* If the Animal object at i index is an instance of Flying, then
			 * print messages based on whether the Animal has wings or legs.
			 * Since it is an instance of Flying, it *should* have wings. */
			if(animals.get(i) instanceof Flying) {
				System.out.print(animals.get(i).getType()); //Gets the type associated with the object at i index and prints to screen
				if(animals.get(i).getWings())
					System.out.print(" has wings");
				else
					System.out.print(" has no wings");
				if(animals.get(i).getLegs())
					System.out.print(" and has legs");
				else
					System.out.print(" and no legs");
				
				System.out.println();//new line break
				
				/* Display take off and landing messages for the current Animal */
				((Flying) animals.get(i)).takeOff();
				((Flying) animals.get(i)).land();
			} //end instanceof if
			
		} //end for loop
			
	}

	/**
	 * 
	 * @param animals
	 */
	private static void findWhoCantFly(ArrayList<Animal> animals) {
		/* Same logic as findWhoCanFly applies for this method */
		System.out.println("\nAnimals that can't fly");
		for(int i = 0; i < animals.size(); i++) {
			if(animals.get(i) instanceof NonFlying) {
				System.out.print(animals.get(i).getType());
				if(animals.get(i).getWings())
					System.out.print(" has wings");
				else
					System.out.print(" has no wings");
				if(animals.get(i).getLegs())
					System.out.print(" and has legs");
				else
					System.out.print(" and has no legs");
				System.out.println();
				
				/* Displays the movement of the current NonFlying Animal */
				((NonFlying) animals.get(i)).movement();
			}
		}
	}
	
	/**
	 * 
	 * @param animals
	 */
	private static void findWhoCanEatWho(ArrayList<Animal> animals) {
		System.out.println("Edible Animals");
		for(int i = 0; i < animals.size(); i++) {
			if(!(animals.get(i) instanceof Snake)){
			System.out.print(animals.get(i).getType());
			if(animals.get(i).getWings())
				System.out.print(" has wings");
			else
				System.out.print(" has no wings");
			if(animals.get(i).getLegs())
				System.out.print(" and has legs");
			else
				System.out.print(" and has no legs");
			System.out.print(" and ate a ");
			for(int j = 0; j < animals.size(); j++){
			if(animals.get(i).eat(animals.get(j)))
				System.out.print(animals.get(j).getType() + " ");
			}//inner for loop
			System.out.println();
			}//instanceof Snake
		}//for loop
	}
}
