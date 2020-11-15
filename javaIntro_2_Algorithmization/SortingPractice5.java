package javaIntro_2_Algorithmization;

import java.util.Arrays;

public class SortingPractice5 {

	public static void main(String[] args) {

		int[] arr = new int[10];
		
		double ran = Math.random()*10;
		arr[arr.length-1] = (int) ran;
		
		for (int i = arr.length-2; i >= 0; i--) {
			ran = Math.random()*10;
			arr[i] = arr[i+1] + (int)ran;
		}
		
		System.out.println("»сходный массив: " + Arrays.toString(arr));
		
		for (int i = 0; i < arr.length; i++) {
			int index = getIndex(arr, 0, i-1, arr[i]);
			int value = arr[i];
			for(int j = i-1; j >= index; j--) {
				arr[j+1] = arr[j];
			}
			arr[index] = value;
		}
		
		System.out.println("—ортировка вставками по возрастанию: " + Arrays.toString(arr));

	}
	
	public static int getIndex(int[] array, int start, int end, int keyValue) {
		
		int index = 0;
		
		while (start <= end) {
			int middle = (start + end)/2;
			if (array[middle] < keyValue) {
				start = middle + 1;
			}
			else if (array[middle] > keyValue) {
				end = middle - 1;
			}
			else if (array[middle] == keyValue) {
				index = middle;
				break;
			}
		}
		
		return index;
	}

}


