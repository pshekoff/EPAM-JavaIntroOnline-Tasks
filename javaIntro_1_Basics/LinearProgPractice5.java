package javaIntro_1_Basics;

import java.lang.Math;

public class LinearProgPractice5 {
	
	// 5. ���� ����������� ����� T, ������� ������������ ������������ ���������� ������� � ��������.
	// ������� ������ ������� ������������ � �����, ������� � �������� � ��������� �����: HH� MM��� SS�.

	public static void main(String[] args) {
		
		int min = 0;
		int max = 24*3600;
		final int time = (int) (Math.random() * (max - min + 1) + min);
		
		System.out.println("����� � ��������: " + time); 
		
		int timeSeconds = time;
		int timeHours = (int) Math.floor(timeSeconds/3600);
		timeSeconds = timeSeconds - timeHours*3600;
		int timeMinutes = (int) Math.floor(timeSeconds/60);
		timeSeconds = timeSeconds - timeMinutes*60;
		
		System.out.println("� ������� HH� MM��� SS�: " + timeHours + "� " + timeMinutes + "��� " + timeSeconds + "�");

	}

}
