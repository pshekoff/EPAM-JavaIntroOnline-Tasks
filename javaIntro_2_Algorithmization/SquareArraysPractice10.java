package javaIntro_2_Algorithmization;

public class SquareArraysPractice10 {
	
	// 10. Найти положительные элементы главной диагонали квадратной матрицы.
	
	public static void main(String[] args) {
		
		int[][] myArr = {{1,2,3,4,5},{-1,-2,-3,-4,5},{-2,-3,-4,5,6},{3,-4,-5,6,-7},{-3,4,-5,6,-7}};
		MatrixOutput.print(myArr);
		
		System.out.println("Положительные элементы главной диагонали:");
		for (int i = 0; i < myArr.length; i++) {
			if (myArr[i][i] > 0) {
				System.out.println(myArr[i][i]);
			}
		}
	}

}
