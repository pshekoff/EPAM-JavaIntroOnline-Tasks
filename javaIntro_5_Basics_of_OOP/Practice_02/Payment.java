package javaIntro_5_Basics_of_OOP;

import java.util.Scanner;

public class Payment {
	private int cost;
	private Product[] cart;
	private int cartSize;
	private int productCount;
	
	public class Product {
		private String productName;
		private int productCost;
		
		public Product() {			
		}
		
		public Product(String productName, int productCost) {
			this.productName = productName;
			this.productCost = productCost;
		}
		
		public Product(Scanner scan) {
			System.out.print("Product name: ");
			productName = scan.next();
			System.out.print("Product cost: ");
			productCost = scan.nextInt();
		}
		
		public String getName() {
			return productName;
		}
		public int getCost() {
			return productCost;
		}
	}
	
	public Payment() {
		cost = 0;
		cartSize = 3;
		productCount = 0;
		cart = new Product[cartSize];
	}
	
	public void addProduct(Product product) {
		if (productCount < cartSize) {
			cart[productCount] = product;
			productCount++;
			cost += product.productCost;
		}
		else {
			Product[] temp = new Product[cartSize*2];
			for (int i = 0; i < productCount; i++) {
				temp[i] = cart[i];
			}
			cart = temp;
			cartSize *= 2;
			cart[productCount] = product;
			productCount++;
			cost += product.productCost;
		}
	}
	
	public void print() {
		System.out.println("Your payment: ");
		for (int i = 0; i < productCount; i++) {
			System.out.println(cart[i].productName + "\t" + cart[i].productCost);
		}
		System.out.println("Total amount: " + cost);
	}
}
