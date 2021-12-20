package by.pkirvel.bookcatalog.controller;

public class BookCatalogController implements Controller {
	private CommandProvider provider = new CommandProvider();
	
	@Override
	public String doAction(String request) {
		
		String[] params = request.split(";");
		String commandName = params[0];
		
		Command currentCommand = provider.getCommand(commandName); 
		
		String response = currentCommand.execute(params);
		
		return response;

	}

}
