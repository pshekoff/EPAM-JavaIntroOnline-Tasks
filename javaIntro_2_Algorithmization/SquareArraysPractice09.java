package javaIntro_2_Algorithmization;

public class SquareArraysPractice09 {
	
	// 9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце.
	// Определить, какой столбец содержит максимальную сумму.
	
	public static void main(String[] args) {
		
		int[][] myArr = {{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8},{5,6,7,8,9}};
		int[] arrSum = new int[5];
		MatrixOutput.print(myArr);
		
		//подсчет сумм в столбцах
		System.out.println("Суммы чисел в столбцах:");
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				arrSum[i] += myArr[j][i];
			}
			System.out.print(arrSum[i] + " ");
		}
		
		int maxSumIndex = 0;
		
		for (int i = 0; i < arrSum.length-1; i++) {
			if (arrSum[i+1] > arrSum[i]) {
				maxSumIndex = i+1;
			}
		}
		
		System.out.println("\nМаксимальная сумма чисел в " + (maxSumIndex+1) + "-м столбце");
	}

}
