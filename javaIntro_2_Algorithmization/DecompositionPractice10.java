package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.util.Arrays;

public class DecompositionPractice10 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите натуральное число: ");
		int a = scan.nextInt();
		scan.close();
		
		byte[] arr = getDigitsArray(a);
		System.out.print("Массив из цифр введенного числа: " + Arrays.toString(arr));
	}

	public static byte[] getDigitsArray(int x) {
		
		byte[] digitsArray = new byte[getIntLength(x)];
		
		for (int i = digitsArray.length - 1; i >= 0; i--) {
			int d = x % 10;
			digitsArray[i] = (byte) d;
			x = x/10;
		}
		return digitsArray;
	}
	
	public static byte getIntLength(int x) {
		
		byte digitsCount = 0;
		while (x != 0) {
			digitsCount++;
			x = x/10;
		}
		return digitsCount;
	}

}


