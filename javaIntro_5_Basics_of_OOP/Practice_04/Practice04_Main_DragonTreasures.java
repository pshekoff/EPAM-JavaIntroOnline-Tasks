package javaIntro_5_Basics_of_OOP;

import java.util.Scanner;

public class Practice04_Main_DragonTreasures {

	public static void main(String[] args) {

		Cave dragonCave = new Cave("dragon");

		for (int i = 0; i < 100; i++) {
			Treasure t = new Treasure("Treasure "+(i+1));
			dragonCave.addTreasure(t);
		}
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("\nChoose option:"
					+ "\n(1) Show all treasures;"
					+ "\n(2) Show greatest treasure;"
					+ "\n(3) Show treasures by cost"
					+ "\n(4) Exit");
			
			int option = scan.nextInt();
			
			if (option == 1) {
				for (int i = 0; i < dragonCave.getTreasures().size(); i++) {
					System.out.println(dragonCave.getTreasures().get(i).toString());
				}
			}
			else if (option == 2) {
				dragonCave.printGreatestTreasure();
			}
			else if (option == 3) {
		    	System.out.print("Enter maximus treasure cost: ");
		    	int cost = scan.nextInt();
				dragonCave.printTreasuresByCost(cost);
			}
			else if (option == 4) {
				break;
			}
		}
		
		scan.close();		
		
	}

}
