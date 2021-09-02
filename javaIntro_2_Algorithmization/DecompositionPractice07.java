package javaIntro_2_Algorithmization;

public class DecompositionPractice07 {
	
	// 7. Написать метод (методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.

	public static void main(String[] args) {

		int n = 9;
		System.out.println("Сумма факториалов нечетных чисел от 1 до " + n + ": " + getOddFactorialSum(n));

	}
	
	//метод нахождения суммы факториалов нечетных чисел
	public static int getOddFactorialSum(int n) {
		int sum = 0;
		int i = 1;
		do {
			sum += getFactorial(i);
			i += 2;
		} while (i <= n);
		return sum;
	}
	
	//метод нахождения факториала
	public static int getFactorial (int n ) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
}
