package javaIntro_2_Algorithmization;

public class ArraysPractice01 {
	
	// 1. В массив A[N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному K.

	public static void main(String[] args) {
		
		int[] myArray = {1,3,8,15,56,72,73,78,95};
		int sum = 0;
		int divK = 3;
		
		for (int i = 0; i < myArray.length; i++) {
			
			if (myArray[i] % divK == 0) {
				sum += myArray[i];
			}
		}
		
		System.out.println("Сумма элементов кратных " + divK + " = " + sum);
	}

}
