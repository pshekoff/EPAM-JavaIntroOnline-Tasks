package javaIntro_1_Basics;

import java.util.Scanner;

public class LinearProgPractice1 {

// Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.	
	
	public static void main (String[] args) {
		
		System.out.print("Enter constants a,b,c: ");
		Scanner scanConst = new Scanner(System.in);
		double a = scanConst.nextDouble();
		double b = scanConst.nextDouble();
		double c = scanConst.nextDouble();
		scanConst.close();
		
		double z = ((a - 3) * b / 2) + c;
		
		System.out.println("Fuction z value is: " + z);
		
	}

}
