package javaIntro_4_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Airline {
	private String destination;
	private int flightNumber;
	private String planeType;
	private String departureTime;
	private ArrayList<String> dayOfWeek;
	
	public Airline (String destination,int flightNumber,String planeType,String departureTime,String dayOfWeek) {
		this.destination = destination;
		this.flightNumber = flightNumber;
		this.planeType = planeType;
		this.departureTime = departureTime;
		ArrayList<String> dow = new ArrayList<String>();
		dow.addAll(Arrays.asList(dayOfWeek.split(" ")));
		this.dayOfWeek = dow;
	}
	
	public String getDestination() {
		return destination;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public String getPlaneType() {
		return planeType;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public ArrayList<String> getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDestination(String dest) {
		destination = dest;
	}
	public void setFlightNumber(int fn) {
		flightNumber = fn;
	}
	public void setPlaneType(String pt) {
		planeType = pt;
	}
	public void setDepartureTime(String dt) {
		departureTime = dt;
	}
	public void setDayOfWeek(String dow) {
		dayOfWeek.add(dow);
	}
	
	public String toString() {
		return String.format("Destination: %s;\tFlight number: %d;\tPlane type: %s;\tDeparture time: %s;\tDay of week: %s.",
				destination,flightNumber,planeType,departureTime,dayOfWeek);
	}
	
	public static Airline addLine(Scanner scan) {
		Airline a = new Airline("",0,"","","");
		System.out.print("Destination: ");
		a.destination = scan.next();
		System.out.print("Flight number: ");
		a.flightNumber = scan.nextInt();
		System.out.print("Plane type: ");
		a.planeType = scan.next();
		System.out.print("Departure time HH:MI: ");
		a.departureTime = scan.next();		
		System.out.print("Flights count per week: ");
		int c = scan.nextInt();
		System.out.print("Days of week: ");
		a.dayOfWeek.set(0, scan.next());
		for (int i = 1; i < c; i++) {
			a.dayOfWeek.add(scan.next());
		}
		return a;		
	}
}
