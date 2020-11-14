package javaIntro_3_Strings;

public class CharArrayPractice04 {

	public static void main(String[] args) {
		
		String str = "e24wo5rq tgd243wod w80wors87dr4fe s20;we";
		System.out.println("Исходная строка:\t" + str);
		System.out.println("Кол-во чисел в строке:\t" + getNumCount(str));
		
	}	
	
	public static int getNumCount(String str) {
		
		char[] strCharArr = str.toCharArray();
		int count = 0;
		
		for (int i = 0; i < strCharArr.length; i++) {
			if (Character.isDigit(strCharArr[i])) {
				while (Character.isDigit(strCharArr[i])) {
					i++;
				}
				count++;
			}
		}
		
		return count;
	}

}
