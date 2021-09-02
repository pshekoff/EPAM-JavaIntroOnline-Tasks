package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.lang.Math;

public class DecompositionPractice09 {
	
	// 9. Даны числа X, Y, Z, T - длины сторон четырехугольника. Написать метод (методы) вычисления его площади,
	// если угол между сторонами длиной X и Y - прямой.

	public static void main(String[] args) {
		int x,y,z,t;
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Введите стороны четырехуголиника X, Y, Z, T:");
			x = scan.nextInt();
			y = scan.nextInt();
			z = scan.nextInt();
			t = scan.nextInt();
			
			//проверка на существование четырехугольника
			if (Math.sqrt(x*x + y*y) >= (z + t)) {
				System.out.println("Такого четырхугольника не существует!\nПовторите ввод.");
			}
			else {
				break;
			}
		}
		scan.close();
		
		System.out.print("Площадь прямоугольника: " + getTetragonSquare(x,y,z,t));
	}
	
	//метод нахождения площади четырехугольника
	public static double getTetragonSquare(int x, int y, int z, int t) {
		double square = 0;
		//длина диагонали четырехугольника
		double e = Math.sqrt(x*x + y*y);
		//полупериметр ереугольника zte
		double pp = (z+t+e)/2;
		//площадь четырехугольника находится как сумма площадей прямоугольного треугольника xye и треугольника zte
		//(площадь треугольника zte находим по формуле Герона)
		square = x*y/2 + Math.sqrt(pp*(pp-z)*(pp-t)*(pp-e));
		return square;
	}
}
