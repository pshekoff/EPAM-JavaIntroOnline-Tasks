package javaIntro_4_Classes;

import java.util.Scanner;

public class Part2_Practice04_Main_Accounts {
	
	/* 4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
	 * счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
	 * всем счетам, имеющим положительный и отрицательный балансы отдельно.
	 */

	public static void main(String[] args) {
		
		//клиенты
		Client c1 = new Client("K","A","C","M","MP1232357",5432390);
		Client c2 = new Client("A","D","D","D","MP3334621",7488437);
		Client c3 = new Client("S","S","S","S","MP8421368",8549042);

		//счета клиентов
		Account a1 = new Account(c1);
		Account a2 = new Account(c2);
		Account a3 = new Account(c3);
		Account a4 = new Account(c1);
		Account a5 = new Account(c3);
		Account a6 = new Account(c1);
		
		//операции со счетами
		a1.changeAmount(-3000);
		a1.changeStatus("blocked");
		a2.changeAmount(4500);
		a3.changeAmount(3240);
		a4.changeAmount(-1200);
		a4.changeStatus("blocked");
		a5.changeAmount(380);
		a6.changeAmount(670);
		
		Accounts list1 = new Accounts();
		list1.addAccount(a1);
		list1.addAccount(a2);
		list1.addAccount(a3);
		list1.addAccount(a4);
		list1.addAccount(a5);
		list1.addAccount(a6);
		
		list1.Sort();
		
		Scanner scan = new Scanner(System.in);
		int option = 0;
		while (true) {
			//вывод списка клиентов для выбора
			System.out.print("Clients:\n" + c1.toString() + "\n" + c2.toString() + "\n" + c3.toString() + "\n\nSelect client (id): ");
			int clientID = scan.nextInt();
			
			//вывод счетов выбранного клиента
			System.out.println("Accounts list:");
			list1.output(clientID);
			
			//меню выбора операции со счетами клиента
			System.out.println("\nChoose option:"
							+ "\n(1) Calculate total amount;"
							+ "\n(2) Calculate sum by positive account's amounts;"
							+ "\n(3) Calculate sum by negative account's amounts;"
							+ "\n(4) Exit.");
			option = scan.nextInt();
			
			if (option == 1) {
				//вычисление общей суммы по счетам
				System.out.println("Total amount: " + list1.getTotalAmount(clientID,0));
			}
			if (option == 2) {
				//вычисление общей суммы по положительным счетам
				System.out.println("Positive balance: " + list1.getTotalAmount(clientID,1));
			}	
			if (option == 3) {
				//вычисление общей суммы по отрицательным счетам
				System.out.println("Negative balance: " + list1.getTotalAmount(clientID,-1));
			}
			if (option == 4) {
				//выход
				break;
			}
		}
		scan.close();
	}

}
