package javaIntro_2_Algorithmization;

import java.util.Scanner;

public class DecompositionPractice5 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Укажите размер массива: ");
		int n = scan.nextInt();
		int[] arr = new int[n];
		
		System.out.print("Заполните массив: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		int maxVal = getMaxValue(arr);
		int interMax = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != maxVal) {
				interMax = arr[i];
				break;
			}
		}
		
		int j = 0;
		do {
			if (arr[j] != maxVal) {
				if (arr[j] > interMax) {
					interMax = arr[j];
				}
			}
			j++;
		} while (j < arr.length);
		
		System.out.print("Второе по величине число: " + interMax);

	}
	
	public static int getMaxValue(int[] array) {
		
		int maxValue = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}
		
		return maxValue;
	}

}
