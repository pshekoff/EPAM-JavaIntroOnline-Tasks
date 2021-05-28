package javaIntro_5_Basics_of_OOP;

public class FlowerPackage implements Package {
	
	private Type type;
	private int capasity;
	private int cost;
	
	public FlowerPackage(Type type) {
		this.type = type;
		if (type.toString().equals("TAPE")) {
			capasity = 9;
			cost = 2;
		}
		else if (type.toString().equals("CELLOPHANE")) {
			capasity = 21;
			cost = 5;
		}
		else if (type.toString().equals("PAPER")) {
			capasity = 33;
			cost = 7;
		}
		else if (type.toString().equals("BASKET")) {
			capasity = 13;
			cost = 11;
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
		TAPE,
		CELLOPHANE,
		PAPER,
		BASKET
	}
}
