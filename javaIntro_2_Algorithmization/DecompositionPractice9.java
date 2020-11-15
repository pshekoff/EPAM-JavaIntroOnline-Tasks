package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.lang.Math;

public class DecompositionPractice9 {

	public static void main(String[] args) {
		int x,y,z,t;
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Введите стороны четырехуголиника X, Y, Z, T:");
			x = scan.nextInt();
			y = scan.nextInt();
			z = scan.nextInt();
			t = scan.nextInt();
			
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

	public static double getTetragonSquare(int a, int b, int c, int d) {
		double square = 0;
		double e = Math.sqrt(a*a + b*b);
		double pp = (c+d+e)/2;
		square = a*b/2 + Math.sqrt(pp*(pp-c)*(pp-d)*(pp-e));
		return square;
	}
}
