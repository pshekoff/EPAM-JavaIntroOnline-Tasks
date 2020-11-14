package javaIntro_3_Strings;

import java.util.Scanner;

public class ObjectStringPractice03 {

	public static void main(String[] args) {

		System.out.print("�������� ����� �����: ");
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		scan.close();
		
		if (isPalindrome(word)) {
			System.out.print("��� ����� - ���������!");
		}
		else {
			System.out.print("��� ����� �� �������� �����������.");
		}

	}
	
	public static boolean isPalindrome(String str) {
		boolean isPal = true;
		for (int i = 0; i < str.length()/2; i++) {
			if (str.charAt(i) != str.charAt(str.length()-1-i)) {
				isPal = false;
			}
		}
		return isPal;
	}

}
