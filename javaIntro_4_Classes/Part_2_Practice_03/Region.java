package javaIntro_4_Classes;

import java.util.ArrayList;

public class Region{
	private String name;
	private double squareKm;
	private int population;
	private ArrayList<District> districts = new ArrayList<>();
	
	public Region(String name, double squareKm, int population) {
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
	public ArrayList<District> getDistricts() {
		return districts;
	}
	
	public void addDistrict(District district) {
		districts.add(district);
	}
	
	public String toString() {
		return String.format("Region name: %s;\tSquare: %s km2;\tPopulation: %d.", name, squareKm, population);
	}
}
