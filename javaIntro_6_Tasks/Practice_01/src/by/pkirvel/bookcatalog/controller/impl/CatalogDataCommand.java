package by.pkirvel.bookcatalog.controller.impl;

import by.pkirvel.bookcatalog.controller.Command;
import by.pkirvel.bookcatalog.service.BookCatalogService;
import by.pkirvel.bookcatalog.service.ServiceException;
import by.pkirvel.bookcatalog.service.ServiceProvider;

public class CatalogDataCommand implements Command{

	@Override
	public String execute(String[] params) {
		ServiceProvider provider = ServiceProvider.getInstance();
		BookCatalogService catalogService = provider.getBookCatalogService();

		try {
			String result = "" + catalogService.getCatalogSize();
			return result ;
		} catch (ServiceException e) {
			return "2=Unexpected error";
		}
	}

}
