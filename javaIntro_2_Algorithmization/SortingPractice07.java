package javaIntro_2_Algorithmization;

import java.util.Arrays;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SortingPractice07 {
	
	/* 7. Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <=...<=an и
	 * b1 <= b2 <=...<= bm. Требуется указать те места, на которые нужно вставлять элементы последовательности
	 * b1 <= b2 <=...<= bm в первую последовательность так, чтобы новая последовательность оставалась возрастающей.
	 */
	
	public static void main(String[] args) {
		
		BigDecimal[] mainArr = new BigDecimal[10];
		BigDecimal[] insertArr = new BigDecimal[5];

		//заполняем массивы случайными действительными числами > 0
		mainArr[0] = new BigDecimal(Math.random()*10).setScale(2, RoundingMode.HALF_UP);
		for (int i = 1; i < mainArr.length; i++) {
			BigDecimal random = new BigDecimal(Math.random()*10);
			mainArr[i] = mainArr[i-1].add(random).setScale(2, RoundingMode.HALF_UP);;
		}
		insertArr[0] = new BigDecimal(Math.random()*10).setScale(2, RoundingMode.HALF_UP);
		for (int i = 1; i < insertArr.length; i++) {
			BigDecimal random = new BigDecimal(Math.random()*20);
			insertArr[i] = insertArr[i-1].add(random).setScale(2, RoundingMode.HALF_UP);;
		}
		
		System.out.println("Массив А:\n" + Arrays.toString(mainArr) + "\nМассив В:\n" + Arrays.toString(insertArr));
		
		for(int i = 0; i < insertArr.length; i++) {
			int index = getIndex(mainArr, insertArr[i]);
			if (index < mainArr.length) {
				System.out.println("Элемент В[" + i + "]=" + insertArr[i] + " нужно вставить перед A[" + index + "]=" + mainArr[index]);
			}
			else {
				System.out.println("Элемент В[" + i + "]=" + insertArr[i] + " нужно вставить в конец массива А");
			}
		}
		
	}
	
	//получени индекса в массиве А для вставки элемента из массива В
	public static int getIndex(BigDecimal[] array, BigDecimal keyValue) {
		int index = array.length;
		for (int i = 0; i < array.length; i++) {
			if ((keyValue.compareTo(array[i]) == 0)||(keyValue.compareTo(array[i]) < 0)) {
				index = i;
				break;
			}
		}	
		return index;
	}

}
