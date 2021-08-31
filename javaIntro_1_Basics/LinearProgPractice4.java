package javaIntro_1_Basics;

import java.util.Scanner;
import java.lang.Math;

public class LinearProgPractice4 {
	
	// 4. ƒано действительное число R вида nnn.ddd (три цифровых разр€да в дробной и целой част€х).
	// ѕомен€ть местами дробную и целую части числа и вывести полученное значение числа.

	public static void main(String[] args) {
		
		System.out.print("Enter value like nnn,ddd: ");
		
		Scanner scan = new Scanner(System.in);
		double x = scan.nextDouble();
		scan.close();
		
		double n = Math.floor(x);
		double d = x - n;
		double y = Math.round(d*1000) + n/1000;
		
		System.out.println("Revers = " + y);

	}

}
