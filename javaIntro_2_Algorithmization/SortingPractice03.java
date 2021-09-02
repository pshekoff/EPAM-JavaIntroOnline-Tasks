package javaIntro_2_Algorithmization;

import java.util.Arrays;

public class SortingPractice03 {
	
	/* 3. Сортировка выбором. Дана последовательность чисел a1 <= a2 <= ... <= an.
	 * Требуется переставить элементы так, чтобы они были расположены по убыванию.
	 * Для этого в массиве, начиная с первого, выбирается наибольший элемент и
	 * ставится на первое место, а первый - на место наибольшего. Затем, начиная
	 * со второго, эта процедура повторяется. Написать алгоритм сортировки выбором.
	 */

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		
		//заполняем массив случайными числами от 0 до 9
		arr[0] = (int) (Math.random()*10);
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i-1] + (int) (Math.random()*10);
		}
		
		System.out.println("Исходный массив:\n" + Arrays.toString(arr));
		
		//сортировка выбором
		for (int i = 0; i < arr.length; i++) {
			int maxIndex = i;
			//ищем наибольший элемент
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] > arr[maxIndex]) {
					maxIndex = j;
				}
			}
			//ставим наибольший элемент на текущее место i
			int replace = arr[i];
			arr[i] = arr[maxIndex];
			arr[maxIndex] = replace;
		}
		System.out.println("Сортировка выбором по убыванию:\n" + Arrays.toString(arr));
	}

}
