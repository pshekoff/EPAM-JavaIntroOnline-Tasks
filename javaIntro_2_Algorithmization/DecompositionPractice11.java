package javaIntro_2_Algorithmization;

import java.util.Scanner;

public class DecompositionPractice11 {
	
	// 11. Написать метод (методы), определяющий, в каком из данных двух чисел больше цифр.

	public static void main(String[] args) {

		System.out.print("Введите 2 числа: ");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		scan.close();
		IntMaxLength(x,y);
	}
	
	//метод нахождения количества цифр числа
	public static byte getIntLength(int x) {
		byte digitsCount = 0;
		while (x != 0) {
			digitsCount++;
			x = x/10;
		}
		return digitsCount;
	}
	
	//метод сравнения двух чисел по количеству цифр
	public static void IntMaxLength(int a, int b) {
		int aLen = getIntLength(a);
		int bLen = getIntLength(b);
		if (aLen > bLen) {
			System.out.print("В числе " + a + " больше цифр.");
		}
		else if (bLen > aLen) {
			System.out.print("В числе " + b + " больше цифр.");
		}
		else {
			System.out.print("Числа имеют одинаковое количество цифр.");
		}
	}
}
