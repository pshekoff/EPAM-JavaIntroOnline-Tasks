package javaIntro_6_Tasks;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BookCatalog {
	
	private List<Book> books;
	private File catalogFile;
	
	public BookCatalog() {
		createCatalog();
	}
	
	public void createCatalog() {
		
		books = new ArrayList<>();
		
		catalogFile = new File("src/files","books.txt");
		
		if (catalogFile.exists()) {
			try {
				Scanner scan = new Scanner(new FileReader(catalogFile));
				
				while(scan.hasNextLine()) {
					
					String bookstr = scan.nextLine();
					String[] bookInfo = bookstr.split(";");
					
					Book book = new Book(bookInfo[0], bookInfo[1], Integer.parseInt(bookInfo[2]), Boolean.parseBoolean(bookInfo[3]));
					books.add(book);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void saveFile(String string) {
		
        try(FileWriter writer = new FileWriter(catalogFile, true)) {          
        	writer.write(string + "\n");
        	writer.close();
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        } 
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void removeBook(String title) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(title)) {
				books.remove(i);
			}
		}
	}
	
	public void searchBook(String title) {
		
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getTitle().equals(title)) {
				System.out.println(books.get(i).toString());
			}
		}
	}
	
	public void print() {
		
		int pageCount = (int) Math.ceil(books.size()/10.0);
		int currentPage = 1;
		
		if (pageCount == 1) {
			for (int i = 0; i < books.size(); i++) {
				books.get(i).printBook();
			}
		}
		else {
			System.out.println("Page: " + currentPage);
			for (int i = (currentPage-1)*10; i < currentPage*10; i++) {
				books.get(i).printBook();
			}
			Scanner scan = new Scanner(System.in);
			int option = 0;
			
			while (true) {	
				
				if (currentPage == 1) {
					System.out.println("1 - Next page\t2 - Exit");
					
					if (scan.hasNextInt()) {
						option = scan.nextInt();
					}
					else {
						scan.next();
					}
					
					if (option == 1) {
						currentPage++;
						System.out.println("Page: " + currentPage);
						for (int i = (currentPage-1)*10; i < currentPage*10; i++) {
							books.get(i).printBook();
						}						
					}
					else if (option == 2) {
						break;
					}
					else {
						System.out.println("Error: chosed option is incorrect!");
					}
				}
				
				else if (currentPage == pageCount) {
					System.out.println("0 - Previous page\t2 - Exit");
					
					if (scan.hasNextInt()) {
						option = scan.nextInt();
					}
					else {
						scan.next();
					}
					
					if (option == 0) {					
						currentPage--;
						System.out.println("Page: " + currentPage);
						for (int i = (currentPage-1)*10; i < currentPage*10; i++) {
							books.get(i).printBook();
						}						
					}
					else if (option == 2) {
						break;
					}
					else {
						System.out.println("Error: chosed option is incorrect!");
					}
				}
				
				else {
					System.out.println("0 - Previous page\t1 - Next page\t2 - Exit");
					
					if (scan.hasNextInt()) {
						option = scan.nextInt();
					}
					else {
						scan.next();
					}
					
					if (option == 0) {
						currentPage--;
						System.out.println("Page: " + currentPage);
						for (int i = (currentPage-1)*10; i < currentPage*10; i++) {
							books.get(i).printBook();
						}						
					}
					else if (option == 1) {
						currentPage++;
						System.out.println("Page: " + currentPage);
						if (currentPage == pageCount) {
							for (int i = (currentPage-1)*10; i < books.size(); i++) {
								books.get(i).printBook();
							}
						}
						else {
							for (int i = (currentPage-1)*10; i < currentPage*10; i++) {
								books.get(i).printBook();
							}	
						}					
					}
					else if (option == 2) {
						break;
					}
					else {
						System.out.println("Error: chosed option is incorrect!");
					}
				}
				
			}
			//scan.close();
		}
	}
	
}
