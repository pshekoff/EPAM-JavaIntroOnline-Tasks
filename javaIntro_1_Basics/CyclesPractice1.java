package javaIntro_1_Basics;

import java.util.Scanner;

public class CyclesPractice1 {
	
	// 1. Напишите программу, где пользователь вводит любое целое положительное число.
	// А программа суммирует все числа от 1 до введенного пользователем числа.

	public static void main(String[] args) {
		
		System.out.print("Enter possitive whole number: ");
		Scanner scanNum = new Scanner(System.in);
		int maxNumber = scanNum.nextInt();
		scanNum.close();
		
		int sum = 0;
		for (int i = 1; i <= maxNumber; i++) {
			sum += i;
		}
			
		System.out.println("Sum of all figures from 1 to " + maxNumber + " = " + sum);
		
	}

}
