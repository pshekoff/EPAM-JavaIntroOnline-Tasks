package javaIntro_2_Algorithmization;

import java.lang.Math;
import java.util.Scanner;

public class SquareArraysPractice16 {
	
	/* 16. Магическим квадратом порядка n называется квадратная матрица размера nxn,
	 * составленная из чисел 1,2,3,...,pow(n,2) так, что суммы по каждому столбцу,
	 * каждой строке и каждой из двух больших диагоналей равны между собой.
	 * Построить такой квадрат. Пример магического квадрата порядка 3:
	 * 6 1 8
	 * 7 5 3
	 * 2 9 4
	 */

	public static void main(String[] args) {
		
		int n = 0;
		while (n <= 2) {
			System.out.print("Enter Magic Square size >=3: ");
			Scanner scan = new Scanner(System.in); 
			n = scan.nextInt();
			if (n <= 2) {
				System.out.println("It is impossible to build a magic square for size " + n);
			}
			else {
				scan.close();
			}
		}
		
		int[][] magicSquare = new int[n][n];
		
		if (n % 2 != 0) {
			//квадрат нечетного порядка
			magicSquare = getOddSquare(n);
		}
		
		else if ((n % 2 == 0)&(n % 4 != 0)) {
			//квадрат четного порядка
			magicSquare = getEvenSquare(n);
		}
		
		else if (n % 4 == 0) {
			//квадрат четно-четного порядка
			magicSquare = getEvenEvenSquare(n);
		}
		
		MatrixOutput.print(magicSquare);
	}
	
	
	//построение магического квадрата нечетного порядка (сиамский метод)
	public static int[][] getOddSquare (int n) {

		int[][] magicSquare = new int[n][n];
		int number = 1;
		
		//начальная позиция (середина первого ряда)
		int row = 0;
		int column = (n-1)/2;
		
		//заполнение квадрата числами от 1 до n*n
		while (number <= n*n) {
			
			magicSquare[row][column] = number;
			
			//двигаемся по квадрату ввверх-вправо
			row--;
			column++;
			
			//если выходим за верхнюю границу квадрата, то перемещаемся на последний ряд (индекс n-1)
			if (row == -1) {
				row = n - 1;
				//если еще и вышли за правую границу квадрате, то опускаемся вниз от предыдущей заполненной ячейки
				if (column == n) {
					row = 1;
					column = n-1;
				}
			}
			
			//если вышли за правую границу квадрате, то перемещаемся на первый столбец (инлекс 0)
			else if (column == n) {
				column = 0;
			}
			
			//если ячейка уже заполнена, возвращаемся (вниз-влево) и опускаемся вниз от предыдущей заполненной ячейки 
			if (magicSquare[row][column] != 0) {
				row += 2;
				column--;
			}
			
			number++;
		}
		
		return magicSquare;
	}
	
	
	//построение магического квадрата четного порядка (метод четырех квадратов)
	public static int[][] getEvenSquare (int n) {
		
		int[][] magicSquare = new int[n][n];
		
		//получаем магический квадрат нечетного поряда n/2
		int[][] magicSquareBasic = getOddSquare(n/2);
		
		int num = 0;
		while (num < 4) {
			//заполняем квадрат n-го порядка 4-мя квадратами n/2 порядка, увеличивая элементы каждого следующего квадрата на величину n*n/4
			for (int i = 0; i < n/2; i++) {
				for (int j = 0; j < n/2; j++) {
					switch (num) {
					case (0): magicSquare[i][j] = magicSquareBasic[i][j]; break;				//заполняет левую верхнюю четверть
					case (1): magicSquare[i][j+n/2] = magicSquareBasic[i][j]+n*n*2/4; break;	//заполняет правую верхнюю четверть
					case (2): magicSquare[i+n/2][j] = magicSquareBasic[i][j]+n*n*3/4; break;	//заполняет левую нижнюю четверть
					case (3): magicSquare[i+n/2][j+n/2] = magicSquareBasic[i][j]+n*n/4; break;	//заполняет правую нижнюю четверть
					}
				}
			}
			num++;
		}
		
		//для получения магического квадрата, проводим необходимые перестановки элементов описанные методом четырех квадратов
		
		int replace;
		for (int i = 0; i < n/2; i++) {
			for (int j = (n+6)/4; j < (3*n-6)/4; j++) {
				replace = magicSquare[i][j];
				magicSquare[i][j] = magicSquare[i+n/2][j];
				magicSquare[i+n/2][j] = replace;
			}
		}
		
		for (int i = 0; i < n/2; i++) {
			if ((i == 0)|(i == n/2-1)) {
				replace = magicSquare[i][0];
				magicSquare[i][0] = magicSquare[i+n/2][0];
				magicSquare[i+n/2][0] = replace;
			}
			else {
			replace = magicSquare[i][1];
			magicSquare[i][1] = magicSquare[i+n/2][1];
			magicSquare[i+n/2][1] = replace;
			}

		}
		
		return magicSquare;
	}
	
	
	//построение магического квадрата четно-четного порядка (метод Рауз-Болла)
	public static int[][] getEvenEvenSquare (int n) {
		
		//заполняем квадрат nxn числами от 1 до n*n начиная с левого вернего угла двигаемся слева направо по каждой строке
		int number = 1;
		int[][] numArr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				numArr[i][j] = number;
				number++;
			}
		}
		
		int[][] magicSquare = new int[n][n];

		//для построения магического квадрата необходимо представить диагонали, пересекающие квадрат через каждые 4 клетки,
		//и зеркально (относительно точки центра квадрата) переставить элементы, расположенные на этих диагоналях
		
		//переставляем элементы находящиеся на диагоналях, идущих слева-направо снизу-вверх
		//сумма индексов таких элементов будет равна 3 для первой диагонали, 7 для второй и 2*n-4-1 для последней
		int sum = 3;
		while (sum < 2*n-4) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if ((i+j == sum)) {
						magicSquare[i][j] = numArr[n-1-i][n-1-j];
					}
				}
			}
			sum += 4;
		}
		
		//переставляем элементы находящиеся на диагоналях, идущих слева-направо сверху-вниз
		//модуль разности индексов таких элементов будет равен n-4 для первой и последней диагоналей, n-8 для второй предпоследней
		//и 0 для главной диагонали диагонали 
		int diff = 0;
		while (diff <= n-4 ) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (Math.abs(i-j) == diff) {
						magicSquare[i][j] = numArr[n-1-i][n-1-j];
					}
				}
			}
			diff += 4;
		}
		
		//заполняем оставшиеся пустые элементы (не попавшие на диагонали) элементами из исходного массива последовательных чисел
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (magicSquare[i][j] == 0) {
					magicSquare[i][j] = numArr[i][j];
				}
			}
		}
		
		return magicSquare;
	}
}
