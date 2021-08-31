package javaIntro_1_Basics;

import java.util.Scanner;

public class CyclesPractice7 {
	
	// 7. Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
	// m и n вводятся с клавиатуры.

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter diapazon from m to n: ");
		int m = scan.nextInt();
		int n = scan.nextInt();
		scan.close();
		
		for (int i = m; i <= n; i++) {
			System.out.print("Dividers for " + i + " is: ");
			
			for (int j = 2; j < i; j++) {
				
				if (i % j == 0) {
					System.out.print(j + " ");
				}
			}
			
			System.out.println();
		}

	}

}
