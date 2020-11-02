package javaIntro_2_Algorithmization;

import java.util.Scanner;

public class SquareArraysPractice8 {

	public static void main(String[] args) {
		
		int[][] myArr = {{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8},{5,6,7,8,9}};
		int[] arr = new int[5];
		IntArrayOutput.twoDim(myArr);
		
		System.out.print("Какие 2 столбца поменять местами?");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.close();
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr.length; j++) {
				if (j == n - 1) {
					arr[i] = myArr[i][j];
					myArr[i][j] = myArr[i][m - 1];
					myArr[i][m - 1] = arr[i];
				}
			}
		}
			
		IntArrayOutput.twoDim(myArr);
	}

}
