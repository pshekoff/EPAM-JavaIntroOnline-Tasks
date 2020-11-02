package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.lang.Math;

public class DecompositionPractice3 {

	public static void main(String[] args) {

		System.out.print("Введите длину стороны правильного шестиугольника: ");
		
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		scan.close();
		
		double square = getHexagonSquare(a);
		
		System.out.print("Площадь шестиугольнтка: " + square);

	}
	
	public static double getHexagonSquare (int a) {
		double s = a*a*3*Math.sqrt(3)/2;
		return s;
	}

}
