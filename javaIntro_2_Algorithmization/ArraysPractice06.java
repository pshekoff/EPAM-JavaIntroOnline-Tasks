package javaIntro_2_Algorithmization;

public class ArraysPractice06 {
	
	// 6. Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых являются простыми числами.

	public static void main(String[] args) {
		
		double[] myArr = {3.1, 6.4, 2.3, 5.8, 1.9, 9.6, 4.6, 3.7, 1.1, 4.3, 8.7, 5.7, 2.1, 3.4, 5.4};
		double sum = 0;
		
		for (int i = 1; i <= myArr.length; i++) {
			if (isSimple(i) == true) {
				sum += myArr[i-1];
				System.out.println(i + " is simple. Value " + myArr[i-1] + " is taken to sum.");
			}
		}
		
		System.out.println("Sum = " + sum);
	}
	
	//simple number checking
	public static boolean isSimple(int num) {
		
		boolean result = true;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				result = false;
				break;
			}
		}
		if (num == 1) {
			result = false;
		}
		
		return result;
	}
}
