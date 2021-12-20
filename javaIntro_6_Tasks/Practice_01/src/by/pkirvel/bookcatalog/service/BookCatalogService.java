package by.pkirvel.bookcatalog.service;

public interface BookCatalogService {
	String bookReceiving(int index) throws ServiceException;
	String bookReceiving(String title) throws ServiceException;
	int getCatalogSize() throws ServiceException;
	boolean bookChecking(String title) throws ServiceException;
	boolean bookAdding(String title, String author, String year, String eBook) throws ServiceException;
	boolean bookRemoving(String title) throws ServiceException;
}
