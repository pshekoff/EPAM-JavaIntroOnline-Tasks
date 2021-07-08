package javaIntro_6_Tasks;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserList {
	
	private List<User> users;
	private File userFile;
	private int rootPasswordHash;
	
	public UserList() {
		createFile();
	}
	
	public int getRootPasswordHash() {
		return rootPasswordHash;
	}
	
	public void createFile() {
		
		users = new ArrayList<>();
		
		userFile = new File("src/files","users.txt");
		
		if (userFile.exists()) {
			try {
				Scanner scanFile = new Scanner(new FileReader(userFile));
				
				rootPasswordHash = scanFile.nextInt();
				scanFile.nextLine();
				
				while(scanFile.hasNextLine()) {
					
					String userstr = scanFile.nextLine();
					String[] userInfo = userstr.split(";");
					
					User user = new User(userInfo[0], Integer.parseInt(userInfo[1]), userInfo[2], Boolean.parseBoolean(userInfo[3]));
					users.add(user);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			} 
		}
		else {
			Scanner scan = new Scanner(System.in);
			System.out.print("You are the first user, please, create root password: ");
			rootPasswordHash = scan.nextLine().hashCode();
			//scan.close();
			
			try(FileWriter writer = new FileWriter(userFile, true)) {

	        	writer.write(String.valueOf(rootPasswordHash));
	        	writer.close();
	        }
	        catch(IOException e) {
	            System.out.println(e.getMessage());
	        }			
		} 
	}
	
	public void saveFile(String string) {
		
        try(FileWriter writer = new FileWriter(userFile, true)) {          
        	writer.write("\n" + string);
        	writer.close();
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        } 
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
	
	public boolean checkCredentials(String login, int passwordHash) {
		boolean isOk = false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getLogin().equals(login)) {
				if (users.get(i).getPasswordHash() == passwordHash) {
					isOk = true;
				}
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
	
	public void addUser(User user) {
		users.add(user);
	}

}
