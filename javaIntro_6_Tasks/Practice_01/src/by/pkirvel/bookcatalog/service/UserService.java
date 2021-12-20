package by.pkirvel.bookcatalog.service;

public interface UserService {
	boolean logination(String login, String password) throws ServiceException;
	boolean registration(String login, String password, String email, String admin) throws ServiceException;
	boolean userChecking(String login) throws ServiceException;
	boolean adminChecking(String login) throws ServiceException;
	boolean emailSending(String recipient) throws ServiceException;
}
