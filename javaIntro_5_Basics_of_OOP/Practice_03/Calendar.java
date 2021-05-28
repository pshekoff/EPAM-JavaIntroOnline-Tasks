package javaIntro_5_Basics_of_OOP;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Calendar {

	public ArrayList<Date> date = new ArrayList<>();
	
	public Calendar() {		
	}
	
	public class Date {
		private int day;
		private int month;
		private int year;
		private String dayType; //holiday | weekend | weekday
		
		private Date(int day, int month, int year, String dayType) {
			this.day = day;
			this.month = month;
			this.year = year;	
			this.dayType = dayType;
		}
		
		private Date(int day, int month, int year) {
			this.day = day;
			this.month = month;
			this.year = year;	
		}
		
		public String toString() {
			return String.format("%d.%d.%d",day,month,year);
		}
		
		private boolean isWeekend() {
			GregorianCalendar gc = new GregorianCalendar(year, month-1, day);
			int dayOfWeek = gc.get(GregorianCalendar.DAY_OF_WEEK);
			if ((dayOfWeek == 1)|(dayOfWeek == 7)) {
				return true;
			}
			else {
				return false;
			}
		}
		
	}

	public void addHoliday(int day, int month, int year) {
		Date d = new Date(day, month, year, "Holiday");
		date.add(d);
	}
	
	public void addDate(int day, int month, int year) {
		Date d = new Date(day, month, year);
		if (d.isWeekend()) {
			d.dayType = "Weekend";
		}
		else {
			d.dayType = "Weekday";
		}
		date.add(d);
	}	

	public void getDayType(Date date) {
		System.out.println(date.toString() + " is " + date.dayType);
	}
}
