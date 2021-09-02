package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class DecompositionPractice13 {
	
	// 13. Два простых числа называются "близнецами", если они отличаются друг от друга на 2 (например, 41 и 43).
	// Найти и напечатать все пары "близнецов" из отрезка [n,2n], где n - заданное натуральное число больше 2.
	// Для решения задачи использовать декомпозицию.

	public static void main(String[] args) {
		
		System.out.println("Введите n > 2");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		System.out.print("Список простых чисел близнецов на отрезке [" + n + "," + 2*n + "]: " + Arrays.toString(getSimpleTwins(n)));
	}
	
	//получение близнецов
	public static int[] getSimpleTwins(int n) {
		int count = 0;
		
		for (int i = n; i <= 2*n-2; i++) {
			if ((isSimple(i) == true)&(isSimple(i+2)) == true) {
				count += 2;
			}
		}
		
		int[] array = new int[count];
		count = 0;
		
		for (int i = n; i <= 2*n-2; i++) {
			if ((isSimple(i) == true)&(isSimple(i+2)) == true) {
				array[count] = i;
				array[count+1] = i+2;
				count += 2;
			}
		}
		return array;
	}
	
	//проверка, является ли число простым
	public static boolean isSimple(int a) {
		boolean isSimple = true;

		for (int d = 2; d <= (int) Math.sqrt(a); d++) {
			if (a%d == 0) {
				isSimple = false;
				break;
			}
		}
		return isSimple;
	}

}
