package javaIntro_1_Basics;

import java.util.Scanner;

public class BranchingPractice2 {

	public static void main(String[] args) {
		
		System.out.println("Enter 2 pairs of digits:");
		Scanner scanDigit = new Scanner(System.in);
		byte a = scanDigit.nextByte();
		byte b = scanDigit.nextByte();
		byte c = scanDigit.nextByte();
		byte d = scanDigit.nextByte();
		scanDigit.close();
		
		byte minPair1, minPair2 = 0;
		
		if (a < b) {
			minPair1 = a;
		}
		else {
			minPair1 = b;
		}
		if (c < d) {
			minPair2 = c;
		}
		else {
			minPair2 = d;
		}
		if (minPair1 > minPair2) {
			System.out.println("Max digit betwwen min in pairs is: " + minPair1);
		}
		else {
			System.out.println("Max digit betwwen min in pairs is: " + minPair2);
		}

	}

}
