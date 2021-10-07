package javaIntro_3_Strings;

public class ObjectStringPractice06 {
	
	// 6. Из заданной строки получить новую, повторив каждый символ дважды.

	public static void main(String[] args) {

		String str1 = "abcdefghijklmnopqrstuvwxyz";
		String str2 = new String();
		
		for (int i = 0; i < str1.length(); i++) {
			str2 = str2.concat(str1.substring(i,i+1) + str1.substring(i,i+1));
		}
	
		System.out.println(str2);
	}

}
