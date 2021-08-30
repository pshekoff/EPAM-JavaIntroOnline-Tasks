package javaIntro_6_Task_3;

import javaIntro_6_Task_2.ConsoleReader;

public class ArchiveMenu {

	public static void startMenu() {
        
		Boolean exit = false;
		while (!exit) {
			
			System.out.println("Choose option:\n"
							 + "1. Log in\n"
							 + "2. Registration\n"
							 + "3. Exit");
			
			int option = chooseOption(1,3);
			
			if (option == 1) {
				loginMenu();
			}			
			else if (option == 2) {
				preRegistrationMenu();
			}			
			else if (option == 3) {
				exit = true;
			}		
			else {
				System.out.println("Incorrect option! Try again.");
			}
		}

	}
	
	public static void loginMenu() {
		
		try {
			Boolean exit = false;
			while (!exit) {
				
				System.out.print("Enter login or press Enter to quit: ");
				String login = ConsoleReader.readLine();
				
				if (login.equals("")) {
					exit = true;
					break;
				}
				
				System.out.print("Enter password: ");
				int passwordHash = ConsoleReader.readLine().hashCode();
				
				//sending credentials to server
				Client.packet.setType("credentials");
				Client.packet.setValue(login + passwordHash);
				Client.out.reset();
				Client.out.writeObject(Client.packet);
				Client.out.flush();
	    	
				if (Client.in.readBoolean()) {
					
					Client.packet.setType("isAdmin");
					Client.packet.setValue(login);
					Client.out.reset();
					Client.out.writeObject(Client.packet);
					Client.out.flush();
		    	
					if (Client.in.readBoolean()) {
						adminMenu();
						exit = true;
					}
					else {
						userMenu();
						exit = true;
					}
				}	
				else {
					System.out.println("Login or password incorrect!");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void adminMenu() {
		
		try {
			Boolean exit = false;
			while (!exit) {

				System.out.println("Choose option:\n"
				 		 + "1. Show students list\n"
				 		 + "2. Add student\n"
				 		 + "3. Edit student\n"
				 		 + "4. Log out");
				
				int option = chooseOption(1,4);
				
				//print student list
				if (option == 1) {
					
					Client.packet.setType("printall");
					Client.out.reset();
					Client.out.writeObject(Client.packet);
					Client.out.flush();
					
					int size = Client.in.read();
            		
					for (int i = 0; i < size; i++) {
            			System.out.println(Client.in.readUTF());
            		}
					System.out.println();
				}
				
				//add new student
				else if (option == 2) {
					
					String name, birthDate, group;
					
					while (true) {
						
						System.out.println("Enter name: ");
						name = ConsoleReader.readLine();
						
						System.out.println("Enter birthDate: ");
						birthDate = ConsoleReader.readLine();
						
						System.out.println("Enter group: ");
						group = ConsoleReader.readLine();
						
						if (name.isBlank() || birthDate.isBlank() || group.isBlank()) {
							System.out.println("Not all data has been entered, please try again.");
						}
						else {
							break;
						}
					}
					
					Client.packet.setType("newStudent");
					Client.packet.setValue(name + ";" + birthDate + ";" + group);
					
					Client.out.reset();
					Client.out.writeObject(Client.packet);
					Client.out.flush();
				}
				
				//edit student
				else if (option == 3) {
					
					Client.packet.setType("getMaxId");
					
					Client.out.reset();
					Client.out.writeObject(Client.packet);
					Client.out.flush();
					
					int maxId = Client.in.read();
					System.out.print("Enter student id (maxId=" + maxId + "): ");
					int id = chooseOption(1,maxId);
					
					String studentStr = String.valueOf(id) + "; ";
					System.out.println("Entem new name or press enter to skip:");
					studentStr += ConsoleReader.readLine() + "; ";
					System.out.println("Entem new birthDate or press enter to skip:");
					studentStr += ConsoleReader.readLine() + "; ";
					System.out.println("Entem new group or press enter to skip:");
					studentStr += ConsoleReader.readLine();

					Client.packet.setType("editStudent");
					Client.packet.setValue(studentStr);
					
					Client.out.reset();
					Client.out.writeObject(Client.packet);
					Client.out.flush();
					
				}
				
				//exit from adminMenu
				else if (option == 4) {
					exit = true;
				}		
				else {
					System.out.println("Incorrect option! Try again.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void userMenu() {
		
		System.out.println("Choose option:\n"
				 		 + "1. Show students list\n"
				 		 + "2. Log out");
		
		try {
			Boolean exit = false;
			while (!exit) {

				int option = chooseOption(1,2);
				
				//print student list
				if (option == 1) {
					
					Client.packet.setType("printall");
					Client.out.reset();
					Client.out.writeObject(Client.packet);
					Client.out.flush();
					
					int size = Client.in.read();
            		
					for (int i = 0; i < size; i++) {
            			System.out.println(Client.in.readUTF());
            		}
					System.out.println();
				}	
				
				//exit from userMenu
				else if (option == 2) {
					exit = true;
				}		
				else {
					System.out.println("Incorrect option! Try again.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void preRegistrationMenu() {
		try {
			
			Boolean exit = false;
			while (!exit) {
				System.out.println("1. Register admin.\n"
						 		 + "2. Register user.\n"
						 		 + "3. Return back.");

				int option = chooseOption(1,3);
			
				//admin registration
				if (option == 1) {
					
					while (true) {
						System.out.print("Enter root password or press Enter to quit: ");
					   	String pass = ConsoleReader.readLine();
					   	
					   	if (pass.equals("")) {
					   		exit = true;
							break;
						}
					   	else {
							Client.packet.setType("root");
							Client.packet.setValue(String.valueOf(pass.hashCode()));
							Client.out.reset();
							Client.out.writeObject(Client.packet);
							Client.out.flush();	
							
							if (Client.in.readBoolean()) {
								registrationMenu(true);
								exit = true;
								break;
							}
							else {
								System.out.println("Root password incorrect!");
							}

					   	}

					}

				}
				
				//user registration
				else if (option == 2) {
					registrationMenu(false);
					exit = true;
				}
				
				//exit from registration menu
				else if (option == 3) {
					break;
				}
				else {
					System.out.println("Incorrect option! Try again.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void registrationMenu(Boolean isAdmin) {
		
		try {		

			Boolean exit = false;
			while (!exit) {
					
				System.out.print("Enter login or press Enter to quit: ");
			   	String login = ConsoleReader.readLine();
					
			   	if (login.equals("")) {
					break;
				}
			   		
			   	Client.packet.setType("login");
			   	Client.packet.setValue(login);
				Client.out.reset();
			   	Client.out.writeObject(Client.packet);
			   	Client.out.flush();
			   		
			   	if (!Client.in.readBoolean()) {
			   		System.out.print("Enter password: ");
			   		int passwordHash = ConsoleReader.readLine().hashCode();
			   		System.out.print("Repeat password: ");
			   		int passwordHashRepeat = ConsoleReader.readLine().hashCode();
			   			
			   		if (passwordHash == passwordHashRepeat) {
			   			if (isAdmin) {
			   				Client.packet.setType("adminReg");
			   			}
			   			else {
			   				Client.packet.setType("userReg");
			   			}
			   			Client.packet.setValue(login + ";" + passwordHash);
						Client.out.reset();
			   			Client.out.writeObject(Client.packet);
			   			Client.out.flush();
			   			exit = true;
			   		}
			   		else {
			   			System.out.println("Passwords doesn't match! Try again.");
			   		}
			   	}
			   	else {
			   		System.out.println("This login is already exist!");
			   	}
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
