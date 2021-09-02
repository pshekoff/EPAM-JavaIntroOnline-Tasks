package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class DecompositionPractice14 {
	
	// 14. Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
	// возведения в степень n, равна самому числу. Найти все числа Армстронга от 1 до k.
	// Для решения задачи использовать декомпозицию.

	public static void main(String[] args) {
		
		System.out.print("Введите k (максимальное значение): ");
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		scan.close();
		
		System.out.print("Числа Армстронга на отрезке [1," + k + "]: " + Arrays.toString(getArmstrongArray(k)));
	}

	//получение чисел Армстронга
	public static int[] getArmstrongArray(int maxVal) {
		int n = 0;
		
		for (int i = 1; i <= maxVal; i++) {
			if (Math.pow(getDigitSum(i),getIntLength(i)) == i) {
				n++;
			}
		}
		
		int[] array = new int[n];
		n = 0;
		
		for (int i = 1; i <= maxVal; i++) {
			if (Math.pow(getDigitSum(i),getIntLength(i)) == i) {
				array[n] = i;
				n++;
			}
		}
		return array;
	}
	
	//получение суммы цифр числа
	public static int getDigitSum(int a) {
		int sum = 0;
		int len = getIntLength(a);
		
		for (int i = 0; i < len; i++) {
			sum = sum + a%10;
			a = a/10;
		}
		return sum;
	}
	
	//получение количества цифр числа
	public static int getIntLength(int x) {
		int digitsCount = 0;
		
		while (x != 0) {
			digitsCount++;
			x = x/10;
		}
		return digitsCount;
	}

}
