package by.pkirvel.bookcatalog.service;

import by.pkirvel.bookcatalog.service.impl.BookCatalogServiceImpl;
import by.pkirvel.bookcatalog.service.impl.UserServiceImpl;

public final class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();
	
	private ServiceProvider() {};
	
	public static ServiceProvider getInstance() {
		return instance;
	}
	
	private final UserService userService = new UserServiceImpl();
	private final BookCatalogService catalogService = new BookCatalogServiceImpl();

	public UserService getUserService() {
		return userService;
	}
	public BookCatalogService getBookCatalogService() {
		return catalogService;
	}
	
}
