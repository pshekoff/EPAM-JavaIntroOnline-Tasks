package javaIntro_2_Algorithmization;

public class SquareArraysPractice15 {

	public static void main(String[] args) {
		
		int[][] myArr = {{3,7,2,9,2},{1,7,0,2,9},{4,9,7,6,5},{1,4,7,3,7},{2,2,1,7,5}};
		int max = myArr[0][0];
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				if (max < myArr[i][j]) {
					max = myArr[i][j];
				}
			}
		}
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				if (myArr[i][j] % 2 != 0) {
					myArr[i][j] = max;
				}
			}
		}
		
		IntArrayOutput.twoDim(myArr);
	}

}
