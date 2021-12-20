package by.pkirvel.bookcatalog.dao;

import by.pkirvel.bookcatalog.dao.impl.BookCatalogDAOImpl;
import by.pkirvel.bookcatalog.dao.impl.UserDAOImpl;

public final class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();
	
	private UserDAO userDAO = new UserDAOImpl();
	private BookCatalogDAO bookCatalogDAO = new BookCatalogDAOImpl();
	
	private DAOProvider() {};
	
	public static DAOProvider getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public BookCatalogDAO getBookCatalogDAO() {
		return bookCatalogDAO;
	}

	public void setBookCatalogDAO(BookCatalogDAO bookCatalogDAO) {
		this.bookCatalogDAO = bookCatalogDAO;
	}
	
	
}
