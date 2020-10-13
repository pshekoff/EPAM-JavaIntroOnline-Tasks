package javaIntro_1_Basics;

import java.util.Scanner;
import java.lang.Math;

public class BranchingPractice4 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter rectangular hole dimensions A*B: ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.print("Enter brick dimensions X*Y*Z: ");
		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = scan.nextInt();
		scan.close();
		
		int[][] myArray = {{x,y},{x,z},{y,z}};

		for (int i = 0; i < myArray.length; i++) {
			if ( Math.max(a,b) >= Math.max(myArray[i][0],myArray[i][1]) & Math.min(a,b) >= Math.min(myArray[i][0],myArray[i][1]) ) {
				System.out.println("The brick can pass throught the hole!");
				break;
			}
			else if (i == 2){
				System.out.println("The brick can't pass throught the hole.");
			}
		}
				
	}

}
