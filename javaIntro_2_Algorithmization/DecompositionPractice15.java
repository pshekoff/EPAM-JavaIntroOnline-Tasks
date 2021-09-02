package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class DecompositionPractice15 {
	
	// 15. Найти все натуральные n-рязрядные числа, цифры которых обзазуют строго возрастающую последовательность.
	// (например: 1234, 5678). Для решения задачи использовать декомпозицию.

	public static void main(String[] args) {
		
		System.out.print("Введите n от 1 до 10 (рязрядность числа): ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		System.out.print("Все натуральные " + n + "-разрядные числа с возрастающими цифрами:\n" + Arrays.toString(getDigitsIncreaseValuesArray(n)));

	}
	
	public static int[] getDigitsIncreaseValuesArray(int bit) {
		int[] array = new int[10-bit];
		
		for (int i = 0; i < 10-bit; i++) {
			for (int j = 1; j <= bit; j++) {
				array[i] += (int) ((i+j)*Math.pow(10, bit-j));
			}
		}
		return array;
	}

}
