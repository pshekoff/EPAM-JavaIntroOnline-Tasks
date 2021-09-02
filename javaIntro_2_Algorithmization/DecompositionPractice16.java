package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.lang.Math;

public class DecompositionPractice16 {
	
	// 16. Написать программу, определяющую сумму n-значных чисел, содержащих только нечетные цифры.
	// Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.

	public static void main(String[] args) {

		System.out.print("Введите n (рязрядность числа): ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		int s = getIntSum(n);
		System.out.print("Сумма " + n + "-разрядных чисел с нечетными цифрами = " + s + "\nВ найденной сумме " + getEvenCount(s) + " четных цифр(ы).");

	}
	
	//получение суммы чисел с только нечетными цифрами
	public static int getIntSum(int n) {
		int sum = 0;
		int start = 0;
		int end = 0;
		for (int r = 0; r < n; r++) {
			start += Math.pow(10, r);
			end += 9*Math.pow(10, r);
		}
		
		for (int i = start; i <= end; i += 2) {
			if (isAllOdd(i) == true) {
				sum += i;
			}
		}
		return sum;
	}
	
	//проверка, являеются ли все цифры числа нечетными
	public static boolean isAllOdd(int a) {
		boolean isOdd = true;
		int len = getLength(a);
		for (int i = 1; i <= len; i++) {
			if ((a%10)%2 == 0) {
				isOdd = false;
				break;
			}
			a = a/10;
		}
		return isOdd;
	}
	
	//подсчет четных цифр в числе
	public static int getEvenCount(int a) {
		int count = 0;
		int len = getLength(a);
		for (int i = 1; i <= len; i++) {
			if((a%10)%2 == 0) {
				count++;
			}
			a = a/10;
		}
		return count;
	}
	
	//получение количества цифр числа
	public static int getLength(int x) {
		int digitsCount = 0;
		
		while (x != 0) {
			digitsCount++;
			x = x/10;
		}
		return digitsCount;
	}
	
}
