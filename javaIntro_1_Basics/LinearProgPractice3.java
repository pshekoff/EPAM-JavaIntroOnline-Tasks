package javaIntro_1_Basics;

import java.util.Scanner;
import java.lang.Math;

public class LinearProgPractice3 {
	
	// 3. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
	// ((sinx + cosy)/(cosx - siny)) * tg(xy)

	public static void main(String[] args) {
		
		System.out.print("Enter x,y: ");
		
		Scanner scan = new Scanner(System.in);
		double x = scan.nextDouble();
		double y = scan.nextDouble();
		scan.close();
		
		double z = (Math.sin(x) + Math.cos(y))/(Math.cos(x) - Math.cos(y)) * Math.tan(x*y);
		
		System.out.println("Expression value = " + z);
		
	}

}
