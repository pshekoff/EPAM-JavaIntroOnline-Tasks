package javaIntro_4_Classes;

import java.util.ArrayList;

public class District {
	private String name;
	private double squareKm;
	private int population;
	private ArrayList<City> cities = new ArrayList<>();
	
	public District(String name, double squareKm, int population) {
		setName(name);
		setSquare(squareKm);
		setPopulation(population);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSquare(double squareKm) {
		this.squareKm = squareKm;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public double getSquare() {
		return squareKm;
	}
	public int getPopulation() {
		return population;
	}
	public ArrayList<City> getCities() {
		return cities;
	}
	
	public void addCity(String cityName) {
		City c = new City(cityName);
		cities.add(c);
	}
	public void addCity(String cityName, String type) {
		cities.add(new City(cityName, type));
	}
	public void addCity(String cityName, String type, int citizens) {
		cities.add(new City(cityName, type, citizens));
	}
	public void addCity(City city) {
		cities.add(city);
	}
	
	public String toString() {
		return String.format("District name: %s;\tSquare: %s km2;\tPopulation: %d.", name, squareKm, population);
	}
}
