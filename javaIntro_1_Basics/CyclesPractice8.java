package javaIntro_1_Basics;

import java.util.Scanner;

public class CyclesPractice8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter 2 numbers (a,b): ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.close();
		
		System.out.print("a digits is: -");
		
		for (int i = 0; i < getDigitsArray(a).length; i++) {
			System.out.print(getDigitsArray(a)[i] + "-");
		}
		
		System.out.println();
		System.out.print("b digits is: -");
		
		for (int i = 0; i < getDigitsArray(b).length; i++) {
			System.out.print(getDigitsArray(b)[i] + "-");
		} 
		
	}
	
	public static byte getIntLength(int x) {
		
		byte digitsCount = 0;
		while (x != 0) {
			digitsCount++;
			x = x/10;
		}
		
		return digitsCount;
	}
	
	public static byte[] getDigitsArray(int x) {
		
		byte[] digitsArray = new byte[getIntLength(x)];
		
		for (int i = digitsArray.length - 1; i >= 0; i--) {
			int d = x % 10;
			digitsArray[i] = (byte) d;
			x = x /10;
		}
		
		return digitsArray;
	}

}
