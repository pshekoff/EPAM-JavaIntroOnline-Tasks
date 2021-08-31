package javaIntro_1_Basics;

public class CyclesPractice3 {
	
	// 3. Найти сумму квадратов первых ста чисел.

	public static void main(String[] args) {

		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i*i;
		}
			
		System.out.println("Sum of squares for the first 100 figures = " + sum);	
		
	}

}
