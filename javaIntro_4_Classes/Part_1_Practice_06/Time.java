package javaIntro_4_Classes;

public class Time {
	
	private int hour;
	private int minute;
	private int second;

	public Time(int h, int m, int s) {
		setHour(h);
		setMinute(m);
		setSecond(s);
	}
	
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	public String getTime() {
		return (hour + ":" + minute + ":" + second);
	}
	public int getTimeInSeconds() {
		return (hour*3600 + minute*60 + second);
	}
	
	public void setHour(int h) {
		if ((h >= 0)&(h <= 23)) {
			this.hour = h;
		}
		else {
			this.hour = 0;
		}
	}
	public void setMinute(int m) {
		if ((m >= 0)&(m <= 59)) {
			this.minute = m;
		}
		else {
			this.minute = 0;
		}
	}
	public void setSecond(int s) {
		if ((s >= 0)&(s <= 59)) {
			this.second = s;
		}
		else {
			this.second = 0;
		}
	}
	
	public void print() {
		System.out.println(hour + ":" + minute + ":" + second);
	}
	
	public void increase(int hours, int minutes, int seconds) {

		second += seconds;
		if (second >= 60) {
			minute += second/60;
			second %= 60; 
		}
		minute += minutes;
		if (minute >= 60) {
			hour +=minute/60;
			minute %= 60;
		}
		hour += hours;
		if (hour >= 24) {
			hour %= 24;
		}
	}
}
