package javaIntro_2_Algorithmization;

import java.util.Arrays;

public class SortingPractice4 {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		
		double ran = Math.random()*10;
		arr[arr.length-1] = (int) ran;
		
		for (int i = arr.length-2 ; i >= 0; i--) {
			ran = Math.random()*10;
			arr[i] = arr[i+1] + (int)ran;
		}
		
		System.out.println("Исходный массив: " + Arrays.toString(arr));
		
		int swapCount = 0;
		boolean needSwap = true;
		while (needSwap) {
			needSwap = false;
			for(int i = 1; i < arr.length; i++) {
				if (arr[i] < arr[i-1]) {
					int replace = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = replace;
					needSwap = true;
					swapCount++;
				}
			}
		}

		System.out.println("Сортировка обменами по возрастанию: " + Arrays.toString(arr));
		System.out.println("Количество перестановок = " + swapCount);
		
	}

}
