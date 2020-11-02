package javaIntro_2_Algorithmization;

import java.lang.Math;

public class ArraysPractice4 {

	public static void main(String[] args) {
		
		double[] myArr = new double[10]; //{4.5, 8.3, 3.7, 9.1, 3.6, 5.8, 2.2, 7.6, 2.5, 6.1};
		
		int a = 0;
		int b = 10;
		
		System.out.print("Array is\t| ");
		
		for (int j = 0; j < myArr.length; j++) {
			double c = Math.floor((Math.random() * (b - a) + a)*10);
			myArr[j] = c/10;
			System.out.print(myArr[j] + " | ");
		}
		
		double minVal = 0;
		double maxVal = 0;
		int i = 0;
		
		for (int j = i + 1; j < myArr.length; j++) {
			if (myArr[j] < myArr[i]) {
				i = j;
				minVal = myArr[j];
			}
		}
		i = 0;
		
		for (int j = i + 1; j < myArr.length; j++) {
			if (myArr[j] > myArr[i]) {
				i = j;
				maxVal = myArr[i];
			}
		}
		
		for (int j = 0; j < myArr.length; j++) {
			if (myArr[j] == minVal) {
				myArr[j] = maxVal;
			}
			else if (myArr[j] == maxVal) {
				myArr[j] = minVal;
			}
		}
	
		System.out.print("\nNew array is    | ");
		
		for (int j = 0; j < myArr.length; j++) {
			System.out.print(myArr[j] + " | ");
		}
		
		System.out.print("\n" + minVal + " and " + maxVal + " were replaced.");
	}

}
