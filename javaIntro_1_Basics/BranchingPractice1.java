package javaIntro_1_Basics;

import java.util.Scanner;

public class BranchingPractice1 {

	public static void main(String[] args) {
		
		System.out.println("Enter two angles in degrees: ");
		Scanner scanAngle = new Scanner(System.in);
		int angleA = scanAngle.nextInt();
		int angleB = scanAngle.nextInt();
		int angleC = 180 - angleA - angleB;
		scanAngle.close();	
		
		if ((angleA + angleB > 0)&(angleA + angleB < 180)) {
			System.out.print("Triangle is true, third angle is: " + angleC);
			
			if ((angleA == 90)|(angleB == 90)|(angleC == 90)) {
				System.out.println(" and this triangle is right.");
			}
			else {
				System.out.println(", but this is not right triangle.");
			}
		}
		
		else {
			System.out.println("Triangle does not exist!");
		}

	}

}
