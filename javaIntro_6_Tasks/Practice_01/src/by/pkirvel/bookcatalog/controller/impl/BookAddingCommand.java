package by.pkirvel.bookcatalog.controller.impl;

import by.pkirvel.bookcatalog.controller.Command;
import by.pkirvel.bookcatalog.presentation.UserActionViewer;
import by.pkirvel.bookcatalog.service.BookCatalogService;
import by.pkirvel.bookcatalog.service.ServiceException;
import by.pkirvel.bookcatalog.service.ServiceProvider;

public class BookAddingCommand implements Command{

	@Override
	public String execute(String[] params) {
		ServiceProvider provider = ServiceProvider.getInstance();
		BookCatalogService catalogService = provider.getBookCatalogService();

		String title = params[1].split("=")[1];
		String author = params[2].split("=")[1];
		String year = params[3].split("=")[1];
		String eBook = params[4].split("=")[1];
		
		boolean result;
		try {
			result = catalogService.bookAdding(title, author, year, eBook);
			return UserActionViewer.bookAddingAnswer(result);
		} catch (ServiceException e) {
			return "2=Unexpected error";
		}
	}

}
