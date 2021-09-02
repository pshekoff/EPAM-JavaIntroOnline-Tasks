package javaIntro_2_Algorithmization;

public class SquareArraysPractice01 {
	
	// 1. Дана матрица. Вывестина экран все нечетные столбцы у которых первый элемент больше последнего.

	public static void main(String[] args) {
		
		int[][] myArr= {{1,2,3,4,5,6,7,8,9},{9,8,7,6,5,4,3,2,1},{1,1,1,1,1,1,9,9,9}};
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j += 2) {
				if (myArr[0][j] > myArr[myArr.length-1][j]) {
					System.out.print(myArr[i][j] + " ");
				}
			}
			
			System.out.println();
		}

	}

}
