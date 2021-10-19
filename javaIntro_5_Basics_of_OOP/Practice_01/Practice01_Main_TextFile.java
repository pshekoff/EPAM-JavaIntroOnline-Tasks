package javaIntro_5_Basics_of_OOP;

import java.util.Scanner;
import java.io.*;

public class Practice01_Main_TextFile {
	
	/* Задача 1.
	 * Создать объект класса Текстовый файл, используя классы Файл, Директория.
	 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
	 */

	public static void main(String[] args) {
		
		//директория
		File dir = new File("C:/test");
		dir.mkdir();

		Scanner scan = new Scanner(System.in);
		int option = 0;
		
		while (true) {
						
			System.out.println("\nChoose option:"
					+ "\n(1) Create file;"
					+ "\n(2) Rename file;"
					+ "\n(3) Open file"
					+ "\n(4) Add text"
					+ "\n(5) Delete file"
					+ "\n(6) Get file list"
					+ "\n(7) Exit");

			option = scan.nextInt();

			//file creation
			if (option == 1) {
				
				System.out.print("Enter file name: ");
				String name = scan.next();
		        TextFile newFile = new TextFile(dir, name);
				
		        try {
		            boolean created = newFile.createNewFile();
		            if(created) {
		                System.out.println("File has been created");
		            }
		        }
		        catch (IOException e) {
		        	System.out.println(e.getMessage());
		        }
			}
			
			//file renaming
			else if (option == 2) {
				
				System.out.println("Choose the file you want to rename (enter file name):");
				
				for (File file : dir.listFiles()) {
					System.out.println(file.getName());
				}
				
				String name = scan.next();
				TextFile oldFile = new TextFile(dir, name);
				
				System.out.print("Enter new name: ");
				String newName = scan.next();
				TextFile newFile = new TextFile(dir, newName);
								
				if (newFile.exists()) {
					System.out.println("A file with the name you entered is already exist.");
				}
				
				boolean renamed = oldFile.renameTo(newFile);

				if (!renamed) {
					System.out.println("The file was not renamed.");
				}
			}
			
			//file opening
			else if (option == 3) {
				
				System.out.println("Choose the file you want to open (enter file name):");
				
				for (File file : dir.listFiles()) {
					System.out.println(file.getName());
				}
				
				String name = scan.next();
				TextFile file = new TextFile(dir, name);
				
				try (FileReader reader = new FileReader(file)) {
					Scanner sc = new Scanner(reader);
					while (sc.hasNextLine()) {
						System.out.println(sc.nextLine());
					}
					reader.close();
					sc.close();
				}
		        catch(IOException e) {
		            System.out.println(e.getMessage());
		        }
			}
			
			//adding text
			else if (option == 4) {
				
				System.out.println("Choose the file you want to edit (enter file name):");
				
				for (File file : dir.listFiles()) {
					System.out.println(file.getName());
				}
				
				String name = scan.next();
				TextFile file = new TextFile(dir, name);
				
		        try(FileWriter writer = new FileWriter(file, true)) {
		        	
		        	System.out.println("Type a text you want to add: ");
		            scan.nextLine();
		            String text = scan.nextLine();
		            
		        	writer.write("\n" + text);
		        	writer.close();
		        }
		        catch(IOException e) {
		            System.out.println(e.getMessage());
		        } 
		    } 
			
			//file deleting
			else if (option == 5) {
				
				System.out.println("Choose the file you want to delete (enter file name):");
				
				for (File file : dir.listFiles()) {
					System.out.println(file.getName());
				}
				
				String name = scan.next();
				TextFile file = new TextFile(dir, name);
				
		        if(file.delete()) {
		        	System.out.println("File has been deleted");
		        }
		        else {
		        	System.out.println("‘айл file.txt не был найден в корневой папке проекта");
		        }
			}
			
			//getting file list
			else if (option == 6) {
				
				for (File file : dir.listFiles()) {
					System.out.println(file.getName());
				}
			}
			
			//exit
			else if (option == 7) {
				break;
			}
			
			else {
				System.out.println("Wrong option!");
			}
		}	
		scan.close();
	}

}
