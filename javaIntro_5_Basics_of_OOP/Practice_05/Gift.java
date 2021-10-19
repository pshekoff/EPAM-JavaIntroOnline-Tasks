package javaIntro_5_Basics_of_OOP;

import java.util.ArrayList;

public class Gift {
	
	private Package pack;
	private ArrayList<Item> items = new ArrayList<>();
	
	public Gift(Package pack, ArrayList<Item> items) {
		this.pack = pack;
		this.items = items;
	}
	public Gift() {
	}
	
	public Package getPackage() {
		return pack;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void setPackage(Package pack) {
		this.pack = pack;
	}
	
	//добавление предмета
	public void addItem(Item item) {
		int count = 0;
		for (int i = 0; i < items.size(); i++) {
			count += items.get(i).getCount();
		}
		if ((count + item.getCount()) > pack.getCapasity()) {
			System.out.println("Error: maximum package capasity is reached. Item " + item.toString() + " wasn't added to the gift.");
		}
		else {
			items.add(item);
		}
	}
	
	//вывод содержимого
	public void output() {
		System.out.println("The gift consist of " + pack.toString());
		for (int i = 0; i < items.size(); i++) {
			System.out.println("and " + items.get(i).toString());
		}
		System.out.println("Total gift cost = " + getGiftCost());
	}
	
	public int getGiftCost() {
		int cost = pack.getCost();
		for (int i = 0; i < items.size(); i++) {
			cost += items.get(i).getCost() * items.get(i).getCount();
		}
		return cost;
	}
}
