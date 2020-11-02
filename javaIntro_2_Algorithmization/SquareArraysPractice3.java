package javaIntro_2_Algorithmization;

public class SquareArraysPractice3 {

	public static void main(String[] args) {
		
		int[][] myArr = {{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8},{5,6,7,8,9}};
		int k = 3;
		int p = 4;
		
		for (int i = 0; i < myArr[k-1].length; i++) {
			System.out.print(myArr[k-1][i]);
		}
		
		System.out.println();
		
		for (int i = 0; i < myArr.length; i++) {
			System.out.print(myArr[i][p-1]);
		}

	}

}
