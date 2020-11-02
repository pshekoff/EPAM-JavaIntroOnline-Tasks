package javaIntro_2_Algorithmization;

import java.lang.Math;
import java.util.Scanner;

public class SquareArraysPractice16 {

	public static void main(String[] args) {
		
		int n = 0;
		while (n <= 2) {
			System.out.print("Enter Magic Square size: ");
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
		magicSquare = getOddSquare(n);
		}
		
		else if ((n % 2 == 0)&(n % 4 != 0)) {
			magicSquare = getEvenSquare(n);
		}
		
		else if (n % 4 == 0) {
			magicSquare = getEvenEvenSquare(n);
		}
		
		IntArrayOutput.twoDim(magicSquare);
	}
	
	public static int[][] getOddSquare (int n) {

		int[][] magicSquare = new int[n][n];
		int number = 1;
		int row = 0;
		int column = (n-1)/2;
		
		while (number <= n*n) {

			magicSquare[row][column] = number;
			
			row--;
			column++;
			
			if (row == -1) {
				row = n - 1;
				if (column == n) {
					column = 0;
					if (magicSquare[row][column] != 0) {
						row = 1;
						column = n-1;
					}
				}
			}
			
			else if (column == n) {
				column = 0;
			}
			
			if (magicSquare[row][column] != 0) {
				row += 2;
				column--;
			}
			
			number++;
		}
		
		return magicSquare;
	}

	public static int[][] getEvenSquare (int n) {
		
		int[][] magicSquare = new int[n][n];
		int[][] magicSquareBasic = getOddSquare(n/2);
		
		int num = 0;
		while (num < 4) {
			for (int i = 0; i < n/2; i++) {
				for (int j = 0; j < n/2; j++) {
					switch (num) {
					case (0): magicSquare[i][j] = magicSquareBasic[i][j]; break;
					case (1): magicSquare[i][j+n/2] = magicSquareBasic[i][j]+n*n*2/4; break;
					case (2): magicSquare[i+n/2][j] = magicSquareBasic[i][j]+n*n*3/4; break;
					case (3): magicSquare[i+n/2][j+n/2] = magicSquareBasic[i][j]+n*n/4; break;
					}
				}
			}
			num++;
		}
		
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
	
	public static int[][] getEvenEvenSquare (int n) {
		
		int number = 1;
		int[][] numArr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				numArr[i][j] = number;
				number++;
			}
		}
		
		int[][] magicSquare = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					magicSquare[i][j] = numArr[n-1-i][n-1-j];
				}
				else if (i+j == n-1) {
					magicSquare[i][j] = numArr[n-1-i][n-1-j];
				}
			}
		}
		
		int sum = 3;
		while (sum < 2*n-4) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if ((i+j == sum)&(sum < n-1)) {
						magicSquare[i][j] = numArr[n-1-i][n-1-j];
					}
					else if ((i+j == sum)&(sum > n-1)) {
						magicSquare[i][j] = numArr[n-1-i][n-1-j];
					}
				}
			}
			sum += 4;
		}
		
		int diff = 4;
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
