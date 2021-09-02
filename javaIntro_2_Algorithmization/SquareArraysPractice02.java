package javaIntro_2_Algorithmization;

public class SquareArraysPractice02 {
	
	// 2. Дана квадратная матрица. Вывести на экран элементы, стояцие по диагонали.

	public static void main(String[] args) {
		int[][] myArr = {{1,2,3},{4,5,6},{7,8,9}};
		
		for (int i = 0; i < myArr.length; i++) {
			System.out.println(myArr[i][i]);
		}
		
	}
	
}
