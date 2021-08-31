package javaIntro_1_Basics;

import java.lang.Math;

public class LinearProgPractice6 {
	
	// 6. Для данной области составить линейную программу, которая печатает true, если точка с координатами (x,y)
	// принадлежит закрашенной области, и false - в противном случае: область по оси X от -4 до 4; по оси Y от -3 до 4.

	public static void main(String[] args) {
		
		int min = -5;
		int max = 5;
		int x = (int) (Math.random() * (max - min + 1) + min);
		int y = (int) (Math.random() * (max - min + 1) + min);
		
		System.out.println("Координаты точки: (" + x + "," + y + ")");
		
		boolean result = false;
		
		if (((x>=-4)&(x<4)&(y>=-3)&(y<=0))|((x>=-2)&(x<=2)&(y>=0)&(y<=4))) {
			result = true;
		}
		
		System.out.println("Ответ: " + result);
		
	}

}
