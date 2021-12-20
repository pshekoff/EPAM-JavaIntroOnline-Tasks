package by.pkirvel.bookcatalog.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import by.pkirvel.bookcatalog.bean.User;
import by.pkirvel.bookcatalog.dao.DAOException;
import by.pkirvel.bookcatalog.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	
	@Override
	public boolean authorization(String login, String password) throws DAOException {
		boolean result = false;
		
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader("C:\\BookCatalog\\users.txt"));
			
			try {
				String usrStr;
				while ((usrStr = bufferReader.readLine()) != null) {
					String[] usrData = usrStr.split(";");

					if ( usrData[0].equals(login) && Integer.parseInt(usrData[1]) == password.hashCode() ) {
						result = true;
						break;
					}
				}
				bufferReader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} 
		return result;
	}

	@Override
	public boolean registration(User newUser) throws DAOException {
		boolean result = false;
		
		try {
			FileWriter writer = new FileWriter("C:\\BookCatalog\\users.txt", true);
			writer.write(newUser.toString() + "\n");
	    	writer.close();
	    	result = true;
		} catch (IOException e){
			throw new DAOException(e);
		}

		return result;
	}

	@Override
	public boolean adminChecking(String login) throws DAOException {
		boolean result = false;
		
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader("C:\\BookCatalog\\users.txt"));
			
			try {
				String usrStr;
				while ((usrStr = bufferReader.readLine()) != null) {
					String[] usrData = usrStr.split(";");
					
					if ( usrData[0].equals(login) && Boolean.parseBoolean(usrData[3]) ) {
						result = true;
						break;
					}
				}
				bufferReader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} 
		return result;
	}

	@Override
	public boolean userChecking(String login) throws DAOException {
		boolean result = false;
		
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader("C:\\BookCatalog\\users.txt"));
			
			try {
				String usrStr;
				while ((usrStr = bufferReader.readLine()) != null) {
					String[] usrData = usrStr.split(";");

					if (usrData[0].equals(login)) {
						result = true;
						break;
					}
				}
				bufferReader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} 
		return result;
	}

	@Override
	public boolean send2Email(String recipient) throws DAOException {
		boolean result = false;
		
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader("C:\\BookCatalog\\users.txt"));
			
			try {
				String usrStr;
				while ((usrStr = bufferReader.readLine()) != null) {
					String[] usrData = usrStr.split(";");
					
					if (recipient.equals("users")) {
						//send to usrData[2]
						result = true;
					}
					else if (recipient.equals("admins") && Boolean.parseBoolean(usrData[3])) {
						//send to usrData[2]
						result = true;
					}
				}
				bufferReader.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} 
		return result;
	}



}
