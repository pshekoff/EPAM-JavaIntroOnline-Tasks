package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.lang.Math;

public class ArraysPractice3 {

	public static void main(String[] args) {
		
		System.out.print("Enter array length: ");
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		int a = -10;
		int b = 10;
		
		double[] myArr = new double[n];
		
		System.out.print("Array is | ");
		
		for (int i = 0; i < myArr.length; i++) {
			double d = Math.round((Math.random() * (b - a) + a)*10);
			myArr[i] = d/10;
			System.out.print(myArr[i] + " | ");
		}
		
		System.out.println();
		
		int negativeCount = 0;
		int positiveCount = 0;
		int zeroCount = 0;
		
		for (int i = 0; i < myArr.length; i++) {
			if (myArr[i] < 0) {
				negativeCount++;
			}
			else if (myArr[i] > 0) {
				positiveCount++;
			}
			else {
				zeroCount++;
			}
		}
		
		System.out.println("Negative values count is: " + negativeCount);
		System.out.println("Positive values count is: " + positiveCount);
		System.out.println("Zero values count is: " + zeroCount);
	}
}
