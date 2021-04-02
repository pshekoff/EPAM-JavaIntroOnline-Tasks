package javaIntro_4_Classes;

import java.util.ArrayList;
import java.util.Collections;

public class Accounts {
	private ArrayList<Account> accounts = new ArrayList<>();
	
	public Accounts() {
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public void output() {
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println(accounts.get(i).toString());
		}
	}
	public void output(int clientID) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getClientID() == clientID) {
				System.out.println(accounts.get(i).toString());
			}		
		}
	}
	
	public double getTotalAmount(int clientID, int flag) {
		double sum = 0;
		double sumTotal = 0;
		double sumPositive = 0;
		double sumNegative = 0;		
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getClientID() == clientID) {
				sumTotal += accounts.get(i).getAmount();
				if (accounts.get(i).getAmount() < 0) {
					sumNegative += accounts.get(i).getAmount();
				}
				else {
					sumPositive += accounts.get(i).getAmount();
				}				
			}
		}
		//System.out.println("Total = " + sumTotal + " sumPositive = " + sumPositive + " + sumNegative = " + sumNegative);
		if (flag == -1) {
			sum = sumNegative;
		}
		else if (flag == 0) {
			sum = sumTotal;
		}
		else if (flag == 1) {
			sum = sumPositive;
		}
		//switch(flag) {
	//	case (-1): sum = sumNegative;
	//	case (0): sum = sumTotal;
	//	case(1): sum = sumPositive;
	//	}
		return sum;
	}
	
	public void Sort() {
		Collections.sort(accounts, new Account.Compare());
	}
}
