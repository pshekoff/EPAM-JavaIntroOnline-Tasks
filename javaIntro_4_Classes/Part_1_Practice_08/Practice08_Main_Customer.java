package javaIntro_4_Classes;

import java.util.Scanner;

public class Practice08_Main_Customer {
	
	/* 8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
	 * и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и
	 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
	 * 
	 * 		Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
	 * 		Найти и вывести:
	 * 		а) список покупателей в алфавитном порядке;
	 * 		b) список покупателей, у которых номер кредитной карточки находятся в заданном интервале.
	 */

	public static void main(String[] args) {
		Customers c = new Customers(2);
		Customer c0 = new Customer("K","P","I","W",1,"1111");
		Customer c1 = new Customer("K","A","C","M",2,"2222");
		Customer c2 = new Customer("K","P","C","R",3,"3333");
		Customer c3 = new Customer("G","N","G","M",4,"4444");
		Customer c4 = new Customer("G","E","I","R",5,"5555");
		Customer c5 = new Customer("I","I","I","B",6,"6666");
		Customer c6 = new Customer("H","H","H","H",7,"7777");
		c.add(c0);
		c.add(c1);
		c.add(c2);
		c.add(c3);
		c.add(c4);
		c.add(c5);
		c.add(c6);
		c.sortByName();
		c.output();
		
		Scanner scan = new Scanner(System.in);
		int option = 0;
		while (true) {
			System.out.println("Choose option:"
					+ "\n(1) Add customer"
					+ "\n(2) Customers list output sorting by name"
					+ "\n(3) Customers list output by card diapazon"
					+ "\n(4) Exit");
			option = scan.nextInt();
			if (option == 4) {
				break;
			}
			else if (option == 1) {
				c.add(Customer.createCustomer(scan));
			}
			else if (option == 2) {
				c.sortByName();
				c.output();
			}
			else if (option == 3) {
				System.out.print("Enter card diapazon:");
				int fromNumber = scan.nextInt();
				int toNumber = scan.nextInt();
				c.getCustomersByCardDiapazon(fromNumber, toNumber);
			}
			else {
				System.out.println("Warning: Entered option is absent!");
				continue;
			}
		}
		scan.close(); 
	}

}
