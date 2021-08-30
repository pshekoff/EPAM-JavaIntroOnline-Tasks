package javaIntro_6_Task_3;

public class User {
	
	private final String login;
	private int passwordHash;
	private boolean isAdmin;
	
	public User(String login, int passwordHash, boolean isAdmin) {
		this.login = login;
		setPassword(passwordHash);
		setRole(isAdmin);
	}
	
	public void setPassword(int passwordHash) {
		this.passwordHash = passwordHash;
	}
	public void setRole(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getLogin() {
		return login;
	}
	public int getPasswordHash() {
		return passwordHash;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	
	@Override
	public String toString() {
		return String.format("%s;%d;%s",
							 login, passwordHash, isAdmin);
	}
	
}
