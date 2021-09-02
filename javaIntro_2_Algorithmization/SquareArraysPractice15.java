package javaIntro_2_Algorithmization;

public class SquareArraysPractice15 {
	
	// 15. Найдите наибольший элемент матрицы и замените все нечетные элементы на него.

	public static void main(String[] args) {
		
		int[][] myArr = {{3,7,2,9,2},{1,7,0,2,9},{4,9,7,6,5},{1,4,7,3,7},{2,2,1,7,5}};
		System.out.println("Исходная матрица:");
		MatrixOutput.print(myArr);
		
		int max = myArr[0][0];
		
		//находим наибольший элемент
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				if (max < myArr[i][j]) {
					max = myArr[i][j];
				}
			}
		}
		
		//заменяем все нечетыне на наибольший
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				if (myArr[i][j] % 2 != 0) {
					myArr[i][j] = max;
				}
			}
		}
		System.out.println("Итоговая матрица:");
		MatrixOutput.print(myArr);
	}

}
