package by.pkirvel.bookcatalog.controller.impl;

import by.pkirvel.bookcatalog.controller.Command;
import by.pkirvel.bookcatalog.presentation.UserActionViewer;
import by.pkirvel.bookcatalog.service.ServiceException;
import by.pkirvel.bookcatalog.service.ServiceProvider;
import by.pkirvel.bookcatalog.service.UserService;

public class EmailSendingCommand implements Command {

	@Override
	public String execute(String[] params) {
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
		
		String recipient = params[1].split("=")[1];
		
		boolean result;
		try {
			result = userService.emailSending(recipient);
			return UserActionViewer.emailSendingAnswer(result);
		} catch (ServiceException e) {
			return "2=Unexpected error";
		}
	}

}
