package by.pkirvel.bookcatalog.dao;

public class DAOException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4254800414001867249L;

	public DAOException() {
		super();
	}
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(Exception e) {
		super(e);
	}
	
	public DAOException(String message, Exception e) {
		super(message, e);
	}
}
