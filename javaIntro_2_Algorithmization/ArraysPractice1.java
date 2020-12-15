package javaIntro_2_Algorithmization;

public class ArraysPractice1 {

	public static void main(String[] args) {
		
		int[] myArray = {1,3,8,15,56,72,73,78,95};
		int sum = 0;
		int divK = 3;
		
		for (int i = 0; i < myArray.length; i++) {
			
			if (myArray[i] % divK == 0) {
				sum += myArray[i];
			}
		}
		
		System.out.println("Сумма чисел кратных " + divK + " = " + sum);
	}

}
