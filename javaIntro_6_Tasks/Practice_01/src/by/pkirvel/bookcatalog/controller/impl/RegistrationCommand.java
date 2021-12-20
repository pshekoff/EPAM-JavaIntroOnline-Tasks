package by.pkirvel.bookcatalog.controller.impl;

import by.pkirvel.bookcatalog.controller.Command;
import by.pkirvel.bookcatalog.presentation.UserActionViewer;
import by.pkirvel.bookcatalog.service.ServiceException;
import by.pkirvel.bookcatalog.service.ServiceProvider;
import by.pkirvel.bookcatalog.service.UserService;

public class RegistrationCommand implements Command{

	@Override
	public String execute(String[] params) {
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
		
		String login = params[1].split("=")[1];
		String password = params[2].split("=")[1];
		String email = params[3].split("=")[1];
		String admin = params[4].split("=")[1];
		
		boolean result;
		try {
			result = userService.registration(login, password, email, admin);
			return UserActionViewer.registrationAnswer(result);
		} catch (ServiceException e) {
			return "2=Unexpected error";
		}
		
	}

}
