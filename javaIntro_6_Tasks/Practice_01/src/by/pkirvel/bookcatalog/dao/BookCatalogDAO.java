package by.pkirvel.bookcatalog.dao;

import by.pkirvel.bookcatalog.bean.Book;

public interface BookCatalogDAO {
	String bookReceiving(int index) throws DAOException;
	String bookReceiving(String title) throws DAOException;
	int catalogSize() throws DAOException;
	boolean checkBook(String title) throws DAOException;
	boolean addBook(Book book) throws DAOException;
	boolean removeBook(String title) throws DAOException;
}
