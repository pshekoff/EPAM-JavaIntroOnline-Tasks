package by.pkirvel.bookcatalog.controller;

import java.util.HashMap;
import java.util.Map;

import by.pkirvel.bookcatalog.controller.impl.*;

public class CommandProvider {
	private Map<CommandType, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		
		commands.put(CommandType.LOGINATION, new LoginationCommand());
		commands.put(CommandType.REGISTRATION, new RegistrationCommand());
		commands.put(CommandType.ADMINCHECKING, new AdminCheckingCommand());
		commands.put(CommandType.USERCHECKING, new UserCheckingCommand());
		commands.put(CommandType.BOOKCHECKING, new BookCheckingCommand());
		commands.put(CommandType.BOOKRECEIVING, new BookReceivingCommand());
		commands.put(CommandType.BOOKADDING, new BookAddingCommand());
		commands.put(CommandType.BOOKREMOVING, new BookRemovingCommand());
		commands.put(CommandType.CATALOGDATA, new CatalogDataCommand());
		commands.put(CommandType.EMAILSENDING, new EmailSendingCommand());

	}
	
	public Command getCommand(String commandType) {
		Command command = commands.get(CommandType.valueOf(commandType));
		return command;
	}

}
