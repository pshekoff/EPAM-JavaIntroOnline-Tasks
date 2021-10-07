package javaIntro_3_Strings;

import java.util.Scanner;

public class ObjectStringPractice08 {
	
	// 8. Вводится строка слов, разделеных пробелами. Найти самое длинное слово и вывести на экран.
	// Случай, когда самых длинных слов может быть несколько, не обрабатывать.

	public static void main(String[] args) {
		
		System.out.print("Enter string of words: ");
		Scanner scan = new Scanner(System.in);
		String sentence = scan.nextLine();
		scan.close();
		
		int index = 0;
		int maxCount = 0;
		
		for (int i = 0; i < sentence.length(); i++) {
			int count = 0;
			while (sentence.charAt(i) != ' ') {
				count++;
				i++;
				if (i == sentence.length()) {
					break;
				}
			}
			
			if (maxCount < count) {
				maxCount = count;
				index = i - count;
			}
		}
		System.out.print("The first longest word is: " + sentence.substring(index,index+maxCount));
	}

}
