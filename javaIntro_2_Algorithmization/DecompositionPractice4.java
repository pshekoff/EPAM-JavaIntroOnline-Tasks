package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.lang.Math;

public class DecompositionPractice4 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Укажите количество точек: ");
		int n = scan.nextInt();
		int[][] arrXY = new int[2][n];
		System.out.println("Введите координаты (x,y) " + n + " точек:");
		
		for (int j = 0; j < arrXY[0].length; j++) {
			System.out.print("(x" + (j+1) + ",y" + (j+1) + ") = ");
			arrXY[0][j] = scan.nextInt();
			arrXY[1][j] = scan.nextInt();
		}
		scan.close();
		
		int[] index = getIndexMaxDistance(arrXY);
		
		System.out.print("Максимальное расстояние между точками c координатами:\n(" + arrXY[0][index[0]] + "," + arrXY[1][index[0]] + ") и (" + arrXY[0][index[1]] + "," + arrXY[1][index[1]] + ")");
	}
	
	public static int[] getIndexMaxDistance (int[][] array) {
		
		int[] index = new int[2];
		double max = 0;
		
		for (int i = 0; i < array[0].length-1; i++) {
			for(int j = i+1; j < array[0].length; j++) {
				double distanse = Math.sqrt(Math.pow(Math.abs(array[0][i] - array[0][j]),2) + Math.pow(Math.abs(array[1][i] - array[1][j]),2));
				if (max < distanse) {
					max = distanse;
					index[0] = i;
					index[1] = j;
				}
			}
		}
		
		return index;
	}
}
