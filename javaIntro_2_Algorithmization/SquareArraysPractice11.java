package javaIntro_2_Algorithmization;

import java.lang.Math;

public class SquareArraysPractice11 {
	
	// 11. Матрицу 10х20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номер строк,
	// в которых число 5 встречается три и более раз.

	public static void main(String[] args) {
		
		int[][] myArr = new int [10][20];
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				double ran = Math.random()*16;
				myArr[i][j] = (int) ran;
			}
		}
		
		MatrixOutput.print(myArr);
		int i = 0;
		System.out.print("Строки, в которых более 3х пятерок: ");
		
		do {
			int fiveCount = 0;
			for (int j = 0; j < myArr[i].length; j++) {
				if (myArr[i][j] == 5) {
					fiveCount++;
				}
			}
			i++;
			if (fiveCount >= 3) {
				System.out.print(i + "я ");
			}
			
		} while (i < myArr.length);
		
	}

}
