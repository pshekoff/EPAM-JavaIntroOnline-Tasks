package javaIntro_2_Algorithmization;

public class ArraysPractice10 {
	
	// 10. Дан целочисленный массив с количеством элементов n. Сжать массив, выбросив из него каждый второй элемент
	// (освободившиеся элементы заполнить нулями). Примечание: дополнительный массив не использовать.

	public static void main(String[] args) {
		
		int[] myArr = {1,2,3,4,5,6,7,8,9};
		
		//присваиваем 0 каждому второму элементу массива
		for (int i = 1; i < myArr.length; i += 2) {
			myArr[i] = 0;
		}
		
		for (int i = 0; i < myArr.length; i++) {
			System.out.println(myArr[i]);
		}
	}

}
