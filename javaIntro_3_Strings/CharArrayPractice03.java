package javaIntro_3_Strings;

public class CharArrayPractice03 {
	
	// 3. В строке найти количество цифр.

	public static void main(String[] args) {
		
		String str = "e24wo5rq tgd243wod w80wors87dr4fe s20;we";
		System.out.println("Исходная строка:\t" + str);
		System.out.println("Кол-во цифр в строке:\t" + getDigitsCount(str));
		
	}	
	
	//метод подсчета цифр в строке
	public static int getDigitsCount(String str) {
		char[] strCharArr = str.toCharArray();
		int count = 0;
		
		for (int i = 0; i < strCharArr.length; i++) {
			if (Character.isDigit(strCharArr[i])) {
				count++;
			}
		}
		return count;
	}

}
