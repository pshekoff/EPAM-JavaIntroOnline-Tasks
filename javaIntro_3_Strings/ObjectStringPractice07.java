package javaIntro_3_Strings;

import java.util.Scanner;

public class ObjectStringPractice07 {
	
	// 7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
	// Например, если было введено abc cde def", то должно быть выведено "abcdfe".
	
	public static void main(String[] args) {

		System.out.print("Enter some string: ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				str = str.substring(0,i) + str.substring(i+1,str.length());
				i--;
			}
		}
		
		for (int i = 0; i < str.length(); i++) {
			while (str.substring(i+1).indexOf(str.charAt(i)) >= 0) {
				int index = str.substring(i+1).indexOf(str.charAt(i));
				str = str.substring(0,index+i+1) + str.substring(index+i+2,str.length());
			}
		} 
		System.out.print("String without spaces and dublicates: " + str);
	}
	
}
