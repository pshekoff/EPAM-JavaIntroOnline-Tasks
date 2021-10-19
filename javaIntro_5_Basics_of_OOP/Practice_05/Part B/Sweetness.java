package javaIntro_5_Basics_of_OOP;

public class Sweetness implements Item{
	private Name name;
	private int cost;
	private int count;
	
	public Sweetness(Name name, int count) {
		this.name = name;
		this.count = count;
		if (name.toString().equals("CANDY")) {
			cost = 3;
		}
		else if (name.toString().equals("CHOCOLATE")) {
			cost = 5;
		}
		else if (name.toString().equals("LOLLIPOP")) {
			cost = 2;
		}
		else if (name.toString().equals("CAKE")) {
			cost = 7;
		}
	}
	
	public String getName() {
		return name.toString();
	}
	public int getCost() {
		return cost;
	}
	public int getCount() {
		return count;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return String.format("Sweetness %s, costs = %d, count = %d", name, cost, count);
	}
	
	//список используемых сладостей
	public enum Name {		
		CANDY,
		CHOCOLATE,
		LOLLIPOP,
		CAKE
	}
}
