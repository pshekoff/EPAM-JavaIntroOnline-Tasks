package javaIntro_5_Basics_of_OOP;

public class Flower implements Item {
	
	private Name name;
	private int cost;
	private int count;
	
	public Flower(Name name, int count) {
		this.name = name;
		this.count = count;
		if (name.toString().equals("ROSE")) {
			cost = 16;
		}
		else if (name.toString().equals("LILY")) {
			cost = 20;
		}
		else if (name.toString().equals("TULIP")) {
			cost = 8;
		}
		else if (name.toString().equals("ORCHID")) {
			cost = 12;
		}
		else if (name.toString().equals("GLADIOLUS")) {
			cost = 7;
		}
		else if (name.toString().equals("ASTER")) {
			cost = 9;
		}
		else if (name.toString().equals("CHRYSANTHEMUMS")) {
			cost = 4;
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
		return String.format("Flower %s, costs = %d, count = %d", name, cost, count);
	}
	
	//список используемых цветов
	public enum Name {		
		ROSE,
		LILY,
		TULIP,
		ORCHID,
		GLADIOLUS,
		ASTER,
		CHRYSANTHEMUMS
	}
		
}
