package javaIntro_2_Algorithmization;

import java.util.Arrays;

public class SortingPractice04 {
	
	/* 4. Сортировка обменами (пузырьковая). Дана последовательность чисел a1 >= a2 >= ... >= an.
	 * Требуется переставить числа в порядке возрастания. Для этого сравнивается два соседних числа
	 * a[i] и a[i+1]. Если a[i] > a[i+1], то делается перестановка. Так продолжается до тех пор,
	 * пока все элементы не станут расположены в порядке возрастания. Составить алгоритм сортировки,
	 * подсчитывая при этом количество перестановок.
	 */

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		
		//заполняем массив случайными числами от 0 до 9
		arr[arr.length-1] = (int) (Math.random()*10);
		for (int i = arr.length-2 ; i >= 0; i--) {
			arr[i] = arr[i+1] + (int) (Math.random()*10);
		}
		
		System.out.println("Исходный массив:\n" + Arrays.toString(arr));
		
		int swapCount = 0;
		
		//сортировка обменами
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

		System.out.println("Сортировка обменами по возрастанию:\n" + Arrays.toString(arr));
		System.out.println("Количество перестановок = " + swapCount);
		
	}

}
