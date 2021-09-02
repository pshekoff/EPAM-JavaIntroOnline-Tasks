package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.util.Arrays;

public class DecompositionPractice10 {
	
	// 10. Дано натуральное число N. Написать метод (метод) дляформирования массива,
	// элементами которого являются цифры числа N.

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите натуральное число: ");
		int a = scan.nextInt();
		scan.close();
		
		byte[] arr = getDigitsArray(a);
		System.out.print("Массив из цифр введенного числа: " + Arrays.toString(arr));
	}
	
	//метод получения массива цифр из натурального числа
	public static byte[] getDigitsArray(int x) {
		byte[] digitsArray = new byte[getIntLength(x)];
		
		for (int i = digitsArray.length - 1; i >= 0; i--) {
			int d = x % 10;
			digitsArray[i] = (byte) d;
			x = x/10;
		}
		return digitsArray;
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

}


