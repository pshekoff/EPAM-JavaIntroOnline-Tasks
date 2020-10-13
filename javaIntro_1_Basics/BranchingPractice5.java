package javaIntro_1_Basics;

import java.util.Scanner;
import java.lang.Math;

public class BranchingPractice5 {

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
