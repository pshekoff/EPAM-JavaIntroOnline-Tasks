package javaIntro_2_Algorithmization;

import java.lang.Math;

public class SquareArraysPractice14 {

	public static void main(String[] args) {
		
		int a = 2;
		int b = 10;
		double ran = Math.random()*(b - a) + a;
		int n = (int) ran;
		ran = Math.random()*(b - a + n) + n;
		int m = (int) ran;
		int[][] myArr = new int[m][n];
		
		for (int j = 0; j < myArr[0].length; j++) {
			int k = 0;
			for (int i = 0; i < myArr.length; i++) {
				while (k <= j) {
					double r = Math.random()*m;
					int row = (int) r;
					k++;
					if (myArr[row][j] == 1) {
						k--;
					}
					else {
						myArr[row][j] = 1;
					}
				}
				
			}
		}
		
		IntArrayOutput.twoDim(myArr);

	}

}
