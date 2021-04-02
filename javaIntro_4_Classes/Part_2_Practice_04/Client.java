package javaIntro_4_Classes;

import java.util.Scanner;

public class Client {
	private int id;
	private static int ID;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String adress;
	private String passportID;
	private int phoneNumber;
	
	public Client(String firstName, String lastName, String fatherName, String adress, String passportID, int phoneNumber) {
		this.id = ++ID;
		setFirstName(firstName);
		setLastName(lastName);
		setFatherName(fatherName);
		setAdress(adress);
		setPassportID(passportID);
		setPhone(phoneNumber);
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void setPassportID(String passportID) {
		this.passportID = passportID;
	}
	public void setPhone(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getID() {
		return id;
	}
	public String getFIO() {
		return ("lastName" + " " + "firstName" + " " + "fatherName");
	}
	public String getAdress() {
		return adress;
	}
	public String getPassportID() {
		return passportID;
	}
	public int getPhone() {
		return phoneNumber;
	}
	
	public static Client createClient(Scanner scan) {
		Client c = new Client("","","","","",0);
		System.out.print("LastName: ");
		c.lastName = scan.next();
		System.out.print("FirstName: ");
		c.firstName = scan.next();
		System.out.print("FatherName: ");
		c.fatherName = scan.next();
		System.out.print("Adress: ");
		c.adress = scan.next();
		System.out.print("Passport ID: ");
		c.passportID = scan.next();
		System.out.print("Phone number: ");
		c.phoneNumber = scan.nextInt();
		return c;		
	}
	
	public String toString() {
		return String.format("ID: %d;\t FIO: %s %s %s;\t Adress: %s;\t Passport ID: %s;\t Phone number: %d.",
				id, lastName, firstName, fatherName, adress, passportID, phoneNumber);
	}

}
