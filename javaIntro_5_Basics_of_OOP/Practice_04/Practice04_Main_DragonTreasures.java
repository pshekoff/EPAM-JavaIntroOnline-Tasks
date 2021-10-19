package javaIntro_5_Basics_of_OOP;

import java.util.Scanner;

public class Practice04_Main_DragonTreasures {
	
	/* Задача 4.
	 * Создать консольное приложение, удовлетворяющее следующим требованиям:
	 *  - Приложение должно быть объектно-, а не прецедурно-ориентированным.
	 *  - Каждый класс должен иметь отражающее смысл название и информационный состав.
	 *  - Наследование должно применяться только тогда, когда это имеет смысл.
	 *  - При кодировании должны быть использованы соглашения об оформлении кода java code convention.
	 *  - Классы должны быть грамотно разложены по пакетам.
	 *  - Консольное меню должно быть минимальным.
	 *  - Для хранения данных можно использовать файлы.
	 *  
	 * Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в
	 * пещере дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости
	 * сокровища и выбора сокровищ на заданную сумму.
	 */

	public static void main(String[] args) {
		
		//пещера дракона
		Cave dragonCave = new Cave("dragon");
		
		//добавление 100 сокровищ
		for (int i = 0; i < 100; i++) {
			Treasure t = new Treasure("Treasure "+(i+1));
			dragonCave.addTreasure(t);
		}
		
		Scanner scan = new Scanner(System.in);
		
		//консольное  меню
		while(true) {
			System.out.println("\nChoose option:"
							+ "\n(1) Show all treasures;"
							+ "\n(2) Show greatest treasure;"
							+ "\n(3) Show treasures by cost"
							+ "\n(4) Exit");
			
			int option = scan.nextInt();
			
			//show all
			if (option == 1) {
				for (int i = 0; i < dragonCave.getTreasures().size(); i++) {
					System.out.println(dragonCave.getTreasures().get(i).toString());
				}
			}
			//show greatest
			else if (option == 2) {
				dragonCave.printGreatestTreasure();
			}
			//show by cost
			else if (option == 3) {
		    	System.out.print("Enter maximus treasure cost: ");
		    	int cost = scan.nextInt();
				dragonCave.printTreasuresByCost(cost);
			}
			//exit
			else if (option == 4) {
				break;
			}
		}
		
		scan.close();		
		
	}

}
