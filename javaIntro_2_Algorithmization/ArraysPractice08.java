package javaIntro_2_Algorithmization;

public class ArraysPractice08 {
	
	// 8. Дана последовательность целых чисел a1, a1,..., an. Образовать новую последовательность,
	// выбросив из исходной те члены, которые равны min(a1, a2,...,an).

	public static void main(String[] args) {
		
		int[] myArr = {4,1,63,2,7,1,2,8,1,5};
		int minA = myArr[0];
		
		//поиск минимального значения
		for (int i = 1; i < myArr.length; i++) {
			if (myArr[i] < minA) {
				minA = myArr[i];
			}
		}
		
		int minCount = 0;
		
		//количество занчений равных минимальному
		for (int i = 0; i < myArr.length; i++) {
			if (myArr[i] == minA) {
				minCount++;
			}
		}
		
		//массив для новой последовательности
		int[] newArr = new int[myArr.length - minCount];
		
		minCount = 0;
		
		//инициализация массива новой последовательностью
		for (int i = 0; i < newArr.length; i++) {
			int j = i + minCount;
			if (myArr[j] == minA) {
				minCount++;
			}
			newArr[i] = myArr[i + minCount];
			System.out.println(newArr[i]);
		}
	}

}
