package javaIntro_2_Algorithmization;

import java.lang.Math;
import java.util.Arrays;

public class SortingPractice2 {

	public static void main(String[] args) {

		int[] arrA = new int[10];
		int[] arrB = new int[10];
		int[] arrC = new int[20];
		
		double ranA = Math.random()*10;
		double ranB = Math.random()*10;
		arrA[0] = (int) ranA;
		arrB[0] = (int) ranB;

		for (int i = 1; i < 10; i++) {
			ranA = Math.random()*10;
			ranB = Math.random()*10;
			arrA[i] = arrA[i-1] + (int)ranA;
			arrB[i] = arrB[i-1] + (int)ranB;
		}
		
		for (int i = 0; i < 10; i++) {
			arrC[2*i] = arrA[i];
			arrC[2*i+1] = arrB[i];
		}
		
		System.out.println("Массив А: " + Arrays.toString(arrA));
		System.out.println("Массив B: " + Arrays.toString(arrB));
		
		for (int i = 0; i < 19; i++) {
			for (int j = i+1; j < 20; j++) {
				if (arrC[i] > arrC[j]) {
					int replace = arrC[i];
					arrC[i] = arrC[j];
					arrC[j] = replace;
				}
			}
		}
		
		System.out.println("Слияние массивов А и В по возрастанию:\n" + Arrays.toString(arrC));

	}

}
