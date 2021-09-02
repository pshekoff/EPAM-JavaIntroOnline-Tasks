package javaIntro_2_Algorithmization;

public class SquareArraysPractice03 {
	
	// 3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.

	public static void main(String[] args) {
		
		int[][] myArr = {{1,2,3,4,5},{5,6,7,8,9},{3,3,3,3,3},{9,8,7,6,5},{5,4,3,2,1}};
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
