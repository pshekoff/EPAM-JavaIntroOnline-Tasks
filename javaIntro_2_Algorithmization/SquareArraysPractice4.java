package javaIntro_2_Algorithmization;

public class SquareArraysPractice4 {

	public static void main(String[] args) {
		
		int n = 8;
		int m = n;
		int[][] myArr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if (i%2 == 0) {
					myArr[i][j] = j + 1;
				}
				else {
					myArr[i][j] = m - j;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(myArr[i][j] + " ");
			}
			
			System.out.println();
		}
	}

}
