package javaIntro_2_Algorithmization;

import java.lang.Math;

public class SquareArraysPractice07 {
	
	// 7. Сформировать квадратную матрицу порядка N по правилу: A[I,J] = sin((pow(I,2)-pow(J,2))/N)
	// и подсчитать количество положительных элементов.
	
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
		
		MatrixOutput.print(myArr);	
		System.out.print("Количество положительных элементов = " + p);
	}

}
