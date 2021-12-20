package by.pkirvel.bookcatalog.main;

import by.pkirvel.bookcatalog.controller.CommandType;
import by.pkirvel.bookcatalog.controller.Controller;

public class BookCatalogMenu {
	
	public static void loginMenu(Controller controller) {
		
		while (true) {
			System.out.println("\n1. Login\n"
								+ "2. Registration\n"
								+ "3. Exit");
			
			int option = chooseOption(1,3);

			if (option == 1) {
				//logination
				System.out.println("Enter login: ");
				String login = ConsoleReader.readLine();

				System.out.println("Enter password: ");
				String password = ConsoleReader.readLine();
				
				String request = CommandType.LOGINATION + ";login=" + login + ";password=" + password;
				String response = controller.doAction(request);
				String[] result = response.split("=");
				
				//respond
				if (result[0].equals("1")) {
					//successfull logination
					System.out.println(result[1]);
					
					request = CommandType.ADMINCHECKING + ";login=" + login;
					response = controller.doAction(request);
					result = response.split("=");
					
					//check user role
					if (result[0].equals("1")) {
						//administrator
						System.out.println(result[1]);
						adminMenu(controller);
					} else {
						//user
						System.out.println(result[1]);
						userMenu(controller);
					}
				} else {
					//logination failed
					System.out.println(result[1]);
				}
			}
			
			else if (option == 2){
				//registration
				registrationMenu(controller);
			}
			
			else if (option == 3) {
				//exit
				break;
			}
		}
	}
	
	
	public static void registrationMenu(Controller controller) {
		while (true) {
			System.out.println("\n1. New user\n"
								+ "2. New admin\n"
								+ "3. Back");
			
			int option = chooseOption(1,3);
			
			if (option == 1 || option == 2) {
				//add user
				System.out.println("Enter login: ");
				String login = ConsoleReader.readLine();
				
				//check if user is already exist
				String request = CommandType.USERCHECKING + ";login=" + login;
				String response = controller.doAction(request);
				String[] result = response.split("=");
				
				if (result[0].equals("1")) {
					System.out.println("User with the same login is already exist");
					continue;
				}
	
				System.out.println("Enter password: ");
				String password = ConsoleReader.readLine();
				
				System.out.println("Confirm password: ");
				String password2 = ConsoleReader.readLine();
				
				if (!password.equals(password2)) {
					System.out.println("Passwords are not equal!");
					continue;
				}
				
				System.out.println("Enter email: ");
				String email = ConsoleReader.readLine();
				
				boolean admin = false;
				if (option == 2) {
					admin = true;
				}

				request = CommandType.REGISTRATION + ";login=" + login + ";password=" + password + ";email=" + email + ";admin=" + admin;
				response = controller.doAction(request);
				result = response.split("=");
				
				//respond
				if (result[0].equals("1")) {
					System.out.println(result[1]);
					break;
				} else {
					System.out.println(result[1]);
					break;
				}
			}
			
			else if (option == 3) {
				//exit
				break;
			}
		}
	}
	
