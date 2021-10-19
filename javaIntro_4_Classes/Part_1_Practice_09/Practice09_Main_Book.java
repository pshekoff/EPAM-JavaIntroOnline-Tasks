package javaIntro_4_Classes;

import java.util.Scanner;

public class Practice09_Main_Book {
	
	/* 9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
	 * и метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
	 * методами. Задать критерий выбора данных и вывести эти данные на консоль.
	 * 
	 * 		Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
	 * 		Найти и вывести:
	 * 		а) список книг заданного автора;
	 * 		b) список книг, выпущенных заданным издательством;
	 * 		c) список книг, выпущенных после заданного года.
	 */

	public static void main(String[] args) {
	
		Books b = new Books(2);
		Book b0 = new Book("Onegin","Pushkin","Moskow",2001,325,2500,"hard");
		Book b1 = new Book("Poems","Lermontov","TOP100",2011,187,1750,"soft");
		Book b2 = new Book("Matematika","Ivanov Gaiko","Math",2020,186,4200,"soft");
		Book b3 = new Book("Master i Margarita","Bulgakov","TOP100",2019,275,8600,"hard");
		Book b4 = new Book("Prestuplenie i nakazanie","Dostoevski","Best",2015,476,5670,"hard");
		Book b5 = new Book("Algebra","Gaiko Shpak Drozd","Math",2017,156,3300,"hard");
		b.add(b0);
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);
		b.add(b5);
		
		Scanner scan = new Scanner(System.in);
		int option = 0;
		while (true) {
			System.out.println("Choose option:"
					+ "\n(1) Add book"
					+ "\n(2) Output books list"
					+ "\n(3) Output books by author"
					+ "\n(4) Output books by publisher"
					+ "\n(5) Output books after specified year"
					+ "\n(6) Exit");
			option = scan.nextInt();
			if (option == 6) {
				break;
			}
			else if (option == 1){
				b.add(Book.addBook(scan));
			}
			else if (option == 2) {
				b.print();
			}
			else if (option == 3) {
				System.out.print("Enter author: ");
				String author = scan.next();
				b.printByAuthor(author);
			}
			else if (option == 4) {
				System.out.print("Enter publisher: ");
				String publisher = scan.next();
				b.printByPublisher(publisher);
			}
			else if (option == 5) {
				System.out.print("Enter year: ");
				int year = scan.nextInt();
				b.printByYear(year);
			}
			else {
				System.out.println("Warning: Entered option is absent!");
				continue;
			}
		}
		scan.close();
	}

}
