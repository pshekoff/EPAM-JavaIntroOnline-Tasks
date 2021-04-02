package javaIntro_4_Classes;

import java.util.Comparator;

public class Tour {
	private String type;
	private String transport;
	private boolean food;
	private int duration;
	private int cost;
	
	public Tour(String type, String transport, boolean food, int duration, int cost) {
		this.type = type;
		this.transport = transport;
		this.food = food;
		this.duration = duration;
		this.cost = cost;
	}
	
	public String getType() {
		return type;
	}
	public String getTransport() {
		return transport;
	}
	public boolean getFood() {
		return food;
	}
	public int getDuration() {
		return duration;
	}
	public int getCost() {
		return cost;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public void setFood(boolean food) {
		this.food = food;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String toString() {
		return String.format("Type: %s;\t transport: %s;\t food: %s;\t duration: %d; \t cost: %d.",
				type, transport, food, duration, cost);
	}
	
	public static class CompareByCost implements Comparator<Tour> {
		public int compare(Tour first, Tour second) {
			return (first.cost - second.cost);
		}
	}
	
}
