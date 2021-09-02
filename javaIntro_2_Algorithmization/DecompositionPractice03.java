package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.lang.Math;

public class DecompositionPractice03 {
	
	// 3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.

	public static void main(String[] args) {

		System.out.print("Введите длину стороны правильного шестиугольника: ");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		scan.close();
		
		//правильный шестиугольник состоит из 6-и правильных треугольников
		double square = 6*getTriangleSquare(a);
		System.out.print("Площадь шестиугольнтка: " + square );
	}
	
	//метод нахождения площади правильного треугольника
	public static double getTriangleSquare(int a) {
		double s = Math.pow(a,2)*Math.sqrt(3)/4;
		return s;
	}

}
