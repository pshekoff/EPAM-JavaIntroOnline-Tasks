package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.util.Arrays;

public class DecompositionPractice12 {

	public static void main(String[] args) {
		
		System.out.print("Введите k (сумма цифр) и n (максимальное значение): ");
		
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		int n = scan.nextInt();
		scan.close();
		
		System.out.print("Массив из чисел не больше " + n + " и с суммой цифр = " + k + ": " + Arrays.toString(getArray(k,n)));
	}

	public static int[] getArray(int digitSum, int maxVal) {
		
		int n = 0;
		
		for (int i = 1; i <= maxVal; i++) {
			if (getDigitSum(i) == digitSum) {
				n++;
			}
		}
		
		int[] array = new int[n];
		n = 0;
		
		for (int i = 1; i <= maxVal; i++) {
			if (getDigitSum(i) == digitSum) {
				array[n] = i;
				n++;
			}
		}
		return array;
	}
	
	public static int getDigitSum(int a) {
		
		int sum = 0;
		int len = getIntLength(a);
		
		for (int i = 0; i < len; i++) {
			sum = sum + a%10;
			a = a/10;
		}
		return sum;
	}
	
	public static int getIntLength(int x) {

		int digitsCount = 0;
		
		while (x != 0) {
			digitsCount++;
			x = x/10;
		}
		return digitsCount;
	}
}
