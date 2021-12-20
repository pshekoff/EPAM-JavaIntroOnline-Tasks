package by.pkirvel.bookcatalog.service.impl;

import by.pkirvel.bookcatalog.bean.User;
import by.pkirvel.bookcatalog.dao.DAOException;
import by.pkirvel.bookcatalog.dao.DAOProvider;
import by.pkirvel.bookcatalog.dao.UserDAO;
import by.pkirvel.bookcatalog.service.ServiceException;
import by.pkirvel.bookcatalog.service.UserService;

public class UserServiceImpl implements UserService{
	
	private final DAOProvider provider = DAOProvider.getInstance();
			
	@Override
	public boolean logination(String login, String password) throws ServiceException {
		// validation
		
		UserDAO userDAO = provider.getUserDAO();
		boolean result;
		try {
			result = userDAO.authorization(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public boolean registration(String login, String password, String email, String admin) throws ServiceException {

		UserDAO userDAO = provider.getUserDAO();
		boolean result;
		try {
			result = userDAO.registration(new User(login, password.hashCode(), email, Boolean.parseBoolean(admin)));
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public boolean adminChecking(String login) throws ServiceException {

		UserDAO userDAO = provider.getUserDAO();
		boolean result;
		try {
			result = userDAO.adminChecking(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public boolean userChecking(String login) throws ServiceException {

		UserDAO userDAO = provider.getUserDAO();
		boolean result;
		try {
			result = userDAO.userChecking(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public boolean emailSending(String recipient) throws ServiceException {
		
		UserDAO userDAO = provider.getUserDAO();
		boolean result;
		try {
			result = userDAO.send2Email(recipient);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}



}
