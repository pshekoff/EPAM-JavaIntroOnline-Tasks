package javaIntro_1_Basics;

import java.util.Scanner;
import java.lang.Math;

public class LinearProgPractice2 {

	// 2. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
	// ((b+sqrt(pow(b,2)+4ac))/2a) - pow(a,3)*c + pow(b,-2)
	
	public static void main(String[] args) {
		
		System.out.print("Enter a,b,c: ");
		Scanner scanConst = new Scanner(System.in);
		double a = scanConst.nextDouble();
		double b = scanConst.nextDouble();
		double c = scanConst.nextDouble();
		scanConst.close();
		
		double z = (b + Math.sqrt(Math.pow(b, 2) + 4*a*c))/(2*a) - Math.pow(a, 3)*c + Math.pow(b, -2);
		
		System.out.println("Expression value = " + z);

	}

}
