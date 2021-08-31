package javaIntro_1_Basics;

import java.util.Scanner;
import java.lang.Math;

public class BranchingPractice5 {
	
	// 5. Вычислить значение функции F(x):
	// pow(x,2) - 3x + 9, если x <= 3;
	// 1/(pow(x,3) + 6), если x > 3;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter x: ");
		int x = scan.nextInt();
		scan.close();
			
		double y = 0;
			
		if (x <= 3) {
			y = Math.pow(x, 2) - 3*x + 9;
		}
		else {
			y = 1 / (Math.pow(x, 3) + 6);
		}
			
		System.out.print("f(x) = " + y);

	}

}
