package javaIntro_3_Strings;

public class ObjectStringPractice01 {
	
	// 1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.

	public static void main(String[] args) {

		String str = "  father mother    sister  brother    cat dog       ";
		int maxCount = 0;
		
		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			while (str.charAt(i) == ' ') {
				count++;
				i++;
				if (i == str.length()) {
					break;
				}
			}
			if (maxCount < count) {
				maxCount = count;
			}
		}
		System.out.println("The maximum count of spaces is: " + maxCount);
	}

}
