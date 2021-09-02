package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.lang.Math;

public class ArraysPractice03 {
	
	// 3. Дан массив действительных чисел, размерность когорого N.
	// Подсчитать сколько в нем отрицательных, положительных и нулевых элементов.

	public static void main(String[] args) {
		
		System.out.print("Enter array length: ");
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		int min = -10;
		int max = 10;
		
		double[] myArr = new double[n];
		
		System.out.print("Array is | ");
		
		//random array generation with values from min to max
		for (int i = 0; i < myArr.length; i++) {
			double d = Math.round((Math.random() * (max - min) + min)*10);
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
