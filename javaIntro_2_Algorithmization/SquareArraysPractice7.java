package javaIntro_2_Algorithmization;

import java.lang.Math;

public class SquareArraysPractice7 {
	
	public static void main(String[] args) {
		
		int n = 8;
		int p = 0;
		double[][] myArr = new double[n][n];
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				myArr[i][j] = Math.sin((Math.pow(i, 2) - Math.pow(j, 2)) / n);
				if (myArr[i][j] > 0) {
					p++;
				}
			}
		}
		
		System.out.print(p);
	}

}
