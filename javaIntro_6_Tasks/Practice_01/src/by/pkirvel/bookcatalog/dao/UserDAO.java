package by.pkirvel.bookcatalog.dao;

import by.pkirvel.bookcatalog.bean.User;

public interface UserDAO {
	boolean authorization(String login, String password) throws DAOException;
	boolean registration(User newUser) throws DAOException;
	boolean userChecking(String login) throws DAOException;
	boolean adminChecking(String login) throws DAOException;
	boolean send2Email(String recipient) throws DAOException;
}
