package javaIntro_4_Classes;

import java.util.Arrays;

public class Customers {
	private Customer[] customers;
	private int customersCount;
	private int arraySize;
	
	public Customers(int size) {
		arraySize = size;
		customers = new Customer[arraySize];
		customersCount = 0;
	}
	public Customers() {
		arraySize = 5;
		customers = new Customer[arraySize];
		customersCount = 0; 
	}

	public void add(Customer c) {
		if (customersCount < arraySize) {
			customers[customersCount] = c;
			customersCount++;
		}
		else {
			Customer[] temp = new Customer[arraySize*2];
			for (int i = 0; i < arraySize; i++) {
				temp[i] = customers[i];
			}
			customers = temp;
			arraySize *= 2;
			customers[customersCount] = c;
			customersCount++;
		}
	}
	
	public void output() {
		for (int i = 0; i < customersCount; i++) {
			System.out.println(customers[i].toString());
		}
	}

	public void sortByName() {
		Arrays.sort(customers, 0, customersCount, new Customer.CompareByName());
	}
	
	public void getCustomersByCardDiapazon(int fromNumber, int toNumber) {
		for (int i = 0; i < customersCount; i++) {
			if ((customers[i].getCard() >= fromNumber)&(customers[i].getCard() <= toNumber)) {
				System.out.println(customers[i].toString());
			}
		}
	}
}

