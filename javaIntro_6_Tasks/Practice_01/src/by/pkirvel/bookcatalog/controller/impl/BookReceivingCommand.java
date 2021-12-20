package by.pkirvel.bookcatalog.controller.impl;

import by.pkirvel.bookcatalog.controller.Command;
import by.pkirvel.bookcatalog.presentation.UserActionViewer;
import by.pkirvel.bookcatalog.service.BookCatalogService;
import by.pkirvel.bookcatalog.service.ServiceException;
import by.pkirvel.bookcatalog.service.ServiceProvider;

public class BookReceivingCommand implements Command {

	@Override
	public String execute(String[] params) {
		ServiceProvider provider = ServiceProvider.getInstance();
		BookCatalogService catalogService = provider.getBookCatalogService();
		
		String result;

		if (params[1].split("=")[0].equals("title")) {
			String title = params[1].split("=")[1];
			try {
				result = catalogService.bookReceiving(title);
				return UserActionViewer.bookReceivingAnswer(result);
			} catch (ServiceException e) {
				return "2=Unexpected error";
			}
		}
		else if (params[1].split("=")[0].equals("index")) {
			int index = Integer.parseInt(params[1].split("=")[1]);
			try {
				result = catalogService.bookReceiving(index);
				return UserActionViewer.bookReceivingAnswer(result);
			} catch (ServiceException e) {
				return "2=Unexpected error";
			}
		}
		else {
			return "2=Unexpected error";
		}
		
	}

}
