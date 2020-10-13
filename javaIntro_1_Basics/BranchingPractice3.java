package javaIntro_1_Basics;

import java.util.Scanner;

public class BranchingPractice3 {

	public static void main(String[] args) {
		
		Scanner scanXY = new Scanner(System.in);
		
		int[][] pointsArray = new int[3][2];
		
		for (int i = 0; i < pointsArray.length; i++) {
			System.out.print("Enter " + (i + 1) + " point coordinates (x,y): ");
			for (int j = 0; j < pointsArray[i].length; j++) {
				pointsArray[i][j] = scanXY.nextInt();
			}
		}
		scanXY.close();
		
		if ( (pointsArray[2][0] - pointsArray[0][0])*(pointsArray[1][1] - pointsArray[0][1]) == (pointsArray[1][0] - pointsArray[0][0])*(pointsArray[2][1] - pointsArray[0][1]) ) {
			System.out.println("All points are in the one line!");
		}
		else {
			System.out.println("Points are not in the one line.");
		}

	}

}
