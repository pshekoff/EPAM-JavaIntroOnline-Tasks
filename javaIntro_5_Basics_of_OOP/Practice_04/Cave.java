package javaIntro_5_Basics_of_OOP;

import java.util.ArrayList;

public class Cave {
	private String owner;
	private int treasuresCount;
	private ArrayList<Treasure> treasures = new ArrayList<>();
	
	public Cave(String owner) {
		this.owner = owner;
		treasuresCount = 0;
	}
	
	public String getOwner() {
		return owner;
	}
	public int getTreasuresCount() {
		return treasuresCount;
	}
	public ArrayList<Treasure> getTreasures() {
		return treasures;
	} 
	
	public void addTreasure(Treasure treasure) {
		treasures.add(treasure);
		treasuresCount++;
	}

    public void showTreasures() {
    	treasures.forEach((n) -> System.out.println(n.toString()));
    }
    
    public void printGreatestTreasure() {
    	int cost = 0;
    	for (int i = 0; i < treasures.size(); i++) {
    		if (treasures.get(i).getCost() > cost) {
    			cost = treasures.get(i).getCost();
    		}
    	}
    	
    	for (int i = 0; i < treasures.size(); i++) {
    		if (treasures.get(i).getCost() == cost) {
    			System.out.println(treasures.get(i).toString());
    		}
    	}
    }
    
    public void printTreasuresByCost(int cost) {

    	for (int i = 0; i < treasures.size(); i++) {
    		if (treasures.get(i).getCost() <= cost) {
    			System.out.println(treasures.get(i).toString());
    		}
    	}
    }
    

}
