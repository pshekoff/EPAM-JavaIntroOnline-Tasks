package javaIntro_1_Basics;

import java.lang.Math;

public class LinearProgPractice6 {

	public static void main(String[] args) {
		
		int a = -5;
		int b = 5;
		int x = (int) (Math.random() * (b - a + 1) + a);
		int y = (int) (Math.random() * (b - a + 1) + a);
		
		System.out.println("Координаты точки: " + x + ":" + y);
		
		boolean result = false;
		
		if (((x>=-4)&(x<4)&(y>=-3)&(y<=0))|((x>=-2)&(x<=2)&(y>=0)&(y<=4))) {
			result = true;
		}
		
		System.out.println(result);
		
	}

}
