package javaIntro_2_Algorithmization;

import java.util.Arrays;
import java.lang.Math;

public class SortingPractice06 {
	
	/* 6. Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
	 * Делается это следующим образом: сравниваются два соседних элемента a[i] и a[i+1]. Если a[i] <= a[i+1],
	 * то продвигаются на один элемент вперед. Если a[i] > a[i+1], то производится перестановка и сдвигаются
	 * на один элемент назад. Составить алгоритм этот сортировки.
	 */

	public static void main(String[] args) {
		
		double[] arr = new double[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Math.round(Math.random()*10000);
			arr[i] /= 100;
		}
		
		System.out.println("Исходный массив:\n" + Arrays.toString(arr));
		
		int i = 0;
		while (i < arr.length-1) {
			if (arr[i] <= arr[i+1]) {
				i++;
			}
			else if (arr[i] > arr[i+1]) {
				double replace = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = replace;
				if (i != 0) {
					i--;
				}
			}
		}		
		System.out.println("Сортировка по возрастанию:\n" + Arrays.toString(arr));	
	}

}
