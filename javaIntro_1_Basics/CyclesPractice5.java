package javaIntro_1_Basics;

import java.util.Scanner;
import java.lang.Math;

public class CyclesPractice5 {
	
	// 5. ���� �������� ��� � ��������� ����� e. ����� ����� ��� ������ ����, ������ ������� ������ ��� ����� ��������� e.
	// ����� ���� ���� ����� ���: an = 1/pow(2,n) + 1/pow(3,n).

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter e: ");
		double e = scan.nextDouble();
		scan.close();
		
		double sum = 0;
		int i = 1;
		double a = 1/Math.pow(2,i) + 1/Math.pow(3,i);
		
		while (Math.abs(a) >= e) {
			sum += a;
			i++;
			a = 1/Math.pow(2,i) + 1/Math.pow(3,i);
		}
		
		System.out.println("Sum = " + sum);	

	}

}
