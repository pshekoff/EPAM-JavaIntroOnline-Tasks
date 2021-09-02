package javaIntro_2_Algorithmization;

public class SquareArraysPractice04 {
	
	/* 4. Сформировать квадратную матрицу порядка n по заданному образцу (n - четное):
	 * {1	 2	  3  ... n}
	 * {n   n-1  n-2 ... 1}
	 * {1	 2	  3  ... n}
	 * {n   n-1  n-2 ... 1}
	 * {..................}
	 * {..................}
	 * {..................}
	 * {n   n-1  n-2 ... 1}
	 */

	public static void main(String[] args) {
		
		int n = 8;
		int[][] myArr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if (i%2 == 0) {
					myArr[i][j] = j + 1;
				}
				else {
					myArr[i][j] = n - j;
				}
			}
		}

		MatrixOutput.print(myArr);

	}

}
