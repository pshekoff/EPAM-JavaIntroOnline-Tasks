package by.pkirvel.bookcatalog.service.impl;

import by.pkirvel.bookcatalog.bean.Book;
import by.pkirvel.bookcatalog.dao.BookCatalogDAO;
import by.pkirvel.bookcatalog.dao.DAOException;
import by.pkirvel.bookcatalog.dao.DAOProvider;
import by.pkirvel.bookcatalog.service.BookCatalogService;
import by.pkirvel.bookcatalog.service.ServiceException;

public class BookCatalogServiceImpl implements BookCatalogService{
	
	private final DAOProvider provider = DAOProvider.getInstance();
	
	@Override
	public String bookReceiving(int index) throws ServiceException {

		BookCatalogDAO catalogDAO = provider.getBookCatalogDAO();
		String result;
		try {
			result = catalogDAO.bookReceiving(index);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public String bookReceiving(String title) throws ServiceException {

		BookCatalogDAO catalogDAO = provider.getBookCatalogDAO();
		String result;
		try {
			result = catalogDAO.bookReceiving(title);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	
	@Override
	public int getCatalogSize() throws ServiceException {
		
		BookCatalogDAO catalogDAO = provider.getBookCatalogDAO();
		int result;
		try {
			result = catalogDAO.catalogSize();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public boolean bookChecking(String title) throws ServiceException {

		BookCatalogDAO catalogDAO = provider.getBookCatalogDAO();
		boolean result;
		try {
			result = catalogDAO.checkBook(title);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;

	}
	
	@Override
	public boolean bookAdding(String title, String author, String year, String eBook) throws ServiceException {
		
		BookCatalogDAO catalogDAO = provider.getBookCatalogDAO();
		boolean result;
		try {
			result = catalogDAO.addBook(new Book(title, author, Integer.parseInt(year), Boolean.parseBoolean(eBook)));
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;

	}

	@Override
	public boolean bookRemoving(String title) throws ServiceException {
		BookCatalogDAO catalogDAO = provider.getBookCatalogDAO();
		boolean result;
		try {
			result = catalogDAO.removeBook(title);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}
	
}
