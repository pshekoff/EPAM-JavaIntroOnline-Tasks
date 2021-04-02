package javaIntro_4_Classes;

import java.util.*;

public class Customer {
	
	private int id;
	private static int ID;
	private String lastName;
	private String firstName;
	private String fatherName;
	private String adress;
	private int creditCardNumber;
	private String IBAN;
	
	public Customer(String lastName, String firstName, String fatherName, String adress, int creditCardNumber, String IBAN) {
		this.id = ID++;
		this.lastName = lastName;
		this.firstName = firstName;
		this.fatherName = fatherName;
		this.adress = adress;
		this.creditCardNumber = creditCardNumber;
		this.IBAN = IBAN;
	}

	public int getID() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public String getFIO() {
		return (lastName + " " + firstName + " " + fatherName);
	}
	public String getAdress() {
		return adress;
	}
	public int getCard() {
		return creditCardNumber;
	}
	public String getIBAN() {
		return IBAN;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void setCardNumber(int cardNumber) {
		creditCardNumber = cardNumber;
	}
	public void setIBAN(String iban) {
		IBAN = iban;
	}
	
	public String toString() {
		return String.format("ID: %d;\t FIO: %s %s %s;\t Adress: %s;\t Card number: %d;\t IBAN: %s.",
				id, lastName, firstName, fatherName, adress, creditCardNumber, IBAN);
	}
	
	public static Customer createCustomer(Scanner scan) {
		Customer c = new Customer("","","","",0,"");
		System.out.print("LastName: ");
		c.lastName = scan.next();
		System.out.print("FirstName: ");
		c.firstName = scan.next();
		System.out.print("FatherName: ");
		c.fatherName = scan.next();
		System.out.print("Adress: ");
		c.adress = scan.next();
		System.out.print("Card number: ");
		c.creditCardNumber = scan.nextInt();
		System.out.print("IBAN: ");
		c.IBAN = scan.next();
		return c;		
	}
	
	public static class CompareByName implements Comparator<Customer> {
		public int compare(Customer first, Customer second) {
			if (first.lastName != second.lastName) {
				return first.lastName.compareTo(second.lastName);
			}
			else if (first.firstName != second.firstName) {
				return first.firstName.compareTo(second.firstName);
			}
			else {
				return first.fatherName.compareTo(second.fatherName);
			}
		}
	}

}


