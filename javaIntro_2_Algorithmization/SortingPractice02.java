package javaIntro_2_Algorithmization;

import java.lang.Math;
import java.util.Arrays;

public class SortingPractice02 {
	
	// 2. Даны две последовательности a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm.
	// Образовать из них новую последовательность так, чтобы она тоже была неубывающей.
	// Примечание: дополнительный массив не использовать.

	public static void main(String[] args) {
		
		int length = 10;
		
		int[] arrA = new int[length];
		int[] arrB = new int[length+length];

		//заполняем массивы случайными числами от 0 до 9
		arrA[0] = (int) (Math.random()*10);
		arrB[0] = (int) (Math.random()*10);
		for (int i = 1; i < length; i++) {
			arrA[i] = arrA[i-1] + (int) (Math.random()*10);
			arrB[i] = arrB[i-1] + (int) (Math.random()*10);
		}
		
		System.out.println("Массив А: " + Arrays.toString(arrA));
		
		for (int i = length; i < arrB.length; i++) {
			arrB[i] = arrA[i-length];
		}
		for (int i = 0; i < arrA.length; i++) {
			arrA[i] = arrB[i];
		}
		System.out.println("Массив B: " + Arrays.toString(arrA));
		
		//сортировка массива по возрастанию
		for (int i = 0; i < arrB.length; i++) {
			int value = arrB[i];
			int j = i - 1;
			for(; j >= 0; j--) {
				if (value < arrB[j]) {
					arrB[j+1] = arrB[j];
				}
				else {
					break;
				}
			}
			arrB[j+1] = value;
		}
		System.out.println("Слияние массивов А и В:\n" + Arrays.toString(arrB));
	}

}
