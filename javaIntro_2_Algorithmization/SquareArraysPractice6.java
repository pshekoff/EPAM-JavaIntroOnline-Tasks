package javaIntro_2_Algorithmization;

public class SquareArraysPractice6 {

	public static void main(String[] args) {
		
		int n = 8;
		int k = 0;
		int[][] myArr = new int [n][n];
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = k; j < n; j++) {
				myArr[i][j] = 1;
			}
			if (i < myArr.length/2 - 1) {
				n--;
				k++;
			}
			else if (i >= myArr.length/2){
				n++;
				k--;
			}
		}
		
		IntArrayOutput.twoDim(myArr);
	}

}