package javaIntro_2_Algorithmization;

public class SquareArraysPractice13 {
	
	// 13. Отсортировать столбцы матрицы по возрастанию и убыванию значений элементов.

	public static void main(String[] args) {
		
		int[][] myArr = new int[10][10];
		
		//генерация случайной матрицы
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				double ran = Math.random()*10;
				myArr[i][j] = (int) ran;
			}
		}
		
		System.out.println("Исходная матрица:");
		MatrixOutput.print(myArr);
		
		System.out.println("Сортировка чисел в столбцах по возрастанию:");
		
		//сортировка по возрастанию
		for (int i = 0; i < myArr[0].length; i++) {
			int k = 0;
			do {
				for (int j = 0; j < myArr.length-1; j++) {
					if (myArr[j][i] > myArr[j+1][i]) {
						int r = myArr[j][i];
						myArr[j][i] = myArr[j+1][i];
						myArr[j+1][i] = r;
					}
				}
				
				k++;
				
			} while (k <= myArr[0].length);
		}
		
		MatrixOutput.print(myArr);
		
		System.out.println("Сортировка чисел в столбцах по убыванию:");
		
		//сортировка по убыванию
		for (int i = 0; i < myArr[0].length; i++) {
			int k = 0;
			do {
				for (int j = 0; j < myArr.length-1; j++) {
					if (myArr[j][i] < myArr[j+1][i]) {
						int r = myArr[j][i];
						myArr[j][i] = myArr[j+1][i];
						myArr[j+1][i] = r;
					}
				}
				
				k++;
				
			} while (k <= myArr[0].length);
		}
		
		MatrixOutput.print(myArr);
	}

}
