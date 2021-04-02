package javaIntro_4_Classes;

import java.util.Scanner;

public class Practice10_Main_Airline {

	public static void main(String[] args) {
		Airlines air = new Airlines(2);
		Airline a0 = new Airline("Minsk",123,"Boeing 737","12:30","Mon Wed");
		Airline a1 = new Airline("Moskow",34,"Airbus A320","22:45","San Tue Thu");
		Airline a2 = new Airline("Bangkok",576,"Boeing 777","18:20","Fri");
		Airline a3 = new Airline("Moskow",69,"Airbus A320","6:55","San Wed Fri");
		Airline a4 = new Airline("New York",323,"Airbus A380","8:35","Tue Sat");
		air.add(a0);
		air.add(a1);
		air.add(a2);
		air.add(a3);
		air.add(a4);
		
		Scanner scan = new Scanner(System.in);
		int option = 0;
		while (true) {
			System.out.println("Choose option:"
					+ "\n(1) Add airline"
					+ "\n(2) Output airlines list"
					+ "\n(3) Output airlines by destination"
					+ "\n(4) Output airlines by day of week"
					+ "\n(5) Output airlines by day of week and after specified time"
					+ "\n(6) Exit");
			option = scan.nextInt();
			if (option == 6) {
				break;
			}
			else if (option == 1) {
				air.add(Airline.addLine(scan));
			}
			else if (option == 2) {
				air.print();
			}
			else if (option == 3) {
				System.out.print("Enter destination: ");
				String dest = scan.next();
				air.printByDestination(dest);
			}
			else if (option == 4) {
				System.out.print("Enter day of week: ");
				String dow = scan.next();
				air.printByDayOfWeek(dow);
			}
			else if (option == 5) {
				System.out.print("Enter day of week: ");
				String dof = scan.next();
				System.out.print("Enter time: ");
				String time = scan.next();
				air.printByDayTime(dof,time);
			}
			else {
				System.out.println("Warning: Entered option is absent!");
				continue;
			}
		}
		scan.close();

	}

}
