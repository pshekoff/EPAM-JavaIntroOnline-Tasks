package javaIntro_2_Algorithmization;

import java.util.Scanner;

public class SortingPractice1 {

	public static void main(String[] args) {

		System.out.print("������� ����������� ������� �: ");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		System.out.print("������� ����������� ������� B: ");
		int b = scan.nextInt();
		
		int[] arrA = new int[a];
		int[] arrB = new int[b];
		int[] arrC = new int[a+b];
		
		System.out.print("��������� ������ �, ������� " + a + " �����: ");
		for (int i = 0; i < a; i++) {
			arrA[i] = scan.nextInt();
		}
		
		System.out.print("��������� ������ B, ������� " + b + " �����: ");
		for (int i = 0; i < b; i++) {
			arrB[i] = scan.nextInt();
		}
		
		System.out.print("������� ���������� ����� �������� ������� � �� 1 �� " + a + ": ");
		int k = scan.nextInt();
		
		scan.close();
		
		System.out.println("������ B �������� � ������ � ����� " + k + "-� � " + (k+1) + "-� ���������:");
		
		for (int i = 0; i < k; i++) {
			arrC[i] = arrA[i];
			System.out.print(arrC[i] + " ");
		}
		
		for (int i = k; i < k + b; i++) {
			arrC[i] = arrB[i-k];
			System.out.print(arrC[i] + " ");
		}
		
		for (int i = k+b; i < arrC.length; i++) {
			arrC[i] = arrA[i-b];
			System.out.print(arrC[i] + " ");
		}
	}

}
