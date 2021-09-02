package javaIntro_2_Algorithmization;

import java.util.Arrays;

public class SortingPractice05 {
	
	/* 5. Сортировка вставками. Дана последовательность чисед a1,a2,...,an. Требуется переставить
	 * числа в порядке возрастания. Делается это следующим образом. Пусть a1,a2,...ai - упорядоченная
	 * последовательность, т.е. a1 <= a2 <= ... <= an. Берется следующее число a[i+1] и вставляется
	 * в последовательность так, чтобы новая последовательность была тоже воррастающей. Процесс производится
	 * до тех пор, пока все элементы от i+1 до n не будут перебраны. Примечание: место помещения очередного
	 * элемента в отсортированную часть производить с помощью двоичного поиска. Двоичный поиск оформить в
	 * виде отдельной функции.
	 */

	public static void main(String[] args) {

		//генерация случайного массива
		int[] myArr = new int[20];
		for (int i = 0; i < myArr.length; i++) {
			myArr[i] = (int) (Math.random()*100);
		}
		System.out.println("Исходный массив:\n" + Arrays.toString(myArr));
		
		//сортировка вставками
		for (int i = 1; i < myArr.length; i++) {
			//записываем нужный элемент
			int value = myArr[i];
			//получаем индекс для вставки
			int index = getIndex(myArr, value, 0, i-1);
			//сдвигаем все элементы массива справа от индекса
			for (int j = i; j > index; j--) {
				myArr[j] = myArr[j-1];
			}
			//записываем сохраненное значение по найденному индексу
			myArr[index] = value;
		}

		System.out.println("Сортировка вставками по возрастанию:\n" + Arrays.toString(myArr));

	}
	
	//двоичный поиск
	public static int getIndex(int[] array, int keyValue, int start, int end) {
		
		int index = -1;
		
		while (start <= end) {
			int middle = (start + end)/2;
			if (array[middle] < keyValue) {
				start = middle + 1;
				index = start;
			}
			else if (array[middle] > keyValue) {
				end = middle - 1;
				index = middle;
			}
			else if (array[middle] == keyValue) {
				index = middle;
				break;
			}
		}
		
		return index;
	}

}


