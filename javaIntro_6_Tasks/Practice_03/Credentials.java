package javaIntro_6_Task_3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Credentials {
	
	private List<User> users;
	private File credentials;
	private int rootPasswordHash;
	
	public Credentials() {
		createFile();
	}
	
	protected int getRootPasswordHash() {
		return rootPasswordHash;
	}
	
	public void createFile() {
		
		users = new ArrayList<>();
		
		credentials = new File("src/files","credentials.txt");
		
		if (credentials.exists()) {
			
			try {
				
				Scanner scanFile = new Scanner(new FileReader(credentials));
				rootPasswordHash = Integer.parseInt(scanFile.nextLine());

				while(scanFile.hasNextLine()) {
					
					String userData = scanFile.nextLine();
					String[] userInfo = userData.split(";");
					
					User user = new User(userInfo[0], Integer.parseInt(userInfo[1]), Boolean.parseBoolean(userInfo[2]));
					users.add(user);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		else {

			System.out.println("This is the first start of the server. You should to create root password.");
			
			Boolean exit = false;
			while(!exit) {
				
				System.out.print("Enter password: ");
				rootPasswordHash = ConsoleReader.readLine().hashCode();			
				System.out.print("Repeat password: ");
				
				if (rootPasswordHash == ConsoleReader.readLine().hashCode()) {
					
					try(FileWriter writer = new FileWriter(credentials, true)) {
			        	writer.write(String.valueOf(rootPasswordHash));
			        	writer.close();
			        }
			        catch(IOException e) {
			            System.out.println(e.getMessage());
			        }				
					exit = true;
				}
				else {
					System.out.println("Passwords doesn't match! Try again.");
				}
				
			}			
			
		} 

	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public boolean checkCredentials(String credentials) {
		boolean isOk = false;
		for (int i = 0; i < users.size(); i++) {
			if ((users.get(i).getLogin() + users.get(i).getPasswordHash()).equals(credentials)) {
				isOk = true;
			}
		}
		return isOk;
	}
	
	public boolean isAdmin(String login) {
		boolean isAdmin = false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getLogin().equals(login)) {
				if (users.get(i).isAdmin()) {
					isAdmin = true;
				}
			}
		}
		return isAdmin;
	}
	
	public boolean checkLogin(String login) {
		boolean isExist = false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getLogin().equals(login)) {
				isExist = true;
				break;
			}
		}
		return isExist;
	}
	
	public boolean isFirst() {
		boolean isFirst = false;
		if (!credentials.exists()) {
			isFirst = true;
		}
		return isFirst;
	}

	public void saveToFile(String string) {
		
        try(FileWriter writer = new FileWriter(credentials, true)) {          
        	writer.write("\n" + string);
        	writer.close();
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        } 
	}
	

	

	

}
