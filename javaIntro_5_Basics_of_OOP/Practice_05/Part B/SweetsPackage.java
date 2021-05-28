package javaIntro_5_Basics_of_OOP;

public class SweetsPackage implements Package {
	private Type type;
	private int capasity;
	private int cost;
	
	public SweetsPackage(Type type) {
		this.type = type;
		if (type.toString().equals("CELLOPHANE")) {
			capasity = 10;
			cost = 2;
		}
		else if (type.toString().equals("PAPER")) {
			capasity = 15;
			cost = 3;
		}
		else if (type.toString().equals("BASKET")) {
			capasity = 25;
			cost = 10;
		}
		else if (type.toString().equals("BOX")) {
			capasity = 40;
			cost = 7;
		}
	}
	
	public String getType() {
		return type.toString();
	}
	public int getCapasity() {
		return capasity;
	}
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return String.format("%s package, capasity = %d, costs = %d", type, capasity, cost);
	}
	
	public enum Type {
		CELLOPHANE,
		PAPER,
		BASKET,
		BOX,
	}
}
