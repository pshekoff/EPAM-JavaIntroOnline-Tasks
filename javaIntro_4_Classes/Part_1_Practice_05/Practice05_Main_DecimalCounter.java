package javaIntro_4_Classes;

import java.util.Scanner;

public class Practice05_Main_DecimalCounter {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int option = 0;
		DecimalCounter dc = new DecimalCounter();
		do {
			System.out.println("Choose the option:\t(1) Use default decimal counter\t(2) Create a custom decimal counter");
			option = scan.nextInt();
			if (option == 1) {
				break;
			}
			else if (option == 2) {
				System.out.println("Set low value, top value and current value:");
				int l = scan.nextInt();
				int t = scan.nextInt();
				int c = scan.nextInt();
				dc = new DecimalCounter(l,t,c);
			}
			else {
				System.out.println("Warning: entered option is absent.");
			}
		} while ((option != 1)&(option != 2));
		System.out.println("Decimal counter has been created. Diapazon is [" + dc.getLowValue() + ";" + dc.getTopValue() + "]. Current value is: " + dc.getCurrentValue());
		do {
			System.out.println("Choose option:\t(1) Increase counter\t(2) Decrease counter\t(3) Show current value\t(4) Exit");
			option = scan.nextInt();
			switch (option) {
			case (1):
				dc.increase();
				break;
			case (2):
				dc.decrease();
				break;
			case (3):
				System.out.println("Current value is " + dc.getCurrentValue());
				break;
			}
			if ((option != 1)&(option != 2)&(option != 3)&(option != 4)) {
				System.out.println("Warning: entered option is absent.");
			}
		} while (option != 4);
		scan.close();
	}
}