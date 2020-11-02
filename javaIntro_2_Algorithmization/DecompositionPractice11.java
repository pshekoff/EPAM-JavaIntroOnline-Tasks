package javaIntro_2_Algorithmization;

import java.util.Scanner;

public class DecompositionPractice11 {

	public static void main(String[] args) {

		System.out.print("������� 2 �����: ");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		scan.close();
		IntMaxLength(x,y);
	}
	
	public static byte getIntLength(int x) {
		
		byte digitsCount = 0;
		while (x != 0) {
			digitsCount++;
			x = x/10;
		}
		return digitsCount;
	}
	
	public static void IntMaxLength(int a, int b) {
		int aLen = getIntLength(a);
		int bLen = getIntLength(b);
		if (aLen > bLen) {
			System.out.print("� ����� " + a + " ������ ����.");
		}
		else if (bLen > aLen) {
			System.out.print("� ����� " + b + " ������ ����.");
		}
		else {
			System.out.print("����� ����� ���������� ���������� ����.");
		}
	}
}
