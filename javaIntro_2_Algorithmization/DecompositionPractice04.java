package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.lang.Math;

public class DecompositionPractice04 {
	
	// 4. На плоскости заданы своими координатами n точек. Написать метод (методы), определяющие,
	// между какими из пар точек самое большое расстояние. Указание: координаты точек занести в массив.

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
		
		int[][] indexes = getMaxDistanceIndexes(arrXY);
		System.out.println("Максимальное расстояние между точками c координатами:");
		
		//выводим пары точек по индексам, полученным из метода getMaxDistanceIndexes
		for (int j = 0; j < indexes[0].length; j++) {
			if (indexes[0][j] != -1) {
				System.out.println("(" + arrXY[0][indexes[0][j]] + "," + arrXY[1][indexes[0][j]] + ") и (" + arrXY[0][indexes[1][j]] + "," + arrXY[1][indexes[1][j]] + ")");
						
			}
		}
	}
	
	//метод находит в массиве точек индексы пар точек с наибольшим расстоянием между ними
	public static int[][] getMaxDistanceIndexes(int[][] array) {
		//массив с расстояниями межде всеми точками
		double[][] distanses = new double[array[0].length][array[0].length];
		//массив с индексами пар точек с наибольшим расстоянием между ними
		//таких пар может быть максимум 3 (если заданы 3 точки образующие равносторонний треугольник)
		int[][] indexes = {{-1,-1,-1},{-1,-1,-1}};
		
		//заполняем массив с расстояниями и находим наибольшее значение
		double max = 0;
		for (int i = 0; i < array[0].length-1; i++) {
			for (int j = i+1; j < array[0].length; j++) {
				double distanse = Math.sqrt(Math.pow(Math.abs(array[0][i] - array[0][j]),2) + Math.pow(Math.abs(array[1][i] - array[1][j]),2));
				distanses[i][j] = distanse;
				if (max < distanse) {
					max = distanse;
				}
			}
		}
		
		//записываем индексы пар точек имеющих наибольшое расстояние
		int k = 0;
		for (int i = 0; i < array[0].length-1; i++) {
			for (int j = i+1; j < array[0].length; j++) {
				if (distanses[i][j] == max) {
					indexes[0][k] = i;
					indexes[1][k] = j;
					k++;
				}
			}
		}
		//возвращаем массив индексов пар точек
		return indexes;
	}
	
}
