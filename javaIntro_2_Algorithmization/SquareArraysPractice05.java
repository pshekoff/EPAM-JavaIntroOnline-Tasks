package javaIntro_2_Algorithmization;

public class SquareArraysPractice05 {
	
	/* 5. Сформировать квадратную матрицу порядка n по заданному образцу (n - четное):
	 * {1	1	1  ... 1	1	1}
	 * {2	2	2  ... 2	2	0}
	 * {3	3	3  ... 3	0	0}
	 * {.........................}
	 * {.........................}
	 * {.........................}
	 * {n-1	n-1	0  ... 0	0	0}
	 * {n	0	0  ... 0	0	0}
	 */

	public static void main(String[] args) {
		
		int n = 8;
		int[][] myArr = new int [n][n];
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < n; j++) {
				myArr[i][j] = i + 1;
			}
			
			n--;
		}
		
		MatrixOutput.print(myArr);
	}

}
