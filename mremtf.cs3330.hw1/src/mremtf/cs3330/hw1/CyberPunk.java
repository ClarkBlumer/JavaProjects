package mremtf.cs3330.hw1;
import java.util.Scanner;

public class CyberPunk {
	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		Player player = new Player(name);
		System.out.println("The year is 2077");
		System.out.println(player.toString());
		System.out.println("Starting Console");
		Console console = new Console(player);
		while(console.use()) {
			;
		}
		input.close();
		System.out.println("Game over!");
		System.exit(0);
			
	}

}
