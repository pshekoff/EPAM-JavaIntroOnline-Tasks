package javaIntro_2_Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

public class DecompositionPractice08 {
	
	// 8. Задан массив D. Определить следующие суммы: D[1]+D[2]+D[3]; D[3]+D[4]+D[5]; D[4]+D[5]+D[6].
	// Пояснение: Составить метод (методы) для вычисления суммы трех последовательно расположенных
	// элементов массива с номерами от k до m.

	public static void main(String[] args) {

		int[] arr = new int[10];
		//заполняем массив случайными числами от 0 до 99
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random()*100);
		}
		System.out.println(Arrays.toString(arr));
		
		Scanner scan = new Scanner(System.in);
		System.out.println("С какого элемента массива посчитать сумму 3-х последовательных элементов?"
				+ "\nВведите число от 1 до " + (arr.length-2));
		int k = scan.nextInt() - 1;
		scan.close();
		
		System.out.println("Сумма равна " + getSum(arr, k));
	}
	
	//метод нахождения суммы 3-х последовательных элементов массива
	public static int getSum (int[] array, int k) {
		int sum = 0;
		int m = k + 2;
		for (int i = k; i <= m; i++) {
			sum += array[i];
		}
		return sum;
	}
}
