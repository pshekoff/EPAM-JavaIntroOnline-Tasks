package javaIntro_3_Strings;

public class CharArrayPractice05 {
	
	// 5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
	// Крайние пробелы в строке удалить.

	public static void main(String[] args) {

		String str = " father mother    sister  brother  cat   dog    ";
		System.out.println("Исходная строка:" + str);
		System.out.println("Без лишник пробелов:" + spaceCut(str));

	}

	//метод удаления лишних пробелов из строки
	public static String spaceCut(String str) {
		str = str.trim();
		char[] strCharArr = str.toCharArray();
		int cutCount = 0;
		for (int i = 0; i < strCharArr.length-1; i++) {
			if ((strCharArr[i] == ' ')&(strCharArr[i+1] == ' ')) {
				str = str.substring(0, i-cutCount) + str.substring(i-cutCount+1, str.length());
				cutCount++;
			}

		}
		return str;
	}
}
