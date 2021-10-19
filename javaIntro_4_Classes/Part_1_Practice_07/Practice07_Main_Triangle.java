package javaIntro_4_Classes;

import java.util.Scanner;

public class Practice07_Main_Triangle {
	
	// 7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов,
	// вычисления площади, периметра и точко пересечения медиан.

	public static void main(String[] args) {
		Point a = new Point();
		Point b = new Point();
		Point c = new Point();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 3 points to get a triangle.");
		System.out.println("Enter point A: ");
		a.scanPoint(scan);
		System.out.println("Enter point B: ");
		b.scanPoint(scan);
		System.out.println("Enter point C: ");
		c.scanPoint(scan);
		scan.close();
		
		Triangle t = new Triangle(a, b, c);
		System.out.println("Triangle perimeter = " + t.perimeter());
		System.out.println("Triangle square = " + t.square());
		System.out.print("Median cross point has coordinates: ");
		t.medianCross().output();
	}

}
