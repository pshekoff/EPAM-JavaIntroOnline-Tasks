package javaIntro_5_Basics_of_OOP;

import java.util.Scanner;

public class Practice02_Main_Payment {
	
	/* Задача 2.
	 * Создать класс Payment с внутренним классом, с помощью объектов которого
	 * можно сформировать покупку из нескольких товаров. 
	 */

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int option = 0;
		Payment payment = new Payment();
		
		while (true) {
			
			System.out.println("\nChoose option:"
							+ "\n(1) Add product;"
							+ "\n(2) Finish shopping.");
			
			option = scan.nextInt();
			
			if (option == 1) {
				payment.addProduct(payment.new Product(scan));
			}
			else if (option == 2) {
				break;
			}
			else {
				System.out.println("Select correct option!");
			}
		}

		payment.print();
	}

}
