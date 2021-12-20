package by.pkirvel.bookcatalog.presentation;

public class UserActionViewer {
	
	public static String loginationAnswer(boolean result) {
		String response;
		if (result) {
			response = "1=Logination complete successfully";
		} else {
			response = "0=Logination failed";
		}
		return response;
	}
	
	public static String registrationAnswer(boolean result) {
		String response;
		if (result) {
			response = "1=Registration complete successfully";
		} else {
			response = "0=Registration failed";
		}
		return response;
	}
	
	public static String adminCheckingAnswer(boolean result) {
		String response;
		if (result) {
			response = "1=Administrator role";
		} else {
			response = "0=User role";
		}
		return response;
	}
	
	public static String userCheckingAnswer(boolean result) {
		String response;
		if (result) {
			response = "1=User exist";
		} else {
			response = "0=User absent";
		}
		return response;
	}

	public static String bookReceivingAnswer(String result) {
		String response;
		if (result == null) {
			response = "0=Book not found";
		}
		else if (result.equals("End of file")) {
			response = "0=" + result;
		}
		
		else {
			response = "1=" + result;
		}
		return response;
	}
	
	public static String bookAddingAnswer(boolean result) {
		String response;
		if (result) {
			response = "1=New Book was added successfully";
		} else {
			response = "0=Book adding failed";
		}
		return response;
	}
	
	public static String bookCheckingAnswer(boolean result) {
		String response;
		if (result) {
			response = "1=Book exist";
		} else {
			response = "0=Book absent";
		}
		return response;
	}
	
	public static String bookRemovingAnswer(boolean result) {
		String response;
		if (result) {
			response = "1=Book was removed";
		} else {
			response = "0=Book with entered title is absent";
		}
		return response;
	}
	
	public static String emailSendingAnswer(boolean result) {
		String response;
		if (result) {
			response = "1=email was sended";
		} else {
			response = "0=email sending failed";
		}
		return response;
	}
	
}
