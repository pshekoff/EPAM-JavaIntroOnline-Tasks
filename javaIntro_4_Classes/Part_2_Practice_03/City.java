package javaIntro_4_Classes;

public class City {
	private String name;
	private String type;
	private int population;
	
	public City(String name) {
		setName(name);
	}
	public City(String name, String type) {
		setName(name);
		setType(type);
	}
	public City(String name, String type, int population) {
		setName(name);
		setType(type);
		setPopulation(population);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public int getPopulation() {
		return population;
	}
	
	public String toString() {
		return String.format("City name: %s;\tCity type: %s;\tPopulation: %d.", name, type, population);
	}
	
	
}
