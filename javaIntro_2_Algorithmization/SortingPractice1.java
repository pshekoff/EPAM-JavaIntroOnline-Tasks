package javaIntro_2_Algorithmization;

import java.util.Scanner;

public class SortingPractice1 {

	public static void main(String[] args) {

		System.out.print("Введите размерность массива А: ");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		System.out.print("Введите размерность массива B: ");
		int b = scan.nextInt();
		
		int[] arrA = new int[a];
		int[] arrB = new int[b];
		int[] arrC = new int[a+b];
		
		System.out.print("Заполните массив А, введите " + a + " чисел: ");
		for (int i = 0; i < a; i++) {
			arrA[i] = scan.nextInt();
		}
		
		System.out.print("Заполните массив B, введите " + b + " чисел: ");
		for (int i = 0; i < b; i++) {
			arrB[i] = scan.nextInt();
		}
		
		System.out.print("Введите порядковый номер элемента массива А от 1 до " + a + ": ");
		int k = scan.nextInt();
		
		scan.close();
		
		System.out.println("Массис B вставлен в массив А между " + k + "-м и " + (k+1) + "-м элементом:");
		
		for (int i = 0; i < k; i++) {
			arrC[i] = arrA[i];
			System.out.print(arrC[i] + " ");
		}
		
		for (int i = k; i < k + b; i++) {
			arrC[i] = arrB[i-k];
			System.out.print(arrC[i] + " ");
		}
		
		for (int i = k+b; i < arrC.length; i++) {
			arrC[i] = arrA[i-b];
			System.out.print(arrC[i] + " ");
		}
	}

}
