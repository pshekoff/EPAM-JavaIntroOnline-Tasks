package javaIntro_4_Classes;

import java.util.Comparator;

public class Account {
	private int id;
	private static int ID;
	private int clientID;
	private double amount;
	protected int statusID;
	
	public Account(Client client) {
		this.id = ++ID;
		clientID = client.getID();
		amount = 0;
		statusID = 1;
	}
	
	public void changeAmount(double sum) {
		amount += sum;
	}
	public void changeStatus(String status) {
		if (status.equals("active")) {
			statusID = 1;
		}
		else if (status.equals("blocked")) {
			statusID = 2;
		}
		else if (status.equals("closed")) {
			statusID = 0;
		}
	}
	
	public int getID() {
		return id;
	}
	public int getClientID() {
		return clientID;
	}
	public double getAmount() {
		return amount;
	}
	public String getStatus() {
		String status = "";
		switch(statusID) {
		case (1): status = "active"; break;
		case (2): status = "blocked"; break;
		case (3): status = "closed"; break;
		}
		return status;
	}
	
	public String toString() {
		return String.format("ID: %d;\t ClientID: %d;\t Amount: %.2f;\t Status: %s.",
				id, clientID, amount, getStatus());
	}
	
	public static class Compare implements Comparator<Account> {
		public int compare(Account first, Account second) {
			if (first.clientID != second.clientID) {
				return first.clientID - second.clientID;
			}
			else if (first.statusID != second.statusID) {
				return first.statusID - second.statusID;
			}
			else {
				return ((int) first.amount) - ((int) second.amount);
			}
		}
	}

}
