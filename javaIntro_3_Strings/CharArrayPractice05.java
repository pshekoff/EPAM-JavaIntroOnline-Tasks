package javaIntro_3_Strings;

public class CharArrayPractice05 {

	public static void main(String[] args) {

		String str = " father mother    sister  brother  	cat   \ndog    ";
		System.out.println("Исходная строка:" + str);
		System.out.println("Без лишник пробелов:" + spaceCut(str));

	}

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
