package javaIntro_6_Task_4;

public class Ship {
	
	private int capacity;
	private int count;
	
	public Ship(int capacity, int count) {
		this.capacity = capacity;
		this.count = count;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public int getCount() {
		return count;
	}
	
	public void loadShip(int count) {
		this.count += count;
	}
	
	public void unloadShip(int count) {
		this.count -= count;
	}
	
	public boolean isLoaded() {
		if (count == capacity) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		if (count == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
