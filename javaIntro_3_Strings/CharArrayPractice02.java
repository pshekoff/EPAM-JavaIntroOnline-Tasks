package javaIntro_3_Strings;

public class CharArrayPractice02 {
	
	// 2. Замените в строке все вхождения 'word' на 'letter'.

	public static void main(String[] args) {
		
		String str = "1wordq tgNword [wordRRfh s20;wordletter";
		System.out.println("Исходная строка:\t\t" + str);
		
		for (int i = 0; i < str.length()-3; i++) {
			if (str.substring(i,i+4).equals("word")) {
				str = str.substring(0,i) + "letter" + str.substring(i+4, str.length());
				i += 5;
			}
		}
		System.out.println("\"word\" заменено на \"letter\":\t" + str);
	}

}
