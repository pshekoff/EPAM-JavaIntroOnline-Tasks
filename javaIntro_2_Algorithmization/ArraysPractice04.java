package javaIntro_2_Algorithmization;

import java.lang.Math;

public class ArraysPractice04 {
	
	// 4. Даны действительные числа a1, a2,...,an. Поменять местами наибольший и наименьший элементы.

	public static void main(String[] args) {
		
		double[] myArr = new double[10];
		
		int min = 1;
		int max = 10;
		
		System.out.print("Array is\t| ");
		
		//random array generation with values from min to max
		for (int j = 0; j < myArr.length; j++) {
			double c = Math.floor((Math.random() * (max - min) + min)*10);
			myArr[j] = c/10;
			System.out.print(myArr[j] + " | ");
		}
		
		double minVal = myArr[0];
		double maxVal = myArr[0];
		int i = 0;
		
		//min value finding
		for (int j = i + 1; j < myArr.length; j++) {
			if (myArr[j] < myArr[i]) {
				i = j;
				minVal = myArr[j];
			}
		}
		i = 0;
		
		//max value finding
		for (int j = i + 1; j < myArr.length; j++) {
			if (myArr[j] > myArr[i]) {
				i = j;
				maxVal = myArr[i];
			}
		}
		
		//man and max values replacing
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
		
		System.out.print("\nmin value " + minVal + " and max value " + maxVal + " were replaced.");
	}

}
