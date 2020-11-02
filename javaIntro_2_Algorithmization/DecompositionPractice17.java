package javaIntro_2_Algorithmization;

import java.util.Scanner;

public class DecompositionPractice17 {

	public static void main(String[] args) {
		
		System.out.print("Введите натуральное число: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();

		int k = getActCount(n);
		System.out.print("Чтобы получить 0, каждый раз вычитая сумму цифр полученной разности, нужно произвести " + k + " действий.");
		
	}

	public static int getActCount(int n) {
		int count = 0;
		while (n != 0) {
			n -= getDigitsSum(n);
			count++;
		}
		return count;
	}
	
	public static int getDigitsSum(int n) {
		int sum = 0;
		while (n != 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}
}
