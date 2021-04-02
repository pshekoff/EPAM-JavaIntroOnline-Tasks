package javaIntro_4_Classes;

import java.util.ArrayList;

public class State{
	private String name;
	private double squareKm;
	private int population;
	private ArrayList<Region> regions = new ArrayList<>();
	
	public State(String name, double squareKm, int population) {
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
	public ArrayList<Region> getRegions() {
		return regions;
	}
	
	public void addRegion(Region region) {
		regions.add(region);
	}
	
	public String toString() {
		return String.format("State name: %s;\tSquare: %s km2;\tPopulation: %d.", name, squareKm, population);
	}
	
	public void printCapital() {
		for (int i = 0; i < regions.size(); i++) {
			for (int j = 0; j < regions.get(i).getDistricts().size(); j++) {
				for (int k = 0; k < regions.get(i).getDistricts().get(j).getCities().size(); k++) {
					if (regions.get(i).getDistricts().get(j).getCities().get(k).getType().equals("Capital")) {
						System.out.println(regions.get(i).getDistricts().get(j).getCities().get(k).getName());
					}
				}
			}
		}
	} 
	
	public void printRegionCenters() {
		for (int i = 0; i < regions.size(); i++) {
			for (int j = 0; j < regions.get(i).getDistricts().size(); j++) {
				for (int k = 0; k < regions.get(i).getDistricts().get(j).getCities().size(); k++) {
					if (regions.get(i).getDistricts().get(j).getCities().get(k).getType().equals("Regional center")) {
						System.out.println(regions.get(i).getDistricts().get(j).getCities().get(k).getName());
					}
				}
			}
		}
	}

}
