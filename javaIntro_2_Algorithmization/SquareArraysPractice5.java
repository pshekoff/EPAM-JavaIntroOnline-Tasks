package javaIntro_2_Algorithmization;

public class SquareArraysPractice5 {

	public static void main(String[] args) {
		
		int n = 8;
		int[][] myArr = new int [n][n];
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < n; j++) {
				myArr[i][j] = i + 1;
			}
			
			n--;
		}
		
		IntArrayOutput.twoDim(myArr);
	}

}
