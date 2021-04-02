package javaIntro_4_Classes;

public class Engine {
	private String model;
	private String fuelType;
	private double volume;
	private int power;
	
	public Engine(String model, String fuelType, double volume, int power) {
		setModel(model);
		setFuelType(fuelType);
		setVolume(volume);
		setPower(power);
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	public String getModel() {
		return model;
	}
	public String getFuelType() {
		return fuelType;
	}
	public double getVolume() {
		return volume;
	}
	public int getPower() {
		return power;
	}
	
	public String toString() {
		return String.format("Model: %s\tFuel type: %s\tVolume = %d\tPower = %d.", model, fuelType, volume, power);
	}
}
