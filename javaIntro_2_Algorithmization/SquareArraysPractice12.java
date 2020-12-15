package javaIntro_2_Algorithmization;

import java.lang.Math;

public class SquareArraysPractice12 {

	public static void main(String[] args) {
		
		int[][] myArr = new int[10][10];
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				double ran = Math.random()*10;
				myArr[i][j] = (int) ran;
			}
		}
		
		System.out.println("Исходная матрица:");
		IntArrayOutput.twoDim(myArr);
		System.out.println("Сортировка чисел в строках по возрастанию:");
		
		for (int i = 0; i < myArr.length; i++) {
			int k = 0;
			do {
				for (int j = 0; j < myArr[i].length-1; j++) {
					if (myArr[i][j] > myArr[i][j+1]) {
						int r = myArr[i][j];
						myArr[i][j] = myArr[i][j+1];
						myArr[i][j+1] = r;
					}
				}
				k++;
			} while (k <= myArr[i].length);
		}
		
		IntArrayOutput.twoDim(myArr);
		System.out.println("Сортировка чисел в строках по убыванию:");
		
		for (int i = 0; i < myArr.length; i++) {
			int k = 0;
			do {
				for (int j = 0; j < myArr[i].length-1; j++) {
					if (myArr[i][j] < myArr[i][j+1]) {
						int r = myArr[i][j];
						myArr[i][j] = myArr[i][j+1];
						myArr[i][j+1] = r;
					}
				}
				k++;
			} while (k <= myArr[i].length);
		}
		
		IntArrayOutput.twoDim(myArr);
	}

}
