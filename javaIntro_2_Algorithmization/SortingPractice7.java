package javaIntro_2_Algorithmization;

import java.util.Arrays;

public class SortingPractice7 {

	public static void main(String[] args) {

		double[] mainArr = new double[10];
		double[] insertArr = new double[5];
		double[] targetArr = new double[15];
		
		mainArr[0] = Math.round(Math.random()*10);
		
		for (int i = 1; i < mainArr.length; i++) {
			mainArr[i] = mainArr[i-1] + Math.round(Math.random()*10);
		}
		
		insertArr[0] =Math.round(Math.random()*20);
		
		for (int i = 1; i < insertArr.length; i++) {
			insertArr[i] = insertArr[i-1] + Math.round(Math.random()*20);
		}
		
		System.out.println("Исходный массив: " + Arrays.toString(mainArr) + "\nМассив для вставки: " + Arrays.toString(insertArr));
		
		for (int i = 0; i < mainArr.length; i++) {
			targetArr[i+5] = mainArr[i];
		}
		
		for(int i = 0; i < insertArr.length; i++) {
			int index = getIndex(targetArr, insertArr[i]);
				for (int j = 1; j  < index; j++) {
				targetArr[j-1] = targetArr[j];
			}
			
			targetArr[index-1] = insertArr[i]; 

		}
		
		System.out.println("Объединенный массив: " + Arrays.toString(targetArr));
		
	}
	
	public static int getIndex(double[] array, double keyValue) {
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (keyValue <= array[i]) {
				index = i;
				break;
			}
			else {
				index = i+1;
			}
		}
		
		return index;
	}

}
