package javaIntro_6_Tasks;

import java.util.Scanner;

public class BookCatalogMenu {
	
	public static void startMenu() {
		
		UserList users = new UserList();
		BookCatalog books = new BookCatalog();
		
		Scanner scanner = new Scanner(System.in);
		int option = 0;

		while (true) {
			
			System.out.println("\n1. Log in\n"
								+ "2. Registration\n"
								+ "3. Exit");
			
			if (scanner.hasNextInt()) {
				option = scanner.nextInt();
			}
			else {
				scanner.next();
			}	
			
			if (option == 1) {

				System.out.print("Enter login: ");
				String login = scanner.next();
				System.out.print("Enter password: ");
				int passwordHash = scanner.next().hashCode();

				if (users.checkCredentials(login, passwordHash)) {
					if (users.isAdmin(login)) {
						bookAdminMenu(books, scanner);
					}
					else if (!users.isAdmin(login)) {
						bookUserMenu(books, scanner);
					}
				}
				else {
					System.out.println("Login or password is incorrect!");
				}
			}
			
			else if (option == 2) {
				registrationMenu(users, scanner);				
			}
			
			else if (option == 3) {
				break;
			}
			
			else {
				System.out.println("Error: chosed option is incorrect!");
			}
		}
		scanner.close();
	}
	
	public static void registrationMenu(UserList users, Scanner scanner) {
		
		int option = 0;
		
		while (true) {
			System.out.println("\n1. Register admin\n"
								+ "2. Register user\n"
								+ "3. Return back");
			
			if (scanner.hasNextInt()) {
				option = scanner.nextInt();
			}
			else {
				scanner.next();
			}	

			if (option == 1) {
				
				System.out.print("Enter root password: ");
				int passwordHash = scanner.next().hashCode();
				if (passwordHash == users.getRootPasswordHash()) {

					System.out.print("Enter login: ");
					String login = scanner.next();
					
					if (users.checkLogin(login)) {
						System.out.println("Registeration failed: Entered login is already used!");
						break;
					}
					
					System.out.print("Enter password: ");
					int newPasswordHash = scanner.next().hashCode();
					System.out.print("Repeat password: ");
					int RepeatPasswordHash = scanner.next().hashCode();
					
					if (newPasswordHash != RepeatPasswordHash) {
						System.out.println("Registeration failed: Entered passwords don't match!");
						break;
					}
					
					System.out.print("Enter e-mail: ");
					String email = scanner.next();
					
					User u = new User(login, newPasswordHash, email, true);
					users.addUser(u);
					
					users.saveFile(u.toString());
					
					break;
				}
				else {
					System.out.println("Root password incorrect!");
				}
			}
			else if (option == 2) {
				
				System.out.print("Enter login: ");
				String login = scanner.next();
				
				if (users.checkLogin(login)) {
					System.out.println("Registeration failed: Entered login is already used!");
					break;
				}
				
				System.out.print("Enter password: ");
				int newPasswordHash = scanner.next().hashCode();
				System.out.print("Repeat password: ");
				int RepeatPasswordHash = scanner.next().hashCode();
				
				if (newPasswordHash != RepeatPasswordHash) {
					System.out.println("Registeration failed: Entered passwords don't match!");
					break;
				}
				
				System.out.print("Enter e-mail: ");
				String email = scanner.next();
				
				User u = new User(login, newPasswordHash, email, false);
				users.addUser(u);
				
				users.saveFile(u.toString());
				
				break;
			}
			else if (option == 3) {
				break;
			}
			else {
				System.out.println("Error: chosed option is incorrect!");
			}
		}
	}
	
	public static void bookAdminMenu(BookCatalog books, Scanner scanner) {

		int option = 0;
		
		while (true) {
			System.out.println("\n1. Show catalog\n"
								+ "2. Search book\n"
								+ "3. Add book\n"
								+ "4. Add e-Book\n"
								+ "5. Remove book\n"
								+ "6. Logout");
			
			if (scanner.hasNextInt()) {
				option = scanner.nextInt();
			}
			else {
				scanner.next();
			}	
			
			if (option == 1) {
				books.print();
			}
			else if (option == 2) {
				System.out.print("Enter book title: ");
				scanner.nextLine();
				String title = scanner.nextLine();
				books.searchBook(title);				
			}
			else if (option == 3) {

				System.out.print("Enter book title: ");
				scanner.nextLine();
				String title = scanner.nextLine();
				System.out.print("Enter book author: ");
				String author = scanner.nextLine();
				System.out.print("Enter year of book publishing: ");
				int year = scanner.nextInt();
				
				Book b = new Book(title, author, year, false);
				books.addBook(b);
				
				books.saveFile(b.toString());
			}
			else if (option == 4) {

				System.out.print("Enter book title: ");
				scanner.nextLine();
				String title = scanner.nextLine();
				System.out.print("Enter book author: ");
				String author = scanner.nextLine();
				System.out.print("Enter year of book publishing: ");
				int year = scanner.nextInt();
				
				Book b = new Book(title, author, year, true);
				books.addBook(b);
				
				books.saveFile(b.toString());
			}
			else if (option == 5) {
				System.out.print("Enter book title to remove: ");
				scanner.nextLine();
				String title = scanner.nextLine();
				
				books.removeBook(title);
			}
			else if (option == 6) {
				break;
			}
			else {
				System.out.println("Error: chosed option is incorrect!");
			}
		}
	}
	
	public static void bookUserMenu(BookCatalog books, Scanner scanner) {

		int option = 0;
		
		while (true) {
			System.out.println("\n1. Show catalog\n"
								+ "2. Search book\n"
								+ "3. Offer book\n"
								+ "4. Logout");
			
			if (scanner.hasNextInt()) {
				option = scanner.nextInt();
			}
			else {
				scanner.next();
			}	
			
			if (option == 1) {
				books.print();
			}
			else if (option == 2) {
				System.out.print("Enter book title: ");
				scanner.nextLine();
				String title = scanner.nextLine();
				books.searchBook(title);
			}
			else if (option == 3) {
				//offer book
			}
			else if (option == 4) {
				break;
			}
			else {
				System.out.println("Error: chosed option is incorrect!");
			}
		}
	}

}
