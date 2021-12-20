package by.pkirvel.bookcatalog.controller.impl;

import by.pkirvel.bookcatalog.controller.Command;
import by.pkirvel.bookcatalog.presentation.UserActionViewer;
import by.pkirvel.bookcatalog.service.BookCatalogService;
import by.pkirvel.bookcatalog.service.ServiceException;
import by.pkirvel.bookcatalog.service.ServiceProvider;

public class BookRemovingCommand implements Command {

	@Override
	public String execute(String[] params) {
		ServiceProvider provider = ServiceProvider.getInstance();
		BookCatalogService catalogService = provider.getBookCatalogService();
		
		Boolean result;

		String title = params[1].split("=")[1];
		try {
			result = catalogService.bookRemoving(title);
			return UserActionViewer.bookRemovingAnswer(result);
		} catch (ServiceException e) {
			return "2=Unexpected error";
		}
	}

}