	public static void adminMenu(Controller controller) {
		
		String request;
		String response;
		String[] result;
		
		while (true) {
			System.out.println("\n1. Show catalog\n"
								+ "2. Search book\n"
								+ "3. Add book\n"
								+ "4. Remove book\n"
								+ "5. Logout");
			
			int option = chooseOption(1,5);
			
			if (option == 1) {
				//show book catalog
				int i = 1; //book index
				int page = 0; //current page
				int rowsPerPage = 10; //rows count per page
				boolean lastPage = false;
				
				while (true) {
					
					for (int j = 1; j <= rowsPerPage; j++) {
						request = CommandType.BOOKRECEIVING + ";index=" + i;
						response = controller.doAction(request);
						result = response.split("=");
						
						if (result[0].equals("1")) {
							System.out.println(result[1]);
						} else {
							System.out.println(result[1]);
							lastPage = true;
							i += rowsPerPage - j + 1;
							break;
						}
	
						i++;
					}
					
					page = (int) Math.floor(i/10.0);
					
					if (page == 1) {
						System.out.println("1 - next page;\t2 - exit."); 
						int opt = chooseOption(1,2);
						if (opt == 2) {
							break;
						}
					}
					
					else if (!lastPage) {
						System.out.println("0 - previouse page;\t1 - next page;\t2 - exit."); 
						int opt = chooseOption(0,2);
						if (opt == 0) {
							i -= rowsPerPage*2;
						}
						else if (opt == 2) {
							break;
						}
					}
					
					else {
						System.out.println("0 - previouse page;\t2 - exit."); 
						int opt = chooseOption(0,2);
						if (opt == 0) {
							i -= rowsPerPage*2;
							lastPage = false;
						}
						else if (opt == 1) {
							System.out.println("Incorrect option! Try again.");
							i -= rowsPerPage;
						}
						else if (opt == 2) {
							break;
						}
					}	
					
				}
			}
			
			else if (option == 2) {
				//search book by title
				System.out.println("Enter book title (or enter \"q\" to exit) ");
				String title = ConsoleReader.readLine();
					
				if (title.equals("q")) {
					continue;
				}
					
				request = CommandType.BOOKRECEIVING + ";title=" + title;
				response = controller.doAction(request);
				result = response.split("=");
					
				System.out.println(result[1]);
			}
			
			else if (option == 3) {
				//add book
				while (true) {
					System.out.println("Enter book title (or enter \"q\" to exit) ");
					String title = ConsoleReader.readLine();

					if (title.equals("q")) {
						break;
					}
					//check if book is already exist
					request = CommandType.BOOKCHECKING + ";title=" + title;
					response = controller.doAction(request);
					result = response.split("=");
					
					if (result[0].equals("1")) {
						System.out.println(result[1]);
						continue;
					}
					
					System.out.println("Enter book author (or enter \"q\" to exit) ");
					String author = ConsoleReader.readLine();
					
					if (author.equals("q")) {
						break;
					}
					
					System.out.println("Enter year of publishing (or enter \"q\" to exit) ");
					int year = ConsoleReader.readInt();

					if (year == -1) {
						break;
					}

					System.out.println("Is it e-Book? \"y/n\" (or enter \"q\" to exit) ");
					String eBook = ConsoleReader.readYN();
					
					if (eBook.equals("q")) {
						break;
					}

					request = CommandType.BOOKADDING + ";title=" + title + ";author=" + author + ";year=" + year + ";ebook=" + eBook;
					response = controller.doAction(request);
					result = response.split("=");
					
					//respond
					if (result[0].equals("1")) {
						System.out.println(result[1]);
						//send to email to all
						request = CommandType.EMAILSENDING + ";recipients=users";
						response = controller.doAction(request);
						result = response.split("=");
						System.out.println(result[1]);
						break;
					} else {
						System.out.println(result[1]);
						break;
					}
				}			
			}
			
			else if (option == 4) {
				//remove book
				System.out.println("Enter book title (or enter \"q\" to exit) ");
				String title = ConsoleReader.readLine();
					
				if (title.equals("q")) {
					continue;
				}
					
				request = CommandType.BOOKREMOVING + ";title=" + title;
				response = controller.doAction(request);
				result = response.split("=");
					
				System.out.println(result[1]);
			}
			
			else if (option == 5) {
				//logout
				break;
			}
		}
	}
	
	
	public static void userMenu(Controller controller) {
		
		String request;
		String response;
		String[] result;
		
		while (true) {
			System.out.println("\n1. Show catalog\n"
							+ "2. Search book\n"
							+ "3. Offer book\n"
							+ "4. Logout");
			
			int option = chooseOption(1,4);
			
			if (option == 1) {
				//show book catalog
				int i = 1; //book index
				int page = 0; //current page
				int rowsPerPage = 10; //rows count per page
				boolean lastPage = false;
				
				while (true) {
					
					for (int j = 1; j <= rowsPerPage; j++) {
						request = CommandType.BOOKRECEIVING + ";index=" + i;
						response = controller.doAction(request);
						result = response.split("=");
						
						if (result[0].equals("1")) {
							System.out.println(result[1]);
						} else {
							System.out.println(result[1]);
							lastPage = true;
							i += rowsPerPage - j + 1;
							break;
						}
	
						i++;
					}
					
					page = (int) Math.floor(i/10.0);
					
					if (page == 1) {
						System.out.println("1 - next page;\t2 - exit."); 
						int opt = chooseOption(1,2);
						if (opt == 2) {
							break;
						}
					}
					
					else if (!lastPage) {
						System.out.println("0 - previouse page;\t1 - next page;\t2 - exit."); 
						int opt = chooseOption(0,2);
						if (opt == 0) {
							i -= rowsPerPage*2;
						}
						else if (opt == 2) {
							break;
						}
					}
					
					else {
						System.out.println("0 - previouse page;\t2 - exit."); 
						int opt = chooseOption(0,2);
						if (opt == 0) {
							i -= rowsPerPage*2;
							lastPage = false;
						}
						else if (opt == 1) {
							System.out.println("Incorrect option! Try again.");
							i -= rowsPerPage;
						}
						else if (opt == 2) {
							break;
						}
					}	
					
				}
			}
			
			else if (option == 2) {
				//search book by title
				System.out.println("Enter book title (or enter \"q\" to exit) ");
				String title = ConsoleReader.readLine();
					
				if (title.equals("q")) {
					continue;
				}
					
				request = CommandType.BOOKRECEIVING + ";title=" + title;
				response = controller.doAction(request);
				result = response.split("=");
					
				System.out.println(result[1]);
			}
			
			else if (option == 3) {
				//offer book
				while (true) {
					System.out.println("Enter book title (or enter \"q\" to exit) ");
					String title = ConsoleReader.readLine();

					if (title.equals("q")) {
						break;
					}
					//check if book is already exist
					request = CommandType.BOOKCHECKING + ";title=" + title;
					response = controller.doAction(request);
					result = response.split("=");
					
					if (result[0].equals("1")) {
						System.out.println(result[1]);
						continue;
					}
					
					System.out.println("Enter book author (or enter \"q\" to exit) ");
					String author = ConsoleReader.readLine();
					
					if (author.equals("q")) {
						break;
					}
					
					System.out.println("Enter year of publishing (or enter \"q\" to exit) ");
					int year = ConsoleReader.readInt();

					if (year == -1) {
						break;
					}

					System.out.println("Is it e-Book? \"y/n\" (or enter \"q\" to exit) ");
					String eBook = ConsoleReader.readYN();
					
					if (eBook.equals("q")) {
						break;
					}

					request = CommandType.EMAILSENDING + ";recipients=admins";
					response = controller.doAction(request);
					result = response.split("=");
					System.out.println(result[1]);
					
					break;
				}	
				
			}
			
			else if (option == 4) {
				//logout
				break;
			}

		}
	}
	
	
	public static void catalogMenu(Controller controller) {
		
	}
	
	
	public static int chooseOption(int from, int to) {
		int option = ConsoleReader.readInt();
		if (option < from || option > to) {
			System.out.println("Incorrect option! Try again.");
			return chooseOption(from, to);
		}
		else {
			return option;
		}
	}
}
