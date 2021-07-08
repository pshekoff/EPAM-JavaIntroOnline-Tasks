package javaIntro_6_Tasks;

public class User {
	
	private final String login;
	private int passwordHash;
	private String email;
	private boolean isAdmin;
	
	public User(String login, int passwordHash, String email, boolean isAdmin) {
		this.login = login;
		setPassword(passwordHash);
		setRole(isAdmin);
		setEmail(email);
	}
	
	public void setPassword(int passwordHash) {
		this.passwordHash = passwordHash;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	
	@Override
	public String toString() {
		return String.format("%s;%d;%s;%s",
							 login, passwordHash, email, isAdmin);
	}
	
}
