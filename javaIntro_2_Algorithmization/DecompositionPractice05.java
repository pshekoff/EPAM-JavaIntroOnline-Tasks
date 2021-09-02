package javaIntro_2_Algorithmization;

import java.util.Arrays;

public class DecompositionPractice05 {
	
	// 5. Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
	// которое меньше максимального элемента массива, но больше всех других элементов).

	public static void main(String[] args) {
		int[] arr = new int[10];
		//заполняем массив случайными числами от 0 до 9
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random()*10);
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("Второе по величине число: " + getPreMaxValue(arr));
	}
	
	//метод нахождения максимального значения
	public static int getMaxValue(int[] array) {
		int maxVal = array[0];
		for (int i = 1; i < array.length; i++) {
			if (maxVal < array[i]) {
				maxVal = array[i];
			}
		}
		return maxVal;
	}
	
	//метод нахождения предмаксимального значения
	public static int getPreMaxValue(int[] array) {
		//получаем максимальное значение
		int maxVal = getMaxValue(array);
		
		int preMaxVal = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != maxVal) {
				preMaxVal = array[i];
				for (int j = i; j < array.length; j++) {
					if ((array[j] != maxVal)&&(preMaxVal < array[j])) {
						preMaxVal = array[j];
					}
				}
				break;
			}
		}
		return preMaxVal;
	}

}
