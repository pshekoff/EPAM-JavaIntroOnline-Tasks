package javaIntro_2_Algorithmization;

import java.util.Scanner;

public class DecompositionPractice8 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("������� ������ �������: ");
		int n = scan.nextInt();
		int[] arr = new int[n];
		
		System.out.print("��������� ������: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		
		System.out.println("� ������ �������� ������� ��������� ����� 3-� ���������������� ���������?");
		
		int k = scan.nextInt() - 1;
		scan.close();
		
		System.out.println("����� ����� " + getSum(arr, k));
		
	}

	public static int getSum (int[] array, int k) {
		int sum = 0;
		int m = k + 2;
		for (int i = k; i <= m; i++) {
			sum += array[i];
		}
		return sum;
	}
}
