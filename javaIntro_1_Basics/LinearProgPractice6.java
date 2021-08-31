package javaIntro_1_Basics;

import java.lang.Math;

public class LinearProgPractice6 {
	
	// 6. ��� ������ ������� ��������� �������� ���������, ������� �������� true, ���� ����� � ������������ (x,y)
	// ����������� ����������� �������, � false - � ��������� ������: ������� �� ��� X �� -4 �� 4; �� ��� Y �� -3 �� 4.

	public static void main(String[] args) {
		
		int min = -5;
		int max = 5;
		int x = (int) (Math.random() * (max - min + 1) + min);
		int y = (int) (Math.random() * (max - min + 1) + min);
		
		System.out.println("���������� �����: (" + x + "," + y + ")");
		
		boolean result = false;
		
		if (((x>=-4)&(x<4)&(y>=-3)&(y<=0))|((x>=-2)&(x<=2)&(y>=0)&(y<=4))) {
			result = true;
		}
		
		System.out.println("�����: " + result);
		
	}

}
