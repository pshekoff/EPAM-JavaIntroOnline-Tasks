package javaIntro_4_Classes;

import java.util.Arrays;
import java.util.Scanner;

public class Practice04_Main_Train {
	public static void main(String[] args) {
		Train[] trains = new Train[5];
		trains[0] = new Train("Minsk", 101, "15:30");
		trains[1] = new Train("Minsk", 21, "10:45");
		trains[2] = new Train("Bern", 55, "02:20");
		trains[3] = new Train("Berlin", 108, "17:15");
		trains[4] = new Train("Minsk", 32, "09:35");
		
		Scanner scan = new Scanner(System.in);
		int option = 0;
		while (true) {
			System.out.println("Choose option:"
					+ "\n1.Print all trains and sort it;"
					+ "\n2.Print info by train number;"
					+ "\n3.Exit.");
			option = scan.nextInt();
			
			if (option == 3) {
				break;
			}	
			else if (option == 1) {
				int sort = 0;
				while (true) {
					System.out.println("How you wish to sort the train list?"
							+ "\n1.By train number;"
							+ "\n2.By destination(time).");
					sort = scan.nextInt();
					if (sort == 1) {
						Arrays.sort(trains, Train.sortByTrainNumber);
						for (int i = 0; i < trains.length; i++) {
							trains[i].output();
						}
						break;
					}
					else if (sort == 2) {
						Arrays.sort(trains, Train.sortByDestination);
						for (int i = 0; i < trains.length; i++) {
							trains[i].output();
						}
						break;
					}
					else {
						System.out.println("Warning: option is incorrect");
					}
				}
			} 
			
			else if (option == 2) {
				System.out.print("Enter train number ( ");
				for (int i = 0; i < trains.length; i++) {
					System.out.print(trains[i].getNumber() + " ");
				}
				System.out.print(")\n");
				int trainNum = scan.nextInt();
				for (int i = 0; i < trains.length; i++) {
					if (trains[i].getNumber() == trainNum) {
						trains[i].output();
						break;
					}
					if (i == trains.length-1) {
						System.out.println("Warning: entered train number is absent!");
					}
				}
			}
			else {
				System.out.println("Warning: option is incorrect");
			}
		}
		scan.close();
	}
}
