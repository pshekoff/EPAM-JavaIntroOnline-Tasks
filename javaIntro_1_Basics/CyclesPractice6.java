package javaIntro_1_Basics;

public class CyclesPractice6 {

	public static void main(String[] args) {
		
		// 6. Вывести на экран соответствия между символами и их численными обозначениями в памяти компьютера.
		
		for (int i = 1; i <= 256; i++) {
			char a = (char) i;
			System.out.println(a + " = " + i);
		}

	}

}
