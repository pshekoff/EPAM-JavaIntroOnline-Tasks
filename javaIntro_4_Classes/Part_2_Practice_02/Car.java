package javaIntro_4_Classes;

public class Car {
	private String manufacturer;
	private String model;
	private String color;
	private int year;
	private double tankVolume;
	private double fuelAmount;
	private double fuelConsumption;
	private Engine engine;
	private Wheel wheel;
	
	public Car(String manufacturer, String model, String color, int year, double tankVolume, double fuelConsumption, Engine engine, Wheel wheel) {
		setManufacturer(manufacturer);
		setModel(model);
		setColor(color);
		setYear(year);
		setTankVolume(tankVolume);
		fuelAmount = tankVolume;
		setFuelConsumption(fuelConsumption);
		setEngine(engine);
		setWheel(wheel);
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setTankVolume(double tankVolume) {
		this.tankVolume = tankVolume;
	}
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	public String getModel() {
		return model;
	}
	public String getColor() {
		return color;
	}
	public int getYear() {
		return year;
	}
	public double getTankVolume() {
		return tankVolume;
	}
	public double getFuelAmount() {
		return fuelAmount;
	}
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	public Engine getEngine() {
		return engine;
	}
	public Wheel getWheel() {
		return wheel;
	}
	
	public String toString() {
		return String.format("Manufacturer: %s\tModel: %s\tColor: %s\tYear: %d\tEngine: %s\tWheel: %d.",
				manufacturer,model,color,year,engine.getModel(), wheel.getDiameter());
	}
	
	public void go(int distance) {
		double fuelAmount = distance*fuelConsumption/100;
		if (fuelAmount > this.fuelAmount) {
			System.out.print("There is not enough fuel in the tank for " + distance + " kilometers!");
			if (fuelAmount > fuelConsumption) {
				System.out.println(" The maximum distance range of this car is " + (100*tankVolume/fuelConsumption) + " km.");
			}
			else {
				System.out.println(" You need to refuel.");
			}
		}
		else {
			this.fuelAmount -= fuelAmount;
			System.out.println("You just drove " + distance + " km. " + this.fuelAmount + " liters left in the tank.");
		}
	}
	
	public void refuel(String fuelType, double fuelAmount) {
		if (!fuelType.equals(engine.getFuelType())) {
			System.out.println("The fuel type is not suitable with your engine!");
		}
		else {
			if (fuelAmount > (tankVolume - this.fuelAmount)) {
				System.out.println("The specified amount of fuel will not fit into the tank! You can refuel up to "
									+ (tankVolume - this.fuelAmount) + " liters.");
				
			}
			else {
				this.fuelAmount += fuelAmount;
				System.out.println("Car just refueled. Fuel amount is " + this.fuelAmount);
			}
		}
	}
	
	public void wheelReplace(int diameter) {
		wheel.setDiameter(diameter);
		System.out.println("The wheels have been replaced to " + wheel.getDiameter() + " diameter.");
	}
}
