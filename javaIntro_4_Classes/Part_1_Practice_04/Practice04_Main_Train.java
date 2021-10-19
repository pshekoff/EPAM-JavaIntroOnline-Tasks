package javaIntro_4_Classes;

import java.util.Arrays;
import java.util.Scanner;

public class Practice04_Main_Train {
	
	/* 4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
	 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива
	 * по номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
	 * Добавьте возможность сортировки массива по пункту назначения, причем поезда с одинаковыми пунктами назначения
	 * должны быть упорядочены по времени отправления.
	 */
	
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
			
			//вывод списка поездов с сортировкой
			if (option == 1) {
				int sort = 0;
				while (true) {
					System.out.println("How you wish to sort the train list?"
							+ "\n1.By train number;"
							+ "\n2.By destination(time).");
					sort = scan.nextInt();
					
					//сортировка по номеру поезда
					if (sort == 1) {
						Arrays.sort(trains, Train.sortByTrainNumber);
						System.out.println("T/n\tTime\tDestination");
						
						//вывод списка поездов
						for (int i = 0; i < trains.length; i++) {
							trains[i].output();
						}
						break;
					}
					
					//сортировка по пункту назначения (времени)
					else if (sort == 2) {
						Arrays.sort(trains, Train.sortByDestination);
						System.out.println("T/n\tTime\tDestination");
						
						//вывод списка поездов
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
			
			//вывод информации по номеру поезда
			else if (option == 2) {
				System.out.print("Enter train number ( ");
				for (int i = 0; i < trains.length; i++) {
					System.out.print(trains[i].getNumber() + " ");
				}
				System.out.print(")\n");
				int trainNum = scan.nextInt();
				System.out.println("T/n\tTime\tDestination");

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
			else if (option == 3) {
				break;
			}
			else {
				System.out.println("Warning: option is incorrect");
			}
		}
		scan.close();
	}
}
