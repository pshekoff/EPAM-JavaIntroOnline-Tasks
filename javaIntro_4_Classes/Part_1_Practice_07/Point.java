package javaIntro_4_Classes;

import java.util.Scanner;
import java.lang.Math;

public class Point {
	public double x, y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	protected Point() {
		x = 0;
		y = 0;
	}
	
	public static double length(Point a, Point b) {
		return Math.sqrt(Math.pow((b.x-a.x), 2) + Math.pow((b.y-a.y), 2));
	}
	
	public void scanPoint(Scanner scan) {
		System.out.print("x = ");
		x = scan.nextDouble();
		System.out.print("y = ");
		y = scan.nextDouble();
	}
	
	public void output() {
		System.out.println("(" + x + "," + y + ")");
	} 
}
