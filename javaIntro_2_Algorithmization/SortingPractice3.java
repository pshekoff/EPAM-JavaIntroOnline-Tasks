package javaIntro_2_Algorithmization;

import java.util.Arrays;

public class SortingPractice3 {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		
		double ran = Math.random()*10;
		arr[0] = (int) ran;
		
		for (int i = 1; i < 10; i++) {
			ran = Math.random()*10;
			arr[i] = arr[i-1] + (int)ran;
		}
		
		System.out.println("Исходный массив: " + Arrays.toString(arr));
		
		for (int i = 0; i < arr.length; i++) {
			int maxIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] > arr[maxIndex]) {
					maxIndex = j;
				}
			}
			
			int replace = arr[i];
			arr[i] = arr[maxIndex];
			arr[maxIndex] = replace;

		}
		
		System.out.println("Сортировка выбором по убыванию: " + Arrays.toString(arr));

	}

}
