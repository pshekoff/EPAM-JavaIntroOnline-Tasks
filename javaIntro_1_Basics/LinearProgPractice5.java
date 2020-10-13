package javaIntro_1_Basics;

import java.lang.Math;

public class LinearProgPractice5 {

	public static void main(String[] args) {
		
		int a = 0;
		int b = 24*3600;
		final int time = (int) (Math.random() * (b - a + 1) + a);
		
		System.out.println("Time in seconds = " + time); 
		
		int timeSeconds = time;
		int timeHours = (int) Math.floor(timeSeconds/3600);
		timeSeconds= timeSeconds - timeHours*3600;
		int timeMinutes = (int) Math.floor(timeSeconds/60);
		timeSeconds = timeSeconds - timeMinutes*60;
		
		System.out.println("Time is: " + timeHours + "ч " + timeMinutes + "мин " + timeSeconds + "с");

	}

}
