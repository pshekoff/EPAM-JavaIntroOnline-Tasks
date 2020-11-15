package javaIntro_2_Algorithmization;

public class DecompositionPractice7 {

	public static void main(String[] args) {

		int n = 9;
		System.out.println("—умма факториалов нечетных чисел от 1 до " + n + ": " + getOddFactorialSum(n));

	}
	
	public static int getOddFactorialSum(int n) {
		int sum = 0;
		int i = 1;
		do {
			sum += getFactorial(i);
			i += 2;
		} while (i <= n);
		return sum;
	}
	
	public static int getFactorial (int n ) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
}
