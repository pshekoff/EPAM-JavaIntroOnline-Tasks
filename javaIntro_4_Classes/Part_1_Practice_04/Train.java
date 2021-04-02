package javaIntro_4_Classes;

import java.util.Comparator;

public class Train{
	private String destination;
	private int trainNumber;
	private String departureTime;
	
	public Train(String destination, int trainNumber, String departureTime) {
		this.destination = destination;
		this.trainNumber = trainNumber;
		this.departureTime = departureTime;
	}
	
	public String getDestination() {
		return destination;
	}
	public int getNumber() {
		return trainNumber;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDestination(String dest) {
		destination = dest;
	}
	public void setTrainNumber(int tn) {
		trainNumber = tn;
	}
	public void setDepartureTime(String dt) {
		departureTime = dt;
	}
	
	public static Comparator<Train> sortByTrainNumber = new Comparator<Train>() {
		public int compare(Train t1, Train t2) {
			return t1.trainNumber - t2.trainNumber;
		}
	};
	
	public static Comparator<Train> sortByDestination = new Comparator<Train>() {
		public int compare(Train t1, Train t2) {
			if (t1.destination.equals(t2.destination)) {
				return t1.departureTime.compareTo(t2.departureTime);
			}
			else {
				return t1.destination.compareTo(t2.destination);
			}
		}
	};
	
	public void output() {
		System.out.println(trainNumber + "\t" + departureTime + "\t" + destination);
	}
	
}

