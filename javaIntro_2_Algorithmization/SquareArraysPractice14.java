package javaIntro_2_Algorithmization;

import java.lang.Math;

public class SquareArraysPractice14 {
	
	// 14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц,
	// причем в каждом столбце, число единиц равно номеру столбца.

	public static void main(String[] args) {
		
		int min = 2;
		int max = 10;
		
		//генерируем матрицу случайного размера m x n
		int n = (int)  (Math.random()*(max - min) + min);
		int m = (int)  (Math.random()*(max - n) + n); //число строк не должно быть меньше числа столбцов

		int[][] myArr = new int[m][n];
		
		//проходим по столбцам
		for (int j = 0; j < myArr[0].length; j++) {

			int k = 0; //счетчик единиц
			
			//пока счетчик <= номера столбца
			while (k <= j) {

				//выбираем случайный элемент в столбце
				int row = (int) (Math.random()*m);

				//если не единица, присваиваем 1 и увеличиваем счетчик
				if (myArr[row][j] != 1) {
					myArr[row][j] = 1;
					k++;
				}
			}
		}
		//вывод матицы
		MatrixOutput.print(myArr);
	}

}
