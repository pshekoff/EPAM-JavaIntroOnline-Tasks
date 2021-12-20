package by.pkirvel.bookcatalog.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import by.pkirvel.bookcatalog.bean.Book;
import by.pkirvel.bookcatalog.dao.BookCatalogDAO;
import by.pkirvel.bookcatalog.dao.DAOException;

public class BookCatalogDAOImpl implements BookCatalogDAO {

	@Override
	public String bookReceiving(int index) throws DAOException {
		String bookStr;
		int i = 0;
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader("C:\\BookCatalog\\books.txt"));
			
			try {
				while ((bookStr = bufferReader.readLine()) != null) {
					i++;
					if (i == index) {
						break;
					}
				}
				bufferReader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} 

		if (bookStr == null) {
			bookStr =  "End of file";
		}
		return bookStr;
	}

	@Override
	public String bookReceiving(String title) throws DAOException {
		String bookStr;

		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader("C:\\BookCatalog\\books.txt"));
			
			try {
				while ((bookStr = bufferReader.readLine()) != null) {
					String[] bookData = bookStr.split(";");
					if (bookData[0].equals(title)) {
						break;
					}
				}
				bufferReader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} 
		
		return bookStr;
	}
	
	@Override
	public int catalogSize() throws DAOException {
		int size = 0;
		
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader("C:\\BookCatalog\\books.txt"));
			
			try {
				while ((bufferReader.readLine()) != null) {
					size++;
				}
				bufferReader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} 
		
		return size;
	}

	@Override
	public boolean checkBook(String title) throws DAOException {

		boolean result = false;
		
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader("C:\\BookCatalog\\books.txt"));
			
			try {
				String bookStr;
				while ((bookStr = bufferReader.readLine()) != null) {
					String[] bookData = bookStr.split(";");
					if (bookData[0].equals(title)) {
						result = true;
					}
				}
				bufferReader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} 
		return result;
	}
	
	@Override
	public boolean addBook(Book book) throws DAOException {
		boolean result = false;
		
		try {
			FileWriter writer = new FileWriter("C:\\BookCatalog\\books.txt", true);
			writer.write(book + "\n");
	    	writer.close();
	    	result = true;
		} catch (IOException e){
			throw new DAOException(e);
		}

		return result;
	}

	@Override
	public boolean removeBook(String title) throws DAOException {
		File catalog = new File("C:\\BookCatalog\\books.txt");
		ArrayList<Book> books = new ArrayList<>();
		
		boolean result = false;
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader("C:\\BookCatalog\\books.txt"));
			
			try {
				String bookStr;
				while ((bookStr = bufferReader.readLine()) != null) {
					String[] bookData = bookStr.split(";");
					
					if (bookData[0].equals(title)) {
						result = true;
						continue;
					}
					books.add(new Book(bookData[0],bookData[1],Integer.parseInt(bookData[2]),Boolean.parseBoolean(bookData[3])));
				}
				bufferReader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			} 
			
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} 
		
		if (result) {
			if(catalog.delete()){
				
				try {
					catalog.createNewFile();
					
					FileWriter writer = new FileWriter(catalog, true);
					
					for (Book b : books) {
						writer.write(b.toString() + "\n");
					}
			        writer.close();
			        
				} catch (IOException e) {
					throw new DAOException(e);
				}

			}
		}
		
		return result;
	}

}
