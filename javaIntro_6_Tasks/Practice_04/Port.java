package javaIntro_6_Task_4;

import java.util.List;
import java.util.ArrayList;

public class Port {
	
	private int pierCount;
	private List<Ship> fleet;
	private int shipQueue;
	private static final int maxQueue = 10;
	
	public Port(int pierCount) {
		this.pierCount = pierCount;
		fleet = new ArrayList<>();
		shipQueue = 0;
	}
	
	public int getshipCount() {
		return shipQueue;
	}
	public int getPierCount() {
		return pierCount;
	}
	
	public synchronized boolean newShip(Ship ship) {
		
		try {
			if (shipQueue < maxQueue) {
				notifyAll();
				fleet.add(ship);
				System.out.println("New ship with capacity " + ship.getCapacity() + ", loaded on " + ship.getCount() + " arrived to the port. Thread: " + Thread.currentThread().getName());
				shipQueue++;
			}
			else {
				System.out.println("There is no free pier.");
				wait();
				return false;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return true;
	}
	
	public synchronized Ship getShip() {
		
		try {
			if (shipQueue > 0) {
				notifyAll();
				for (Ship ship : fleet) {
					shipQueue--;
					System.out.println("The ship leaved the queue and docked to the free pier. Thread: " + Thread.currentThread().getName());
					fleet.remove(ship);
					return ship;
				}
			}
			else {
				System.out.println("There is no ships in the queue.");
				wait();
			}

		}  catch (InterruptedException e) {
			e.printStackTrace();
		}	
		return null;
	}
	
}
