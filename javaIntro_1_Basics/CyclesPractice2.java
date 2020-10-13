package javaIntro_1_Basics;

import java.util.Scanner;

public class CyclesPractice2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter diapazon [a,b]: ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.print("Enter step h: ");
		int h = scan.nextInt();
		scan.close();
		
		int x,y = 0;
		for (x = a; x <= b; x += h) {
			if (x <= 2) {
				y = -x;
				System.out.println("x=" + x + " y=" + y);
			}
			else {
				y = x;
				System.out.println("x=" + x + " y=" + y);
			}
		}

	}

}
