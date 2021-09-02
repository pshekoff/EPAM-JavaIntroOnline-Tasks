package javaIntro_2_Algorithmization;

import java.util.Scanner;

public class SortingPractice01 {
	
	// 1. Заданы два одномерных массива с различным количеством элементов и натуральное число k.
	// Объединить их в один масси, включив второй массив между k-м и (k+1)-м элементами первого массива,
	// при этом не используя дополнительный массив.

	public static void main(String[] args) {

		System.out.print("Введите размерность массива А: ");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		System.out.print("Введите размерность массива B: ");
		int b = scan.nextInt();
		
		int[] arrA = new int[a+b];
		int[] arrB = new int[b];
		
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
		
		int j = b-1;
		for (int i = arrA.length-1; i >= 0; i--) {
			if (i >= (k+b)) {
				arrA[i] = arrA[i-arrB.length];
			}
			if ((i >= k)&(i < (k+b))) {
				arrA[i] = arrB[j];
				j--;
			}
		}
		
		for (int i = 0; i < arrA.length; i++) {
			System.out.print(arrA[i] + " ");
		}
	}

}
